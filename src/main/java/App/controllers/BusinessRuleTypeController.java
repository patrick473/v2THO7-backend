package App.controllers;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BusinessRuleTypeController{

    @RequestMapping(value ="/type", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public String index(@RequestBody String jsonString){
        return jsonString;
    }

}