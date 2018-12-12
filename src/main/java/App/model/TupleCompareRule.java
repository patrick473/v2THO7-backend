package App.model;

public class TupleCompareRule extends StrictDataConstraint<TupleCompareRule> implements ISerializable {

    public String otherColumn;
    public String comparisonType;

    TupleCompareRule() {
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