package App.templatebs.services;

import java.util.ArrayList;


import App.templatebs.model.BusinessRuleType;

import App.templatebs.persistence.BusinessruleTypeDAO;

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