package App.model;

public class AttributeOtherRule extends StrictDataConstraint implements ISerializable{

    private String statement;
    
    @Override
    public String generateCode() {
        return "beep" ;
    }
}