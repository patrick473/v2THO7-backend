package App.model.businessrulebs.Serializers;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import App.model.businessrulebs.BusinessRuleType;
import App.model.businessrulebs.Category;
import App.model.businessrulebs.Operator;

public class BusinessRuleTypeSerializer extends StdSerializer<BusinessRuleType> {
    
    public BusinessRuleTypeSerializer() {
        this(null);
    }
    public BusinessRuleTypeSerializer(Class<BusinessRuleType> t){
        super(t);
    }

    @Override
    public void serialize(BusinessRuleType value, JsonGenerator jgen, SerializerProvider provider) throws IOException,JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeStringField("id", value.id());
        jgen.writeStringField("name", value.name());
        jgen.writeStringField("nameCode", value.namecode());
        jgen.writeStringField("explanation", value.explanation());
        jgen.writeStringField("example", value.example());
        jgen.writeBooleanField("constraintPossible", value.constraintpossible());
        jgen.writeArrayFieldStart("possibleOperators");
        for (Operator operator : value.possibleoperators()) {
            jgen.writeObjectFieldStart("operator");
            jgen.writeStringField("name", operator.name());
            jgen.writeStringField("action", operator.action());
            jgen.writeEndObject();
        }
        jgen.writeEndArray();
        
        jgen.writeArrayFieldStart("parameters");
        for ( Map.Entry<String,String> parameter : value.parameters().entrySet()) {
            jgen.writeObjectFieldStart(parameter.getKey());
            
            jgen.writeStringField("datatype", parameter.getValue());
            jgen.writeEndObject();
        }
        jgen.writeEndArray();
        jgen.writeObjectFieldStart("category");
        jgen.writeStringField("name",value.category().name() );
        jgen.writeEndObject();
        jgen.writeEndObject();
    }
}