package App.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import App.templatebs.model.Template;
import App.templatebs.services.TemplateService;

import java.util.ArrayList;


@RestController
public class TemplateController{

    TemplateService tService = new TemplateService();

    @RequestMapping(value ="/template", method = RequestMethod.POST, produces = "application/text", consumes = "application/json")
    public ResponseEntity createTemplate(@RequestBody String jsonString){
        try{
            Template template = new ObjectMapper().readValue(jsonString, Template.class);
            if(tService.createNewTemplate(template) != null) {
                return ResponseEntity.status(HttpStatus.OK).body("{\"message\":\"success\",\"object\":"+new ObjectMapper().writeValueAsString(template)+"}");
            }
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Something went wrong handling your request!\",\"object\":{}}");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Something went wrong handling your request!\",\"object\":{}}");
        }
    }

    @RequestMapping(value ="/template", method = RequestMethod.PUT, produces = "application/text", consumes = "application/json")
    public ResponseEntity updateTemplate(@RequestBody String jsonString){
        try{
            Template template = new ObjectMapper().readValue(jsonString, Template.class);
            if(tService.updateTemplate(template) != null) {
                return ResponseEntity.status(HttpStatus.OK).body("{\"message\":\"success\",\"object\":"+new ObjectMapper().writeValueAsString(template)+"}");
            }
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Something went wrong handling your request!\",\"object\":{}}");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\":\""+e.toString()+"\",\"object\":{}}");
        }
    }

    @RequestMapping(value ="/template/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getTemplate(@PathVariable("id") int id) {
        try{
            Template template = tService.getTemplate(id);
            if(template != null) {
                return ResponseEntity.status(HttpStatus.OK).body("{\"message\":\"success\",\"object\":"+new ObjectMapper().writeValueAsString(template)+"}");
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\":\"Object not found!\",\"object\":{}}");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Something went wrong handling your request!\",\"object\":{}}");
        }
    }

    @RequestMapping(value ="/template/{ruletypeid}/{databasetypeid}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getTemplateByRuleTypeAndDatabaseType(@PathVariable("ruletypeid") int ruletypeid, @PathVariable("databasetypeid") int databasetypeid) {
        ArrayList<String> result = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        try{
            ArrayList<Template> templates = tService.getTemplateByRuleTypeAndDatabaseType(ruletypeid, databasetypeid);
            if(templates.size() > 0) {
                for (Template template : templates) {
                    result.add(mapper.writeValueAsString(template));
                }
                return ResponseEntity.status(HttpStatus.OK).body("{\"message\":\"success\",\"object\":"+result+"}");
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\":\"Object not found!\",\"object\":{}}");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Something went wrong handling your request!\",\"object\":{}}");
        }
    }

    @RequestMapping(value ="/template/all", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getAllTemplates() {
        ArrayList<String> result = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        try{
            ArrayList<Template> templates = tService.getAllTemplates();
            if(templates.size() > 0) {
                for (Template template : templates) {
                    result.add(mapper.writeValueAsString(template));
                }
                return ResponseEntity.status(HttpStatus.OK).body("{\"message\":\"success\",\"object\":"+result+"}");
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\":\"Object not found!\",\"object\":[]}");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Something went wrong handling your request!\",\"object\":[]}");
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
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Something went wrong handling your request!\",\"object\":{}}");
        }
    }

}