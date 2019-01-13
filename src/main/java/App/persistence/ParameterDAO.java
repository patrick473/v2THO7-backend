package App.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}