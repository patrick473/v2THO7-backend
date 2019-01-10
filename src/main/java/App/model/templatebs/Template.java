package App.model.templatebs;

import App.model.businessrulebs.BusinessRuleType;

/**
 * Template
 */
public class Template {

    private DatabaseType _sqlDialect;
    private BusinessRuleType _businessruleType;
    private String _templateString;

    Template(DatabaseType sqlDialect, BusinessRuleType businessRuleType, String templateString) {
        this._sqlDialect = sqlDialect;
        this._businessruleType = businessRuleType;
        this._templateString = templateString;
    }

    public DatabaseType sqldialect() {
        return this._sqlDialect;
    }

    public BusinessRuleType businessruleType() {
        return this._businessruleType;
    }

    public String templatestring() {
        return this._templateString;
    }

}