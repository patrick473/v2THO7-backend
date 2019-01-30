package App.businessrulebs.services;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import App.businessrulebs.model.BusinessRule;
import App.templatebs.model.BusinessRuleType;
import App.templatebs.model.Operator;

import App.templatebs.services.BusinessRuleTypeService;

import App.businessrulebs.persistence.BusinessruleDAO;


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
    public BusinessRule getSingleRule(int id){

        BusinessruleDAO brdao = new BusinessruleDAO();
        BusinessRule br = brdao.getSingleRule(id);

        return br;
    }

    public ArrayList<BusinessRule> getAllRules() {
        BusinessruleDAO brdao = new BusinessruleDAO();
        ArrayList<BusinessRule> rules = brdao.getAllRules();

        return rules;
    }

    public BusinessRule updateRule(BusinessRule br) {
        BusinessruleDAO brdao = new BusinessruleDAO();
        if(validateBusinessRuleInput(br)) {
            return brdao.updateBusinessRule(br);
        }
        else {
            return null;
        }
    }

    public Boolean deleteRule(int id) {

        BusinessruleDAO brdao = new BusinessruleDAO();
        return brdao.deleteBusinessRule(id);

    }

    public boolean applyRule(int id, int applied) {
        BusinessruleDAO brdao = new BusinessruleDAO();
        return brdao.applyRule(id, applied);
    }

    public boolean validateBusinessRuleInput(BusinessRule br) {

        BusinessRuleTypeService typeservice = new BusinessRuleTypeService();
        BusinessRuleType type  = typeservice.getSingleType(br.type());
        if(type != null && validateConstraintInput(type.constraintpossible(), br.constraint()) && validateOperatorInput(type.possibleoperators(), br.operator()) && validateBindingInput(type.parameters(), br.bindings())) {
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
        if(isContraintAllowed) {
            return true;
        }
        else if(!isContraintAllowed && isContraintAllowed == isConstraintInput) {
            return true;
        }
        else {
            return false;
        }
    }
}