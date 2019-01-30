package App.databasebs.model;


public class Column {

    private String _name;
    private String _dataType;

    Column(String name, String dataType) {
        this._name = name;
        this._dataType = dataType;
    }

    public String name() {
        return this._name;
    }

    public String datatype() {
        return this._dataType;
    }

}