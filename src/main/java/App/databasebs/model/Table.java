package App.databasebs.model;

import java.util.ArrayList;

public class Table {

    private String _name;
    private ArrayList<Column> _columns;

    Table(String name, ArrayList<Column> columns) {
        this._name = name;
        this._columns = columns;
    }

    public String name() {
        return this._name;
    }

    public ArrayList<Column> columns() {
        return this._columns;
    }

}