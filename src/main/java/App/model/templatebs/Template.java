package App.model.templatebs;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import App.model.templatebs.serializers.TemplateDeserializer;
import App.model.templatebs.serializers.TemplateSerializer;

/**
 * Template
 */
@JsonSerialize(using = TemplateSerializer.class)
@JsonDeserialize(using = TemplateDeserializer.class)
public class Template {

    private int _id;
    private int _sqlDialect;
    private int _businessruleType;
    private String _templateString;
    private boolean _isConstraint;

    public Template(int id,int sqlDialect, int businessRuleType, String templateString, boolean isConstraint) {
        this._id = id;
        this._sqlDialect = sqlDialect;
        this._businessruleType = businessRuleType;
        this._templateString = templateString;
        this._isConstraint = isConstraint;
    }

    public int id() {
        return this._id;
    }
    public int sqldialect() {
        return this._sqlDialect;
    }

    public int businessruleType() {
        return this._businessruleType;
    }

    public String templatestring() {
        return this._templateString;
    }
    public boolean isConstraint() {
        return this._isConstraint;
    }

}