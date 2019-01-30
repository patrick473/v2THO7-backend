package App.businessrulebs.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import App.businessrulebs.model.BusinessRule;

import App.helpers.JDBCSingleton;



/**
 * BusinessruleTypeDAO
 */
public class BusinessruleDAO {

    private JDBCSingleton jdbcInstance;
    private BindingDAO bdao;

    public BusinessruleDAO() {
        this.jdbcInstance = JDBCSingleton.getInstance();
        this.bdao = new BindingDAO();

    }

    public boolean createBusinessrule(BusinessRule br) {
        try {
            Connection con = this.jdbcInstance.getConnection();

            String statement = "insert into businessrule(targettable,businessruletype,name,operator,applied,constraint, onInsert,onUpdate,onDelete,error) values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, br.table());
            pstmt.setInt(2, br.type());
            pstmt.setString(3, br.name());
            System.out.print(br.operator());
            pstmt.setInt(4, br.operator());
            if (br.applied()) {
                pstmt.setString(5, "1");
            } else {
                pstmt.setString(5, "0");
            }
            if (br.constraint()) {
                pstmt.setString(6, "1");
            } else {
                pstmt.setString(6, "0");
            }

            if (br.insert()) {
                pstmt.setString(7, "1");
            } else {
                pstmt.setString(7, "0");
            }

            if (br.update()) {
                pstmt.setString(8, "1");
            } else {
                pstmt.setString(8, "0");
            }

            if (br.delete()) {
                pstmt.setString(9, "1");
            } else {
                pstmt.setString(9, "0");
            }
            pstmt.setString(10, br.error());

            int id = this.findID(br.name());
            boolean result = pstmt.executeUpdate() == 1;
            for (Map.Entry<String, String> binding : br.bindings().entrySet()) {
                this.bdao.createBinding(id, binding.getKey(), binding.getValue(),con);
            }

            if(result) {
                con.close();
                return true;
            }
            else{
                con.close();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public BusinessRule getSingleRule(int id) {
        try {
            Connection con = this.jdbcInstance.getConnection();
            PreparedStatement stmt = con.prepareStatement("select * from businessrule where id = ?");
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {

                //Get the bindings of the businessrule
                PreparedStatement getBindings = con.prepareStatement("select * from binding where businessrule = ?");
                getBindings.setInt(1, rs.getInt("id"));
                ResultSet bd = getBindings.executeQuery();

                HashMap<String, String> bindings = new HashMap<>();

                while(bd.next()) {
                    bindings.put(bd.getString("key"), bd.getString("value"));
                }


                BusinessRule br = new BusinessRule(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBoolean("applied"),
                        rs.getInt("operator"),
                        bindings,
                        rs.getInt("businessruletype"),
                        rs.getBoolean("constraint"),
                        rs.getInt("targettable"),
                        rs.getBoolean("oninsert"),
                        rs.getBoolean("onupdate"),
                        rs.getBoolean("ondelete"),
                        rs.getString("error")
                );

                con.close();
                return br;
            }
            else {
                return null;
            }

        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<BusinessRule> getAllRules() {
        ArrayList<BusinessRule> rules = new ArrayList<>();
        HashMap<String, String> emptyList = new HashMap<>();
        try{
            Connection con = this.jdbcInstance.getConnection();
            PreparedStatement stmt = con.prepareStatement("select * from businessrule");

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                BusinessRule br = new BusinessRule(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBoolean("applied"),
                        rs.getInt("operator"),
                        emptyList,
                        rs.getInt("businessruletype"),
                        rs.getBoolean("constraint"),
                        rs.getInt("targettable"),
                        rs.getBoolean("oninsert"),
                        rs.getBoolean("onupdate"),
                        rs.getBoolean("ondelete"),
                        rs.getString("error")
                );

                rules.add(br);
            }
            con.close();
            return rules;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }


    }
 
    private int findID(String name) {
        try {
            Connection con = this.jdbcInstance.getConnection();

            PreparedStatement stmt = con.prepareStatement("select id from businessrule where name=?");
            stmt.setString(1, name);

            ResultSet rs = stmt.executeQuery();
            int id = 0;
            if (rs.next()) {

                id = rs.getInt("id");
            }

            con.close();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public BusinessRule updateBusinessRule(BusinessRule br) {
        try {
            BindingDAO binddao = new BindingDAO();
            Connection con = this.jdbcInstance.getConnection();

            PreparedStatement stmt = con.prepareStatement("update businessrule set name = ?, targettable = ?, businessruletype = ?, operator = ?, applied = ?, constraint = ?, oninsert = ?, onupdate = ?, ondelete = ?, error = ? where id = ?");
            stmt.setString(1, br.name());
            stmt.setInt(2, br.table());
            stmt.setInt(3, br.type());
            stmt.setInt(4, br.operator());
            stmt.setBoolean(5, br.applied());
            stmt.setBoolean(6, br.constraint());
            stmt.setBoolean(7, br.insert());
            stmt.setBoolean(8, br.update());
            stmt.setBoolean(9, br.delete());
            stmt.setString(10, br.error());
            stmt.setInt(11, br.id());

            if(stmt.executeUpdate() == 1) {
                binddao.deleteBindingByRule(br.id(),con);
                for (Map.Entry<String, String> binding : br.bindings().entrySet()) {
                    binddao.createBinding(br.id(), binding.getKey(), binding.getValue(),con);
                }
                con.close();
                return br;
            }
            else {
                con.close();
                return null;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteBusinessRule(int id) {
        try {
            Connection con = this.jdbcInstance.getConnection();
            BindingDAO binddao = new BindingDAO();
            binddao.deleteBindingByRule(id,con);
            PreparedStatement stmt = con.prepareStatement("delete from businessrule where id = ?");
            stmt.setInt(1, id);

            if(stmt.executeUpdate() == 1) {
                con.close();
                return true;
            }
            else {
                con.close();
                return false;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean applyRule(int id, int applied) {
        try {
            BindingDAO binddao = new BindingDAO();
            Connection con = this.jdbcInstance.getConnection();

            PreparedStatement stmt = con.prepareStatement("update businessrule set applied = ? where id = ?");
            stmt.setInt(1, applied);
            stmt.setInt(2, id);


            if(stmt.executeUpdate() == 1) {
                con.close();
                return true;
            }
            else {
                con.close();
                return false;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}