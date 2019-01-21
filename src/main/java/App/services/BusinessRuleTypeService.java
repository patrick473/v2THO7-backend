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

    public boolean createNewType(BusinessRuleType brType) {

        return this.brtypedao.createBusinessruleType(brType);

    }

    public boolean updateType(BusinessRuleType brType) {

        return this.brtypedao.updateBusinessRuleType(brType);

    }

    public ArrayList<BusinessRuleType> getAllTypes() {
        return this.brtypedao.getAllTypes();
    }

    public BusinessRuleType getRuleType(int id) {
        return this.brtypedao.getType(id);
    }
}