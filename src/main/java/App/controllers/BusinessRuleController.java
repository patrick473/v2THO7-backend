package App.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import App.model.AttributeCompareRule;
import App.model.BusinessRule;

@RestController
@RequestMapping("/api/")
public class BusinessRuleController{

    
    @RequestMapping(value = "businessrule",method = RequestMethod.GET)
    public List<BusinessRule> getAllBusinessRules(){
        
        AttributeCompareRule acmp = new AttributeCompareRule()
        .column("column")
        .comparisonType("+")
        .constraintPossible(true)
        .description("description")
        .example("example")
        .otherColumn("otherColumn")
        .table("table")
        .type("type");
        
        List list = new ArrayList<BusinessRule>();
        
        list.add(acmp);
        list.add(acmp);
        list.add(acmp);
        list.add(acmp);
        list.add(acmp);

        return list;
    }

}