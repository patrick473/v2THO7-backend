package App.databasebs.persistence;

import App.databasebs.model.DatabaseType;
import App.helpers.JDBCSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseTypeDAO {

    JDBCSingleton jdbcInstance;
    public DatabaseTypeDAO() {
        this.jdbcInstance = JDBCSingleton.getInstance();
    }

    public DatabaseType getDatabaseType(int id) {
        try{
            Connection con = this.jdbcInstance.getConnection();
            String stmt = "select * from databasetype where id = ?";
            PreparedStatement pstmt = con.prepareStatement(stmt);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {
                DatabaseType dbtype = new DatabaseType(
                        rs.getInt("id"),
                        rs.getString("dialect"),
                        rs.getString("triggertemplate"),
                        rs.getString("constrainttemplate")
                );
                return dbtype;
            }
            else {
                return null;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
