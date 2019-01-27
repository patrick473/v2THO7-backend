package App.services;

import App.model.databasebs.Database;
import App.model.databasebs.DatabaseType;

import App.persistence.DatabaseDAO;

public class DatabaseService {

    DatabaseDAO dbdao = new DatabaseDAO();

    public Database getDatabase(int id) {
        return dbdao.getDatabase(id);
    }

    public DatabaseType getDatabaseType(int id) {
        return dbdao.getDatabaseType();
    }

}
