package App.persistence;

import App.model.databasebs.Database;
import App.model.databasebs.DatabaseType;
import App.model.databasebs.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DatabaseDAO {

    JDBCSingleton jdbcInstance;
    public DatabaseDAO() {
        this.jdbcInstance = JDBCSingleton.getInstance();
    }

    public Database getDatabase(int id) {
        ArrayList<Table> tables = new ArrayList<Table>();
        try {

            Connection con = this.jdbcInstance.getConnection();
            String stmt = "select * from database where id = ?";
            PreparedStatement pstmt = con.prepareStatement(stmt);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {
                stmt = "select * from databasetype where id = ?";
                pstmt = con.prepareStatement(stmt);
                pstmt.setInt(1, rs.getInt("databasetype"));
                ResultSet typers = pstmt.executeQuery();

                stmt = "select * from targettable where database = ?";
                pstmt = con.prepareStatement(stmt);
                pstmt.setInt(1, rs.getInt("databasetype"));
                ResultSet tablers = pstmt.executeQuery();

                //TODO: make arraylist of tables in database

                if(typers.next()) {

                    DatabaseType type = new DatabaseType(
                            typers.getString("dialect"),
                            typers.getString("triggertemplate")
                    );

                    Database database = new Database(
                            rs.getString("name"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("host"),
                            rs.getString("schema"),
                            rs.getString("port"),
                            type,
                            tables
                            );

                    return database;
                }
            }else {
                return null;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
