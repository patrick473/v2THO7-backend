package App.model.databasebs;

import java.util.ArrayList;

import App.model.templatebs.DatabaseType;

public class Database {

    private String name;
    private String username;
    private String password;
    private String host;
    private String schema;
    private String port;
    private DatabaseType dialect;
    private ArrayList<Table> tables;
}