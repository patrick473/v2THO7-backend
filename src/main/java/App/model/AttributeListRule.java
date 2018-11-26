package App.model;

import javax.json.JsonObject;

public class AttributeListRule extends StrictDataConstraint implements ISerializable{

    private JsonObject list;
    private boolean inList;
    @Override
    public String generateCode() {
        return "beep";
    }
}