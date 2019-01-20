package App.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 * ParameterDAO
 */
public class ParameterDAO {

    JDBCSingleton jdbcInstance;
    public ParameterDAO() {
        this.jdbcInstance = JDBCSingleton.getInstance();
    }

    public boolean createParameter(int brtypeid,String key,String value) {

        try {
            Connection con = this.jdbcInstance.getConnection();
            String statement = "insert into parameter(businessruletype,key,value) values(?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(statement);
            pstmt.setInt(1,brtypeid);
            pstmt.setString(2,key);
            pstmt.setString(3, value);
            int amount = pstmt.executeUpdate();
           ;
            con.close();
            return amount > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public Map<String,String> getParameters(int id){
        Map<String,String> parameters = new HashMap<String,String>();
        try {
            Connection con = this.jdbcInstance.getConnection();
            PreparedStatement pstmt = con.prepareStatement("select * from parameter where businessruletype = ?");
           
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                
                parameters.put(rs.getString(3),rs.getString(4));
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parameters;
    }
}