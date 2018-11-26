package App.model;

public class TupleCompareRule extends StrictDataConstraint implements ISerializable{

    public String otherColumn;
    public String comparisonType;
    @Override
    public String generateCode() {
        return "code";
    }
}