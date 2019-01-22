package App.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import App.model.businessrulebs.BusinessRule;
import App.services.BusinessRuleService;



@RestController
public class BusinessRuleController{
    private BusinessRuleService brService = new BusinessRuleService();

    @RequestMapping(value ="/rule", method = RequestMethod.POST, produces = "application/text", consumes = "application/json")
    public ResponseEntity newRule(@RequestBody String jsonString){
        boolean result = false;
        try{
            BusinessRule br = new ObjectMapper().readValue(jsonString, BusinessRule.class);
            result = brService.createNewRule(br);
            if(result == true) {
                return ResponseEntity.status(HttpStatus.OK).body("{\"message\":\"success\",\"object\":"+new ObjectMapper().writeValueAsString(br)+"}");
            }
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Something went wrong handling your request!\",\"object\":"+new ObjectMapper().writeValueAsString(br)+"}");
            }
        }
        catch(Exception e){
            System.out.print(e);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\":\""+e.toString()+"\",\"object\":{}}");
        }
    }
    @RequestMapping(value ="/rule/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getRule(@PathVariable("id") int id) {
        ObjectMapper mapper = new ObjectMapper();
        BusinessRule brType = brService.getRule(id);
        try {
            if(brType != null) {
                return ResponseEntity.status(HttpStatus.OK).body("{\"message\":\"success\",\"object\":"+new ObjectMapper().writeValueAsString(brType)+"}");
            }
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Something went wrong handling your request!\",\"object\":"+new ObjectMapper().writeValueAsString(brType)+"}");
            }
        
        }
        catch(Exception e){
            System.out.print(e);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\":\""+e.toString()+"\",\"object\":{}}");
        }
    }

}