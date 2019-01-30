package App.databasebs.services;

import App.databasebs.model.Database;
import App.databasebs.model.DatabaseType;

import App.databasebs.persistence.DatabaseDAO;

public class DatabaseService {

    DatabaseDAO dbdao = new DatabaseDAO();

    public Database getDatabase(int id) {
        return dbdao.getDatabase(id);
    }



}
