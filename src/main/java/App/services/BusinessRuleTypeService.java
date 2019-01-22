package App.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import App.model.templatebs.BusinessRuleType;
import App.model.templatebs.Category;
import App.model.templatebs.Operator;
import App.persistence.BusinessruleTypeDAO;

/**
 * BusinessRuleTypeService
 */
public class BusinessRuleTypeService {
    private BusinessruleTypeDAO brtypedao = new BusinessruleTypeDAO();

    public BusinessRuleType createNewType(BusinessRuleType brType) {
        if(this.brtypedao.createBusinessruleType(brType)) {
            return brType;
        }
        else {
            return null;
        }
    }

    public BusinessRuleType updateType(BusinessRuleType brType) {

        if (this.brtypedao.updateBusinessRuleType(brType)){
            return brType;
        };
        brType.setID(0);
        return brType;

    }

    public ArrayList<BusinessRuleType> getAllTypes() {
        return this.brtypedao.getAllTypes();
    }

    public BusinessRuleType getRuleType(int id) {
        return this.brtypedao.getSingleType(id);
    }
    public boolean deleteType(int id){
        return this.brtypedao.deleteType(id);
        
    }

    public BusinessRuleType getSingleType(int id) {
        return this.brtypedao.getSingleType(id);
    }
}