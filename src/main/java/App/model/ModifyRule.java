package App.model;

public class ModifyRule extends BusinessRule implements ISerializable{

    private String code;
    @Override
    public String generateCode() {
        return "Beep";
    }
}