package App.templatebs.model.serializers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import App.templatebs.model.Template;



public class TemplateDeserializer extends StdDeserializer<Template> {
    
    public TemplateDeserializer() {
        this(null);
    }
    public TemplateDeserializer(Class<Template> t){
        super(t);
    }

  
    @Override
    public Template deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        
        Map<String, String> bindings = new HashMap<String,String>();


     
		
   
 
        int id =0;
        if(node.has("id")){
            id = node.get("id").asInt();

        }
        Template arng = new Template(id,node.get("sqldialect").asInt(),node.get("businessruletype").asInt(),node.get("template").asText(),node.get("isconstraint").asBoolean());
        return arng;
    }
}