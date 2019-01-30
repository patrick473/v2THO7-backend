package App.databasebs.model;

import java.util.ArrayList;

public class Table {

    private int _id;
    private String _name;
    private ArrayList<Column> _columns;

    public Table(int id, String name, ArrayList<Column> columns) {
        this._id = id;
        this._name = name;
        this._columns = columns;
    }

    public Table(String name, ArrayList<Column> columns) {
        this._name = name;
        this._columns = columns;
    }

    public int id() { return this._id; }

    public String name() {
        return this._name;
    }

    public ArrayList<Column> columns() {
        return this._columns;
    }

}