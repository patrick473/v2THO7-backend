package App.services;


import java.util.HashMap;
import java.util.Map;

import App.model.businessrulebs.BusinessRule;


import App.persistence.BusinessruleDAO;


/**
 * BusinessRuleTypeService
 */
public class BusinessRuleService {

    public boolean createNewRule(BusinessRule br){
        BusinessruleDAO brdao = new BusinessruleDAO();
        boolean success = brdao.createBusinessrule(br);
        return success;
       
    }
    public BusinessRule getRule(int id){
        
        Map<String, String> bindings = new HashMap<String,String>();
        bindings.put("inRange", "true");
        bindings.put("lowerRange", "1");
        bindings.put("upperRange","10");
        BusinessRule arng = new BusinessRule(1, "br1", true,1, bindings, 22, false,1,true,true,true,"error");
        return arng;
    }
}