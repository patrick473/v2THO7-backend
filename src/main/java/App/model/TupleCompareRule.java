package App.model;

public class TupleCompareRule extends StrictDataConstraint<TupleCompareRule> implements ISerializable {

    private String otherColumn;
    private String comparisonType;

    public TupleCompareRule() {
        super(TupleCompareRule.class);
    }

    public TupleCompareRule otherColumn(String otherColumn) {
        this.otherColumn = otherColumn;
        return self;
    }

    public TupleCompareRule comparisonType(String comparisonType) {
        this.comparisonType = comparisonType;
        return self;
    }

    public String getOthercolumn() {
        return this.otherColumn;
    }

    public String getComparisontype() {
        return this.comparisonType;
    }

    @Override
    public String generateCode() {
        return "code";
    }
}