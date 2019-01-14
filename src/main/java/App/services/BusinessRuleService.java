package App.services;


import java.util.HashMap;
import java.util.Map;

import App.model.businessrulebs.BusinessRule;

import App.model.businessrulebs.Operator;
import App.persistence.BusinessruleTypeDAO;

/**
 * BusinessRuleTypeService
 */
public class BusinessRuleService {

    public boolean createNewRule(BusinessRule br){
    
        return true;
       
    }
    public BusinessRule getRule(int id){
        
        Map<String, String> bindings = new HashMap<String,String>();
        bindings.put("inRange", "true");
        bindings.put("lowerRange", "1");
        bindings.put("upperRange","10");
        BusinessRule arng = new BusinessRule(1, "br1", true,new Operator(1, "name", "beep boop kill me"), bindings, 22, false,1);
        return arng;
    }
}