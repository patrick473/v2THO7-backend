package App.model.businessrulebs;

import java.util.Map;


/**
 * BusinessRule
 */

public class BusinessRule {

    private String _id;
    private String _name;
    private boolean _applied;
    private Operator _operator;
    private Map<String, String> _bindings;
    private BusinessRuleType _type;

    public BusinessRule(String id, String name, boolean applied, Operator operator, Map<String, String> bindings,
            BusinessRuleType type) {
        this._id = id;
        this._name = name;
        this._applied = applied;
        this._operator = operator;
        this._bindings = bindings;
        this._type = type;
    }

    public String id() {
        return this._id;
    }

    public String name() {
        return this._name;
    }

    public boolean applied() {
        return this._applied;
    }

    public Operator operator() {
        return this._operator;
    }

    public Map<String, String> bindings() {
        return this._bindings;
    }

    public BusinessRuleType type() {
        return this._type;
    }

}