package App.templatebs.model.serializers;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;


import App.templatebs.model.Template;

public class TemplateSerializer extends StdSerializer<Template> {
    
    public TemplateSerializer() {
        this(null);
    }
    public TemplateSerializer(Class<Template> t){
        super(t);
    }

    @Override
    public void serialize(Template value, JsonGenerator jgen, SerializerProvider provider) throws IOException,JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeNumberField("id", value.id());
        jgen.writeNumberField("sqldialect", value.sqldialect());
        jgen.writeNumberField("businessruletype", value.businessruleType());
        jgen.writeStringField("template", value.templatestring());
        jgen.writeBooleanField("isconstraint", value.isConstraint());
        jgen.writeEndObject();
    }
    
}
