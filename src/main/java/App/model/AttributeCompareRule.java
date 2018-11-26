package App.model;

public class AttributeCompareRule extends StrictDataConstraint implements ISerializable{

    private String comparisonType;
    private String otherColumn;
    
    @Override
    public String generateCode() {
        return "beep" ;
    }
}