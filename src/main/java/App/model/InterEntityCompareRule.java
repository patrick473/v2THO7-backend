package App.model;

public class InterEntityCompareRule extends StrictDataConstraint<InterEntityCompareRule> implements ISerializable {
    private String comparisonType;
    private String otherColumn;
    private String otherTable;

    public InterEntityCompareRule() {
        super(InterEntityCompareRule.class);
    }

    public InterEntityCompareRule comparisonType(String comparisonType) {
        this.comparisonType = comparisonType;
        return self;
    }

    public InterEntityCompareRule otherColumn(String otherColumn) {
        this.otherColumn = otherColumn;
        return self;
    }

    public InterEntityCompareRule otherTable(String otherTable) {
        this.otherTable = otherTable;
        return self;
    }

    public String getcomparisonType() {
        return this.comparisonType;
    }

    public String getOthercolumn() {
        return this.otherColumn;
    }

    public String getOthertable() {
        return this.otherTable;
    }

    @Override
    public String generateCode() {
        return "Beep";
    }
}