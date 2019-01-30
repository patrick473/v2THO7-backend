package App.databasebs.persistence;

import App.databasebs.model.Column;
import App.databasebs.model.Database;
import App.databasebs.model.DatabaseType;
import App.databasebs.model.Table;
import App.helpers.JDBCSingleton;

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
                while(tablers.next()) {
                    //For each table, get columns and add them to an array list
                    ArrayList<Column> columns = new ArrayList<>();
                    PreparedStatement columnstatement = con.prepareStatement("select * from targetcolumn where targettable = ?");
                    columnstatement.setInt(1, tablers.getInt("id"));
                    ResultSet colrs = columnstatement.executeQuery();
                    while(colrs.next()) {
                        Column col = new Column(colrs.getInt("id"), colrs.getString("name"), colrs.getString("datatype"));
                        columns.add(col);
                    }

                    //Create the table and add them to list of tables belonging to the database
                    Table table = new Table(tablers.getInt("id"), tablers.getString("name"), columns);
                    tables.add(table);
                }

                if(typers.next()) {

                    DatabaseType type = new DatabaseType(
                            typers.getInt("id"),
                            typers.getString("dialect"),
                            typers.getString("triggertemplate")
                    );

                    Database database = new Database(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("host"),
                            rs.getString("schema"),
                            rs.getString("port"),
                            type,
                            tables
                            );
                    con.close();
                    return database;
                }
            }else {
                con.close();
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
