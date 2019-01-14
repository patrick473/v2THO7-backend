package App.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import App.model.templatebs.Template;
import App.services.TemplateService;


@RestController
public class TemplateController{
    TemplateService tService = new TemplateService();
    @RequestMapping(value ="/template", method = RequestMethod.POST, produces = "application/text", consumes = "application/json")
    public String createTemplate(@RequestBody String jsonString){
        boolean result = false;
        try{
        Template template = new ObjectMapper().readValue(jsonString, Template.class);
        result = tService.createNewTemplate(template);
        }
        catch(Exception e){
            System.out.print(e);
        }
      return result+"";
    }
    @RequestMapping(value ="/template/{id}", method = RequestMethod.GET, produces = "application/json")
    public String getTemplate(@PathVariable("id") int id) {

        String result = "";
        ObjectMapper mapper = new ObjectMapper();
        Template brType = tService.getTemplate(id);
        try {
        result = mapper.writeValueAsString(brType);
        
        }
        catch(Exception e){
            System.out.print(e);
        }
        
        return result;
    }

}