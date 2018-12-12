package App.model;

public abstract class StrictDataConstraint<T extends StrictDataConstraint<?>> extends BusinessRule<T> {
    protected T self;
    protected boolean constraintPossible;
    protected String column;
    protected String table;

    StrictDataConstraint(final Class<T> selfClass) {
        super(selfClass);
        this.self = selfClass.cast(this);
    }

    public T constraintPossible(boolean constraintPossible) {
        this.constraintPossible = constraintPossible;
        return self;
    }

    public T column(String column) {
        this.column = column;
        return self;
    }

    public T table(String table) {
        this.table = table;
        return self;
    }

    public boolean getConstraintpossible() {
        return this.constraintPossible;
    }

    public String getColumn() {
        return this.column;
    }

    public String getTable() {
        return this.table;
    }

}