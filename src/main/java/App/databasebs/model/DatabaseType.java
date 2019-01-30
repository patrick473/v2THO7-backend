package App.databasebs.model;

import App.databasebs.model.serializers.DatabaseTypeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * DatabaseType
 */
@JsonSerialize(using = DatabaseTypeSerializer.class)
public class DatabaseType {

    private int _id;
    private String _jdbcTypeCode;
    private String _triggerTemplate;
    private String _constraintTemplate;

    public DatabaseType(int id, String jdbcTypeCode, String triggerTemplate, String constraintTemplate) {
        this._id = id;
        this._jdbcTypeCode = jdbcTypeCode;
        this._triggerTemplate = triggerTemplate;
        this._constraintTemplate = constraintTemplate;
    }

    public DatabaseType(String jdbcTypeCode, String triggerTemplate) {
        this._jdbcTypeCode = jdbcTypeCode;
        this._triggerTemplate = triggerTemplate;
    }

    public int id() { return this._id; }

    public String constrainttemplate() { return this._constraintTemplate; }

    public String jdbctypecode() {
        return this._jdbcTypeCode;
    }

    public String triggertemplate() {
        return this._triggerTemplate;
    }

}