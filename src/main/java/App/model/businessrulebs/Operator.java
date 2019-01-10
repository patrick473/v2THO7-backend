package App.model.businessrulebs;

/**
 * Operator
 */
public class Operator {

    private String _name;
    private String _action;

    Operator(String name, String action){
        this._name = name;
        this._action = action;
    }

    public String name(){
        return this._name;
    }   
    public String action(){
        return this._action;
    }
    
}