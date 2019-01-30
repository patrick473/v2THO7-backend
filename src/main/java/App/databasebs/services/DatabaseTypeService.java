package App.databasebs.services;

import App.databasebs.model.DatabaseType;
import App.databasebs.persistence.DatabaseTypeDAO;

public class DatabaseTypeService {

    private DatabaseTypeDAO dbdao = new DatabaseTypeDAO();

    public DatabaseType getDatabaseType(int id) {
        return dbdao.getDatabaseType(id);
    }
}
