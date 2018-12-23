package App.model;

public class AttributeRangeRule extends StrictDataConstraint<AttributeRangeRule> implements ISerializable {

    private int rangeStart;
    private int rangeEnd;
    private boolean inRange;

    public AttributeRangeRule() {
        super(AttributeRangeRule.class);
    }

    public AttributeRangeRule rangeStart(int rangeStart) {
        this.rangeStart = rangeStart;
        return self;
    }

    public AttributeRangeRule rangeEnd(int rangeEnd) {
        this.rangeEnd = rangeEnd;
        return self;
    }

    public AttributeRangeRule inRange(boolean inRange) {
        this.inRange = inRange;
        return self;
    }

    public int getRangestart() {
        return this.rangeStart;
    }

    public int getRangeend() {
        return this.rangeEnd;
    }

    public boolean getInrange() {
        return this.inRange;
    }

    @Override
    public String generateCode() {
        return "Code";
    }
}