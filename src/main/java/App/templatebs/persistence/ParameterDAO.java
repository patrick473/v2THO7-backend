package App.templatebs.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import App.helpers.JDBCSingleton;
/**
 * ParameterDAO
 */
public class ParameterDAO {

    JDBCSingleton jdbcInstance;

    public ParameterDAO() {
        this.jdbcInstance = JDBCSingleton.getInstance();
    }

    public boolean createParameter(int brtypeid, String key, String value, Connection con) {

        try {
         
            String statement = "insert into parameter(businessruletype,key,value) values(?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(statement);
            pstmt.setInt(1, brtypeid);
            pstmt.setString(2, key);
            pstmt.setString(3, value);
            int amount = pstmt.executeUpdate();
            ;
           
            return amount > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Map<String, String> getParameters(int id, Connection con) {
        Map<String, String> parameters = new HashMap<String, String>();
        try {
            
            PreparedStatement pstmt = con.prepareStatement("select * from parameter where businessruletype = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                parameters.put(rs.getString(3), rs.getString(4));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parameters;
    }
    public int deleteParametersByBusinessruleType(int type, Connection con) {
        int result = 0;
        try {
           
            PreparedStatement pstmt = con
                    .prepareStatement("delete from parameter where businessruletype=?");
            pstmt.setInt(1, type);
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}