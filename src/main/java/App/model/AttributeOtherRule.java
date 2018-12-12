package App.model;

public class AttributeOtherRule extends StrictDataConstraint<AttributeOtherRule> implements ISerializable {

    private String statement;

    AttributeOtherRule() {
        super(AttributeOtherRule.class);
    }

    public AttributeOtherRule statement(String statement) {
        this.statement = statement;
        return self;
    }

    public String getStatement() {
        return this.statement;
    }

    @Override
    public String generateCode() {
        return "beep";
    }
}