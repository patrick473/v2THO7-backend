package App.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import App.model.businessrulebs.BusinessRuleType;
import App.model.businessrulebs.Operator;

/**
 * BusinessruleTypeDAO
 */
public class BusinessruleTypeDAO {

    private JDBCSingleton jdbcInstance;
    private OperatorDAO odao;
    private ParameterDAO pdao;
    public BusinessruleTypeDAO(){
        this.jdbcInstance = JDBCSingleton.getInstance();
        this.odao = new OperatorDAO();
        this.pdao = new ParameterDAO();
    }

    public boolean createBusinessruleType(BusinessRuleType brtype){
        try{
            Connection con = this.jdbcInstance.getConnection();

            String statement = "insert into businessruletype(category,name,namecode,explanation,example,constraintpossible) values(?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, brtype.category().id());
            pstmt.setString(2, brtype.name());
            pstmt.setString(3, brtype.namecode());
            pstmt.setString(4, brtype.explanation());
            pstmt.setString(5, brtype.example());
            if(brtype.constraintpossible()){
                pstmt.setString(6, "1");
            }
            else{
                pstmt.setString(6, "0");
            }
            int amount = pstmt.executeUpdate();
            
            int id = this.findID(brtype.name());

            System.out.print(id);
            for (Operator op : brtype.possibleoperators()) {
                this.odao.createOperator(id, op);
            }
            for ( Map.Entry<String,String> parameter : brtype.parameters().entrySet()) {
                this.pdao.createParameter(id, parameter.getKey(), parameter.getValue());
            }
            con.close();
            return amount > 0;
        }catch(Exception e) {
             e.printStackTrace();
             return false;
        }
    }
    public void getSomething(){
        try{
        Connection con = this.jdbcInstance.getConnection();

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery("select * from targettable");
        
        while (rs.next()) {
            
            System.out.println(rs.getString("name"));
        }
        con.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    private int findID(String name){
        try{
            Connection con = this.jdbcInstance.getConnection();
    
            PreparedStatement stmt = con.prepareStatement("select id from businessruletype where name=?");
            stmt.setString(1, name);
    
            ResultSet rs = stmt.executeQuery();
            int id = 0;
            if(rs.next()){
                
               
                id = rs.getInt("id");
            }
            
                
               
           
            con.close();
            return id;
            }
            catch(Exception e) {
                e.printStackTrace();
                return 0;
            }
    }

}