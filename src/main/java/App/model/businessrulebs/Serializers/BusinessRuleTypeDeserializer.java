package App.model.businessrulebs.Serializers;

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

import App.model.businessrulebs.BusinessRuleType;
import App.model.businessrulebs.Category;
import App.model.businessrulebs.Operator;

public class BusinessRuleTypeDeserializer extends StdDeserializer<BusinessRuleType> {
    
    public BusinessRuleTypeDeserializer() {
        this(null);
    }
    public BusinessRuleTypeDeserializer(Class<BusinessRuleType> t){
        super(t);
    }

  
    @Override
    public BusinessRuleType deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        JsonNode Jsonparameters = node.get("parameters");
		JsonNode JsonOperators = node.get("possibleOperators");

        ArrayList<Operator> possibleOperators = new ArrayList<Operator>();
        Map<String, String> parameters = new HashMap<String,String>();


        for (int i = 0; i < Jsonparameters.size(); i++) {
            JsonNode parameter = Jsonparameters.get(i) ;
           
            parameters.put(parameter.get("parameter").asText(), parameter.get("datatype").asText());
		}
		for (int i = 0; i < JsonOperators.size(); i++) {
            JsonNode operator = JsonOperators.get(i) ;
            System.out.println(operator.get("name"));
            System.out.println(operator.get("action"));
			possibleOperators.add(new Operator(operator.get("name").asText(), operator.get("action").asText()));
        }
   
        
        Category category = new Category(node.get("category").get("name").asText());
        String id ="";
        if(node.has("id")){
            id = node.get("id").asText();

        }
        BusinessRuleType arng = new BusinessRuleType(
            id,
            node.get("name").asText(), 
            node.get("nameCode").asText(),
            node.get("explanation").asText(), 
            node.get("example").asText(), 
            node.get("constraintPossible").asBoolean(), 
            possibleOperators, 
            parameters, 
            category);
        System.out.print(arng);
        return arng;
    }
}