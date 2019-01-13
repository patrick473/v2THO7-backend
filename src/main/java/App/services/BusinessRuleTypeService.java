package App.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import App.model.businessrulebs.BusinessRuleType;
import App.model.businessrulebs.Category;
import App.model.businessrulebs.Operator;
import App.persistence.BusinessruleTypeDAO;

/**
 * BusinessRuleTypeService
 */
public class BusinessRuleTypeService {

    public boolean createNewType(BusinessRuleType brType){
        BusinessruleTypeDAO brtypedao = new BusinessruleTypeDAO();
        return brtypedao.createBusinessruleType(brType);
       
    }
    public BusinessRuleType getRule(int id){
        BusinessruleTypeDAO brdao =  new BusinessruleTypeDAO();
        brdao.getSomething();
        ArrayList<Operator> possibleOperators = new ArrayList<Operator>();
        possibleOperators.add(new Operator(1,"inRange", "x in (y,z)"));
        possibleOperators.add(new Operator(2,"outRange", "x outside of (y,z)"));
        Map<String, String> parameters = new HashMap<String,String>();
        parameters.put("lowerRange", "any");
        parameters.put("upperRange", "any");
        parameters.put("inRange", "boolean");
        Category category = new Category(1,"strict data constraint rule");
        BusinessRuleType arng = new BusinessRuleType(id, "Attribute range rule", "ARNG", "Value must be in or out range", "1 in 1,100", true, possibleOperators, parameters, category);
        return arng;
    }
}