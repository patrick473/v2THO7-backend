package App.model;

import javax.json.JsonObject;

public class AttributeListRule extends StrictDataConstraint<AttributeListRule> implements ISerializable {

    private JsonObject list;
    private boolean inList;

    AttributeListRule() {
        super(AttributeListRule.class);
    }

    public AttributeListRule list(JsonObject list) {
        this.list = list;
        return self;

    }

    public AttributeListRule inList(Boolean inList) {
        this.inList = inList;
        return self;

    }

    public JsonObject getList() {
        return this.list;
    }

    public boolean getInlist() {
        return this.inList;
    }

    @Override
    public String generateCode() {
        return "beep";
    }

}