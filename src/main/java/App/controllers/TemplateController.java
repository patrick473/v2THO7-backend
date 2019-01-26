package App.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity createTemplate(@RequestBody String jsonString){
        boolean result = false;
        try{
        Template template = new ObjectMapper().readValue(jsonString, Template.class);
        result = tService.createNewTemplate(template);
        }
        catch(Exception e){
            System.out.print(e);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\":\""+e.toString()+"\",\"object\":{}}");
        }
    }

    @RequestMapping(value ="/template/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getTemplate(@PathVariable("id") int id) {

        String result = "";
        ObjectMapper mapper = new ObjectMapper();
        Template brType = tService.getTemplate(id);
        try {
        result = mapper.writeValueAsString(brType);
        
        }
        catch(Exception e){
            System.out.print(e);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\":\""+e.toString()+"\",\"object\":{}}");
        }
    }

    @RequestMapping(value ="/template/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteTemplate(@PathVariable("id") int id) {

        try {
            if(tService.deleteTemplate(id)) {
                return ResponseEntity.status(HttpStatus.OK).body("{\"message\":\"success\",\"object\":{}}");
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\":\"Object not found!\",\"object\":{}}");
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