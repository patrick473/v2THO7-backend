package App.services;


import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import App.model.businessrulebs.BusinessRule;
import App.model.templatebs.BusinessRuleType;
import App.model.templatebs.Operator;


import App.persistence.BusinessruleDAO;


/**
 * BusinessRuleTypeService
 */
public class BusinessRuleService {

    public BusinessRule createNewRule(BusinessRule br){
        BusinessruleDAO brdao = new BusinessruleDAO();
        if(validateBusinessRuleInput(br)) {
            if(brdao.createBusinessrule(br)) {
                return br;
            }
        }

        return null;

    }
    public BusinessRule getRule(int id){
        
        Map<String, String> bindings = new HashMap<String,String>();
        bindings.put("inRange", "true");
        bindings.put("lowerRange", "1");
        bindings.put("upperRange","10");
        BusinessRule arng = new BusinessRule(1, "br1", true,1, bindings, 22, false,1,true,true,true,"error");
        return arng;
    }

    public boolean validateBusinessRuleInput(BusinessRule br) {

        BusinessRuleTypeService typeservice = new BusinessRuleTypeService();
        BusinessRuleType type  = typeservice.getSingleType(br.type());

        if(validateConstraintInput(type.constraintpossible(), br.constraint()) && validateOperatorInput(type.possibleoperators(), br.operator())) {
            return true;
        }
        else {
            return false;
        }
    }
    //Check if provided operator is allowed for the businessrule type
    public boolean validateOperatorInput(ArrayList<Operator> allowedOperators, int operatorid) {
        for(Operator allowedOperator : allowedOperators) {
            if(allowedOperator.id() == operatorid) {
                return true;
            }
        }
        return false;
    }

    //Check if provided binding match the required parameters for the businessrule type & and match the required type
    public boolean validateBindingInput(Map<String, String> allowedParameters, Map<String, String> bindingsInput) {
        if(allowedParameters.size() == bindingsInput.size()) {
            for(Map.Entry<String, String> allowedParameter : allowedParameters.entrySet()) {
                if(!bindingsInput.containsKey(allowedParameter.getKey())) {
                    return false;
                }
            }

            return true;
        }
        else {
            return false;
        }
    }

    //Check if Rule is allowed to be a constraint
    public boolean validateConstraintInput(boolean isContraintAllowed, boolean isConstraintInput) {
        if(isContraintAllowed == isConstraintInput) {
            return true;
        }
        else {
            return false;
        }
    }
}