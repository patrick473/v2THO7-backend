package App.controllers;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.json.JsonObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import App.model.businessrulebs.BusinessRuleType;
import App.model.businessrulebs.Category;
import App.model.businessrulebs.Operator;
import App.model.businessrulebs.Serializers.BusinessRuleTypeSerializer;


@RestController
public class BusinessRuleTypeController{

    @RequestMapping(value ="/type", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public String index(@RequestBody String jsonString){
        ArrayList<Operator> possibleOperators = new ArrayList<Operator>();
        possibleOperators.add(new Operator("inRange", "x in (y,z)"));
        possibleOperators.add(new Operator("outRange", "x outside of (y,z)"));
        Map<String, String> parameters = new HashMap<String,String>();
        parameters.put("lowerRange", "any");
        parameters.put("upperRange", "any");
        parameters.put("inRange", "boolean");
        Category category = new Category("strict data constraint rule");
        BusinessRuleType arng = new BusinessRuleType("id", "Attribute range rule", "ARNG", "Value must be in or out range", "1 in 1,100", true, possibleOperators, parameters, category);
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(BusinessRuleType.class, new BusinessRuleTypeSerializer());
        mapper.registerModule(module);
        String result = "";
        try {
        result = mapper.writeValueAsString(arng);
        
        }
        catch(Exception e){
            System.out.print(e);
        }
        
        return result;
    }

}