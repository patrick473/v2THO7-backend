package App.model;

public class EntityOtherRule extends StrictDataConstraint implements ISerializable{
    private String statement;
    private String otherColumn;
    private String otherTable;

    @Override
    public String generateCode() {
        return "Beep";
    }
}