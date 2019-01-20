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

import App.model.businessrulebs.BusinessRule;


public class BusinessRuleDeserializer extends StdDeserializer<BusinessRule> {

    public BusinessRuleDeserializer() {
        this(null);
    }

    public BusinessRuleDeserializer(Class<BusinessRule> t) {
        super(t);
    }

    @Override
    public BusinessRule deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        JsonNode JsonBindings = node.get("bindings");

        Map<String, String> bindings = new HashMap<String, String>();

        for (int i = 0; i < JsonBindings.size(); i++) {
            JsonNode binding = JsonBindings.get(i);

            bindings.put(binding.get("key").asText(), binding.get("value").asText());
        }

        int id = 0;
        if (node.has("id")) {
            id = node.get("id").asInt();

        }
        BusinessRule arng = new BusinessRule(id, node.get("name").asText(), node.get("applied").asBoolean(),
                node.get("operator").asInt(), bindings, node.get("type").asInt(), node.get("constraint").asBoolean(),
                node.get("table").asInt(), node.get("insert").asBoolean(),node.get("update").asBoolean(),node.get("delete").asBoolean(),node.get("error").asText());
        return arng;
    }
}