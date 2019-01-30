package App.templatebs.model;

/**
 * Operator
 */
public class Operator {

    private int _id;
    private String _name;
    private String _action;

    public Operator(){};
    public Operator(int id,String name, String action){
        this._id = id;
        this._name = name;
        this._action = action;
    }

    public String name(){
        return this._name;
    }   
    public String action(){
        return this._action;
    }
    public int id(){
        return this._id;
    }
}