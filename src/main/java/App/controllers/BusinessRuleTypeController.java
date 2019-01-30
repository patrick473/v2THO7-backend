package App.controllers;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import App.businessrulebs.model.BusinessRule;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import App.templatebs.model.BusinessRuleType;
import App.templatebs.model.Category;
import App.templatebs.model.Operator;
import App.templatebs.services.BusinessRuleTypeService;

@RestController
public class BusinessRuleTypeController {
    private BusinessRuleTypeService brTypeService = new BusinessRuleTypeService();

    @RequestMapping(value = "/type", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity newType(@RequestBody String jsonString) {
        try {
            BusinessRuleType brtype = new ObjectMapper().readValue(jsonString, BusinessRuleType.class);
            BusinessRuleType result = brTypeService.createNewType(brtype);
            if(result != null) {
                return ResponseEntity.status(HttpStatus.OK).body("{\"message\":\"success\",\"object\":"+new ObjectMapper().writeValueAsString(brtype)+"}");
            }
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Something went wrong handling your request!\",\"object\":{}}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Something went wrong handling your request!\",\"object\":{}}");
        }
      
    }

    @RequestMapping(value = "/type", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public ResponseEntity updateType(@RequestBody String jsonString) {
        
        try {
            BusinessRuleType brtype = new ObjectMapper().readValue(jsonString, BusinessRuleType.class);

            brtype = brTypeService.updateType(brtype);
            
            if (brtype.id() == 0){
                return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("{\"message\":\"Object not found\",\"object\":{}}");
            }
            else {
                return ResponseEntity.status(HttpStatus.OK).body("{\"message\":\"success\",\"object\":"+new ObjectMapper().writeValueAsString(brtype)+"}");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Something went wrong handling your request!\",\"object\":{}}");
        }
        
    }

   

    @RequestMapping(value = "/type/all", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getAllTypes() {
        ArrayList<String> result = new ArrayList<String>();
        ObjectMapper mapper = new ObjectMapper();
        try {

            ArrayList<BusinessRuleType> types = brTypeService.getAllTypes();

            for (BusinessRuleType type : types) {
                result.add(mapper.writeValueAsString(type));
            }
            if(result.isEmpty()){
                return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body("{\"message\":\"No objects found\",\"object\":[]}");
            }
            return ResponseEntity
                .status(HttpStatus.OK)
                .body("{\"message\":\"success\",\"object\":"+result+"}");
              
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Something went wrong handling your request!\",\"object\":[]}");
        }
        
    }

    @RequestMapping(value = "/type/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getType(@PathVariable("id") int id) {

        String result = "";
        ObjectMapper mapper = new ObjectMapper();
        BusinessRuleType brtype = brTypeService.getRuleType(id);
        try {
            if(brtype.id() != 0){
                return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("{\"message\":\"success\",\"object\":"+new ObjectMapper().writeValueAsString(brtype)+"}");
            }
            else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("{\"message\":\"Object not found\",\"object\":{}}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Something went wrong handling your request!\",\"object\":{}}");
        }

        
    }
    @RequestMapping(value = "/type/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteType(@PathVariable("id") int id) {
        try {
            if(brTypeService.deleteType(id)){
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("{\"message\":\"Succes\",\"object\":{}}");
            }
            else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("{\"message\":\"Object not found\",\"object\":{}}");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Something went wrong handling your request!\",\"object\":{}}");
        }
    }
}