package App.databasebs.model;


public class Column {

    private int _id;
    private String _name;
    private String _dataType;

    public Column(String name, String dataType) {
        this._name = name;
        this._dataType = dataType;
    }

    public Column(int id, String name, String dataType) {
        this._id = id;
        this._name = name;
        this._dataType = dataType;
    }

    public int id() { return this._id; }

    public String name() {
        return this._name;
    }

    public String datatype() {
        return this._dataType;
    }

}