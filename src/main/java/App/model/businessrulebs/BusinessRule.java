package App.model.businessrulebs;

import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import App.model.businessrulebs.Serializers.BusinessRuleDeserializer;
import App.model.businessrulebs.Serializers.BusinessRuleSerializer;


/**
 * BusinessRule
 */
@JsonSerialize(using = BusinessRuleSerializer.class)
@JsonDeserialize(using = BusinessRuleDeserializer.class)
public class BusinessRule {

    private int _id;
    private String _name;
    private boolean _applied;
    private Operator _operator;
    private Map<String, String> _bindings;
    private int _type;
    private boolean _constraint;
    private int _table;

    public BusinessRule(int id, String name, boolean applied, Operator operator, Map<String, String> bindings,
            BusinessRuleType type,boolean constraint, int table) {
        this._id = id;
        this._name = name;
        this._applied = applied;
        this._operator = operator;
        this._bindings = bindings;
        this._type = type.id();
        this._constraint = constraint;
        this._table = table;
    } 
    public BusinessRule(int id, String name, boolean applied, Operator operator, Map<String, String> bindings,
    int type,boolean constraint,int table) {
        this._id = id;
        this._name = name;
        this._applied = applied;
        this._operator = operator;
        this._bindings = bindings;
        this._type = type;
        this._constraint = constraint;
        this._table = table;
}


    public int id() {
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

    public int type() {
        return this._type;
    }
    public boolean constraint(){
        return this._constraint;
    }

    public int table(){
        return this._table;
    }
}