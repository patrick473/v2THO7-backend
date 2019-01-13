package App.persistence;


import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

class JDBCSingleton {

    private static JDBCSingleton jdbc;

    private JDBCSingleton() {
    }

    public static JDBCSingleton getInstance() {
        if (jdbc == null) {
            jdbc = new JDBCSingleton();
        }
        return jdbc;
    }

    public  Connection getConnection() throws ClassNotFoundException, SQLException {

        Connection con = null;
        con = DriverManager.getConnection("jdbc:oracle:thin:@//ondora04.hu.nl:8521/EDUC14", "tool", "tooldb");
        return con;

    }

}