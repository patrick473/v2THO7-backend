package App.model;

public class AttributeRangeRule extends StrictDataConstraint implements ISerializable{

    private int rangeStart;
    private int rangeEnd;
    private boolean inRange;
    @Override
    public String generateCode() {
        return "Code";
    }
}