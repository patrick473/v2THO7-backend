package App.model.businessrulebs;

import java.util.ArrayList;
import java.util.Map;

/**
 * BusinessRuleType
 */
public class BusinessRuleType {

    private String _id;
    private String _name;
    private String _nameCode;
    private String _explanation;
    private String _example;
    private boolean _constraintPossible;
    private ArrayList<Operator> _possibleOperators;
    private Map<String, String> _parameters;
    private Category _category;

    BusinessRuleType(String id,String name, String nameCode, String explanation, String example, boolean constraintPossible,
            ArrayList<Operator> possibleOperators, Map<String, String> parameters, Category category) {
        this._id = id;
        this._name = name;
        this._nameCode = nameCode;
        this._explanation = explanation;
        this._example = example;
        this._constraintPossible = constraintPossible;
        this._possibleOperators = possibleOperators;
        this._parameters = parameters;
        this._category = category;
    }

    public String id() {
        return this._id;
    }
    public String name() {
        return this._name;
    }

    public String namecode() {
        return this._nameCode;
    }

    public String explanation() {
        return this._explanation;
    }

    public String example() {
        return this._example;
    }

    public boolean constraintpossible() {
        return this._constraintPossible;
    }

    public ArrayList<Operator> possibleoperators() {
        return this._possibleOperators;
    }

    public Map<String, String> parameters() {
        return this._parameters;
    }

    public Category category() {
        return this._category;
    }

}