package App.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import App.model.businessrulebs.BusinessRule;
import App.model.businessrulebs.BusinessRuleType;
import App.model.businessrulebs.Operator;

/**
 * BusinessruleTypeDAO
 */
public class BusinessruleDAO {

    private JDBCSingleton jdbcInstance;
    private OperatorDAO odao;
    private ParameterDAO pdao;
    public BusinessruleDAO(){
        this.jdbcInstance = JDBCSingleton.getInstance();
        
    }

    public boolean createBusinessrule(BusinessRule br){
        try{
            Connection con = this.jdbcInstance.getConnection();

            String statement = "insert into businessrule(targettable,businessruletype,name,operator,applied,constraint) values(?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, br.table());
            pstmt.setInt(2, br.type());
            pstmt.setString(3, br.name());
            System.out.print(br.operator());
            pstmt.setInt(4, br.operator());
            if(br.applied()){
                pstmt.setString(5, "1");
            }
            else{
                pstmt.setString(5, "0");
            }  
            if(br.constraint()){
                pstmt.setString(6, "1");
            }
            else{
                pstmt.setString(6, "0");
            }

            int amount = pstmt.executeUpdate();
            
            int id = this.findID(br.name());

            System.out.print(id);
           
    
            con.close();
            return amount > 0;
        }catch(Exception e) {
             e.printStackTrace();
             return false;
        }
    }
   
    private int findID(String name){
        try{
            Connection con = this.jdbcInstance.getConnection();
    
            PreparedStatement stmt = con.prepareStatement("select id from businessrule where name=?");
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