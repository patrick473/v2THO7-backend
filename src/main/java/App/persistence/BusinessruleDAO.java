package App.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import App.model.businessrulebs.BusinessRule;


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

            for (Map.Entry<String, String> binding : br.bindings().entrySet()) {
                this.bdao.createBinding(id, binding.getKey(), binding.getValue());
            }

            if(pstmt.executeUpdate() == 1) {
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



}