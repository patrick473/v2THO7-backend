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
    public ResponseEntity newRule(@RequestBody String jsonString){
        boolean result = false;
        try{
        BusinessRule br = new ObjectMapper().readValue(jsonString, BusinessRule.class);
        result = brService.createNewRule(br);

        return ResponseEntity
            .status(HttpStatus.OK)
                .body("{\"message\":\"success\",\"object\":"+new ObjectMapper().writeValueAsString(br)+"}")
        }
        catch(Exception e){
            System.out.print(e);
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\":\""+e.toString()+"\",\"object\":{}}");
        }
    }
    @RequestMapping(value ="/rule/{id}", method = RequestMethod.GET, produces = "application/json")
    public String getRule(@PathVariable("id") int id) {

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