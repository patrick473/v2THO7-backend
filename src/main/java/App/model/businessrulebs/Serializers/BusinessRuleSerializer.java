package App.model.businessrulebs.Serializers;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import App.model.businessrulebs.BusinessRule;

public class BusinessRuleSerializer extends StdSerializer<BusinessRule> {
    
    public BusinessRuleSerializer() {
        this(null);
    }
    public BusinessRuleSerializer(Class<BusinessRule> t){
        super(t);
    }

    @Override
    public void serialize(BusinessRule value, JsonGenerator jgen, SerializerProvider provider) throws IOException,JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeNumberField("id", value.id());
        jgen.writeStringField("name", value.name());
        jgen.writeBooleanField("applied", value.applied());
        jgen.writeBooleanField("constraint", value.constraint());
        jgen.writeNumberField("operator", value.operator());
        jgen.writeArrayFieldStart("bindings");
        for ( Map.Entry<String,String> binding : value.bindings().entrySet()) {
            jgen.writeStartObject();
            jgen.writeStringField("key",binding.getKey());
            jgen.writeStringField("value", binding.getValue());
            jgen.writeEndObject();
        }
        jgen.writeEndArray();
        jgen.writeNumberField("type", value.type());
        jgen.writeNumberField("table", value.table());
        jgen.writeBooleanField("insert", value.insert());
        jgen.writeBooleanField("update", value.update());
        jgen.writeBooleanField("delete", value.delete());
        jgen.writeStringField("error", value.error());
        jgen.writeEndObject();
    }
    
}