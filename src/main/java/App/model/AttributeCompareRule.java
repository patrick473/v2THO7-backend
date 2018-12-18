package App.model;

public class AttributeCompareRule extends StrictDataConstraint<AttributeCompareRule> implements ISerializable {

    private String comparisonType;
    private String otherColumn;

    public AttributeCompareRule() {
        super(AttributeCompareRule.class);

    }

    public AttributeCompareRule comparisonType(String comparisonType) {
        this.comparisonType = comparisonType;
        return self;
    }

    public AttributeCompareRule otherColumn(String otherColumn) {
        this.otherColumn = otherColumn;
        return self;
    }

    public String getComparisonType() {
        return this.comparisonType;
    }

    public String getOtherColumn() {
        return this.otherColumn;
    }

    @Override
    public String generateCode() {
        return "beep";
    }
}