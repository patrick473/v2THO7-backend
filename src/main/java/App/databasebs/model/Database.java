package App.databasebs.model;

import java.util.ArrayList;



public class Database {

    private String _name;
    private String _username;
    private String _password;
    private String _host;
    private String _schema;
    private String _port;
    private DatabaseType _dialect;
    private ArrayList<Table> _tables;

    public Database(String name, String username, String password, String host, String schema, String port,
            DatabaseType dialect, ArrayList<Table> tables) {
        this._name = name;
        this._username = username;
        this._password = password;
        this._host = host;
        this._schema = schema;
        this._port = port;
        this._dialect = dialect;
        this._tables = tables;
    }

    public String name() {
        return this._name;
    }

    public String username() {
        return this._username;
    }

    public String password() {
        return this._password;
    }

    public String host() {
        return this._host;
    }

    public String schema() {
        return this._schema;
    }

    public String port() {
        return this._port;
    }

    public DatabaseType dialect() {
        return this._dialect;
    }

    public ArrayList<Table> tables() {
        return this._tables;
    }
}