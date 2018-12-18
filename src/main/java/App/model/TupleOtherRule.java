package App.model;

public class TupleOtherRule extends StrictDataConstraint<TupleOtherRule> implements ISerializable {
    private String statement;
    private String otherColumn;

    public TupleOtherRule() {
        super(TupleOtherRule.class);
    }

    public TupleOtherRule statement(String statement) {
        this.statement = statement;
        return self;
    }

    public TupleOtherRule otherColumn(String otherColumn) {
        this.otherColumn = otherColumn;
        return self;
    }

    public String getStatement() {
        return this.statement;
    }

    public String getOthercolumn() {
        return this.otherColumn;
    }

    @Override
    public String generateCode() {
        return "Beep";
    }
}