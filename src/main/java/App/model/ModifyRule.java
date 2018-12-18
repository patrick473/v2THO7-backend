package App.model;

public class ModifyRule extends BusinessRule<ModifyRule> implements ISerializable{

    private String code;

    public ModifyRule() {
        super(ModifyRule.class);
    }

    public ModifyRule code(String code) {
        this.code = code;
        return self;
    }

    public String getCode() {
        return this.code;
    }

    @Override
    public String generateCode() {
        return "Beep";
    }
}