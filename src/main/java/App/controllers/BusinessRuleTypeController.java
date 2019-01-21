package App.controllers;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import App.model.templatebs.BusinessRuleType;
import App.model.templatebs.Category;
import App.model.templatebs.Operator;
import App.services.BusinessRuleTypeService;

@RestController
public class BusinessRuleTypeController {
    BusinessRuleTypeService brTypeService = new BusinessRuleTypeService();

    @RequestMapping(value = "/type", method = RequestMethod.POST, produces = "application/text", consumes = "application/json")
    public String newType(@RequestBody String jsonString) {
        boolean result = false;
        try {
            BusinessRuleType brtype = new ObjectMapper().readValue(jsonString, BusinessRuleType.class);

            result = brTypeService.createNewType(brtype);
            System.out.print(result + "result");
        } catch (Exception e) {
            System.out.print(e);
        }
        return result + "";
    }

    @RequestMapping(value = "/type", method = RequestMethod.PUT, produces = "application/text", consumes = "application/json")
    public String updateType(@RequestBody String jsonString) {
        boolean result = false;
        try {
            BusinessRuleType brtype = new ObjectMapper().readValue(jsonString, BusinessRuleType.class);

            result = brTypeService.updateType(brtype);
            System.out.print(result + "result");
        } catch (Exception e) {
            System.out.print(e);
        }
        return result + "";
    }

    @RequestMapping(value = "/type/all", method = RequestMethod.GET, produces = "application/json")
    public String getAllTypes() {
        ArrayList<String> result = new ArrayList<String>();
        ObjectMapper mapper = new ObjectMapper();
        try {

            ArrayList<BusinessRuleType> types = brTypeService.getAllTypes();

            for (BusinessRuleType type : types) {
                result.add(mapper.writeValueAsString(type));
            }

        } catch (Exception e) {
            System.out.print(e);
        }
        return result + "";
    }

    @RequestMapping(value = "/type/{id}", method = RequestMethod.GET, produces = "application/json")
    public String getType(@PathVariable("id") int id) {

        String result = "";
        ObjectMapper mapper = new ObjectMapper();
        BusinessRuleType brType = brTypeService.getRuleType(id);
        try {
            result = mapper.writeValueAsString(brType);

        } catch (Exception e) {
            System.out.print(e);
        }

        return result;
    }

}