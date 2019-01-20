package App.model.templatebs;

/**
 * Category
 */
public class Category {

    private int _id;
    private String _name;

    public Category(){}
    public Category(int id,String name){
        this._id = id;
        this._name = name;
    }

    public int id() {
        return this._id;
    }
    public String name(){
        return this._name;
    }

}