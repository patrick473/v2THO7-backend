package App.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * ParameterDAO
 */
public class BindingDAO {

    JDBCSingleton jdbcInstance;
    public BindingDAO() {
        this.jdbcInstance = JDBCSingleton.getInstance();
    }

    public boolean createBinding(int brid,String key,String value, Connection con) {

        try {
            
            String statement = "insert into binding(businessrule,key,value) values(?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(statement);
            pstmt.setInt(1,brid);
            pstmt.setString(2,key);
            pstmt.setString(3, value);
            int amount = pstmt.executeUpdate();
           ;
          
            return amount > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteBindingByRule(int id,Connection con) {
        try {
          
            String statement = "delete from binding where businessrule = ?";
            PreparedStatement pstmt = con.prepareStatement(statement);
            pstmt.setInt(1, id);

            if(pstmt.executeUpdate() == 1) {
               
                return true;
            }
            else {
                
                return false;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}