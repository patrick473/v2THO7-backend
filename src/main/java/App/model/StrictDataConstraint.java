package App.model;

public abstract class StrictDataConstraint extends BusinessRule{
    protected boolean constraintPossible;
    protected String column;
    protected String table;

}