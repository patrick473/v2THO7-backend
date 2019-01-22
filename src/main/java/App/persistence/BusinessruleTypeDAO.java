package App.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import App.model.templatebs.BusinessRuleType;
import App.model.templatebs.Category;
import App.model.templatebs.Operator;

/**
 * BusinessruleTypeDAO
 */
public class BusinessruleTypeDAO {

    private JDBCSingleton jdbcInstance;
    private OperatorDAO odao;
    private ParameterDAO pdao;
    private CategoryDAO cdao;

    public BusinessruleTypeDAO() {
        this.jdbcInstance = JDBCSingleton.getInstance();
        this.odao = new OperatorDAO();
        this.pdao = new ParameterDAO();
        this.cdao = new CategoryDAO();
    }

    public int createBusinessruleType(BusinessRuleType brtype) {
        try {
            Connection con = this.jdbcInstance.getConnection();
            System.out.print('3');

            String statement = "insert into businessruletype(category,name,namecode,explanation,example,constraintpossible) values(?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, brtype.category().id());
            pstmt.setString(2, brtype.name());
            pstmt.setString(3, brtype.namecode());
            pstmt.setString(4, brtype.explanation());
            pstmt.setString(5, brtype.example());
            if (brtype.constraintpossible()) {
                pstmt.setString(6, "1");
            } else {
                pstmt.setString(6, "0");
            }
            int amount = pstmt.executeUpdate();

            int id = this.findID(con);
            brtype.setID(id);
            System.out.print(id);
            for (Operator op : brtype.possibleoperators()) {
                this.odao.createOperator(id, op,con);
            }
            for (Map.Entry<String, String> parameter : brtype.parameters().entrySet()) {
                this.pdao.createParameter(id, parameter.getKey(), parameter.getValue(),con);
            }
            con.close();
            return id ;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean updateBusinessRuleType(BusinessRuleType brtype) {
        try {
            Connection con = this.jdbcInstance.getConnection();
            System.out.print('3');

            String statement = "update businessruletype set category = ?,name = ?,namecode = ?,explanation = ?,example = ?,constraintpossible = ? where id =?";
            PreparedStatement pstmt = con.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, brtype.category().id());
            pstmt.setString(2, brtype.name());
            pstmt.setString(3, brtype.namecode());
            pstmt.setString(4, brtype.explanation());
            pstmt.setString(5, brtype.example());
            if (brtype.constraintpossible()) {
                pstmt.setString(6, "1");
            } else {
                pstmt.setString(6, "0");
            }
            pstmt.setInt(7, brtype.id());
            int amount = pstmt.executeUpdate();

            this.odao.deleteOperatorsByBusinessruleType(brtype.id(),con);
            this.pdao.deleteParametersByBusinessruleType(brtype.id(),con);
            for (Operator op : brtype.possibleoperators()) {

                this.odao.createOperator(brtype.id(), op,con);
            }
            for (Map.Entry<String, String> parameter : brtype.parameters().entrySet()) {
                this.pdao.createParameter(brtype.id(), parameter.getKey(), parameter.getValue(),con);
            }
            con.close();
            return amount > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<BusinessRuleType> getAllTypes() {
        ArrayList<BusinessRuleType> brtypes = new ArrayList<BusinessRuleType>();
        try {
            Connection con = this.jdbcInstance.getConnection();
            ArrayList<Integer> typeids = this.findAllIDs();
            for (Integer id : typeids) {
                brtypes.add(this.getType(id,con));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return brtypes;
    }

    public BusinessRuleType getSingleType(int id){
        BusinessRuleType brtype = new BusinessRuleType();
        try{
            Connection con = this.jdbcInstance.getConnection();
            brtype  = this.getType(id, con);
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return brtype;
    }
    public BusinessRuleType getType(int id, Connection con) {
        BusinessRuleType brtype = new BusinessRuleType();
        try {
           

            PreparedStatement stmt = con.prepareStatement("select * from businessruletype where id=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Category category = this.cdao.getCategory(rs.getInt(2),con);
                Map<String, String> parameters = this.pdao.getParameters(id,con);
                boolean constraintPossible = false;
                if (rs.getInt(7) == 1) {
                    constraintPossible = true;
                }
                ArrayList<Operator> possibleOperators = this.odao.getOperators(id, con);
                brtype = new BusinessRuleType(id, rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        constraintPossible, possibleOperators, parameters, category);

            }
           
        } catch (Exception e) {
           
        }
        return brtype;
    }
    public boolean deleteType(int id){
        try {
            Connection con = this.jdbcInstance.getConnection();
            
            PreparedStatement pstmt = con.prepareStatement("update  businessruletype set active=0 where id = ?");
            pstmt.setInt(1, id);
            int amount = pstmt.executeUpdate();
            con.close();
            return amount > 0;
        } catch (Exception e) {
           
            return false;
        }
    }

    private int findID(Connection con) {
        try {
            
            PreparedStatement stmt = con.prepareStatement("select id from businessruletype where id=(select max(id) from businessruletype)");

            ResultSet rs = stmt.executeQuery();
            int id = 0;
            if (rs.next()) {

                id = rs.getInt("id");
            }

            return id;
        } catch (Exception e) {
           
            return 0;
        }
    }

    private ArrayList<Integer> findAllIDs() {
        ArrayList<Integer> ids = new ArrayList<Integer>();
        try {
            Connection con = this.jdbcInstance.getConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select id from businessruletype");

            while (rs.next()) {

                ids.add(rs.getInt(1));
            }
            con.close();
        } catch (Exception e) {
           
        }
        return ids;
    }

}