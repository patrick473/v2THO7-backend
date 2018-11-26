package App.model;

public class TupleOtherRule extends StrictDataConstraint implements ISerializable{
    private String statement;
    private String otherColumn;

    @Override
    public String generateCode() {
        return "Beep";
    }
}