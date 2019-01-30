package App.databasebs.model;

/**
 * DatabaseType
 */
public class DatabaseType {

    private int _id;
    private String _jdbcTypeCode;
    private String _triggerTemplate;

    public DatabaseType(int id, String jdbcTypeCode, String triggerTemplate) {
        this._id = id;
        this._jdbcTypeCode = jdbcTypeCode;
        this._triggerTemplate = triggerTemplate;
    }

    public DatabaseType(String jdbcTypeCode, String triggerTemplate) {
        this._jdbcTypeCode = jdbcTypeCode;
        this._triggerTemplate = triggerTemplate;
    }

    public int id() { return this._id; }

    public String jdbctypecode() {
        return this._jdbcTypeCode;
    }

    public String triggertemplate() {
        return this._triggerTemplate;
    }

}