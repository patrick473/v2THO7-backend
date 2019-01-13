package App.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import App.model.businessrulebs.BusinessRuleType;
import App.model.businessrulebs.Category;
import App.model.businessrulebs.Operator;

/**
 * BusinessRuleTypeService
 */
public class BusinessRuleTypeService {

    public String createNewType(BusinessRuleType brType){
        System.out.println(brType.toString());
        return "succes";
    }
    public BusinessRuleType getRule(int id){
          
        ArrayList<Operator> possibleOperators = new ArrayList<Operator>();
        possibleOperators.add(new Operator("inRange", "x in (y,z)"));
        possibleOperators.add(new Operator("outRange", "x outside of (y,z)"));
        Map<String, String> parameters = new HashMap<String,String>();
        parameters.put("lowerRange", "any");
        parameters.put("upperRange", "any");
        parameters.put("inRange", "boolean");
        Category category = new Category("strict data constraint rule");
        BusinessRuleType arng = new BusinessRuleType(id, "Attribute range rule", "ARNG", "Value must be in or out range", "1 in 1,100", true, possibleOperators, parameters, category);
        return arng;
    }
}