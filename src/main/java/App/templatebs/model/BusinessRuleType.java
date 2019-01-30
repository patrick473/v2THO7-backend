package App.templatebs.model;

import java.util.ArrayList;
import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import App.templatebs.model.serializers.BusinessRuleTypeDeserializer;
import App.templatebs.model.serializers.BusinessRuleTypeSerializer;

/**
 * BusinessRuleType
 */   
@JsonSerialize(using = BusinessRuleTypeSerializer.class)
@JsonDeserialize(using = BusinessRuleTypeDeserializer.class)
public class BusinessRuleType {

    private int _id;
    private String _name;
    private String _nameCode;
    private String _explanation;
    private String _example;
    private boolean _constraintPossible;
    private ArrayList<Operator> _possibleOperators;
    private Map<String, String> _parameters;
    private Category _category;

 
    public BusinessRuleType(){}
    public BusinessRuleType(int id,String name, String nameCode, String explanation, String example, boolean constraintPossible) {
                
        this._id = id;
        this._name = name;
        this._nameCode = nameCode;
        this._explanation = explanation;
        this._example = example;
        this._constraintPossible = constraintPossible;
        
    }
    public BusinessRuleType(int id,String name, String nameCode, String explanation, String example, boolean constraintPossible,
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


    public int id() {
        return this._id;
    }
    public void setID(int id){
        this._id = id;
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

    @Override
    public String toString() {
        return "{" +
            " _id='" + id() + "'" +
            ", _name='" + name() + "'" +
            ", _nameCode='" + namecode() + "'" +
            ", _explanation='" + explanation() + "'" +
            ", _example='" + example() + "'" +
            ", _constraintPossible='" + constraintpossible() + "'" +
            ", _possibleOperators='" + possibleoperators() + "'" +
            ", _parameters='" + parameters() + "'" +
            ", _category='" + category() + "'" +
            "}";
    }
}