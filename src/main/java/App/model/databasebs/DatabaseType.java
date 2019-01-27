package App.model.databasebs;

/**
 * DatabaseType
 */
public class DatabaseType {

    private String _jdbcTypeCode;
    private String _triggerTemplate;

    public DatabaseType(String jdbcTypeCode, String triggerTemplate) {
        this._jdbcTypeCode = jdbcTypeCode;
        this._triggerTemplate = triggerTemplate;
    }

    public String jdbctypecode() {
        return this._jdbcTypeCode;
    }

    public String triggertemplate() {
        return this._triggerTemplate;
    }

}