package App.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import App.model.businessrulebs.BusinessRule;
import App.services.BusinessRuleService;



@RestController
public class BusinessRuleController{
    BusinessRuleService brService = new BusinessRuleService();

    @RequestMapping(value ="/rule", method = RequestMethod.POST, produces = "application/text", consumes = "application/json")
    public String newType(@RequestBody String jsonString){
        boolean result = false;
        try{
        BusinessRule brtype = new ObjectMapper().readValue(jsonString, BusinessRule.class);
        result = brService.createNewRule(brtype);
        }
        catch(Exception e){
            System.out.print(e);
        }
      return result+"";
    }
    @RequestMapping(value ="/rule/{id}", method = RequestMethod.GET, produces = "application/json")
    public String getType(@PathVariable("id") int id) {

        String result = "";
        ObjectMapper mapper = new ObjectMapper();
        BusinessRule brType = brService.getRule(id);
        try {
        result = mapper.writeValueAsString(brType);
        
        }
        catch(Exception e){
            System.out.print(e);
        }
        
        return result;
    }

}