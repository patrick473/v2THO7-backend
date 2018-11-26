package App.model;

import javax.json.JsonObject;

public class AttributeListRule extends StrictDataConstraint implements ISerializable{

    private JsonObject list;
    private boolean inList;

    AttributeListRule(JsonObject list,boolean inList,String column,String table){
        super()
    }

    @Override
    public String generateCode() {
        return "beep";
    }

}