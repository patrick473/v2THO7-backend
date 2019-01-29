package App.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import App.model.databasebs.Database;
import App.model.databasebs.DatabaseType;
import App.services.DatabaseService;

@RestController
public class DatabaseController {

    DatabaseService dbservice = new DatabaseService();

    @RequestMapping(value ="/database/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getDatabase(@PathVariable("id") int id) {
        try{
            Database database = dbservice.getDatabase(id);
            if(database != null) {
                return ResponseEntity.status(HttpStatus.OK).body("{\"message\":\"success\",\"object\":"+new ObjectMapper().writeValueAsString(database)+"}");
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\":\"Object not found!\",\"object\":{}}");
            }
        }
        catch(Exception e){
            System.out.print(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Something went wrong handling your request!\",\"object\":{}}");
        }
    }

    @RequestMapping(value ="/databasetype/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getDatabaseType(@PathVariable("id") int id) {
        try{
            DatabaseType databasetype = dbservice.getDatabaseType(id);
            if(databasetype != null) {
                return ResponseEntity.status(HttpStatus.OK).body("{\"message\":\"success\",\"object\":"+new ObjectMapper().writeValueAsString(databasetype)+"}");
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\":\"Object not found!\",\"object\":{}}");
            }
        }
        catch(Exception e){
            System.out.print(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Something went wrong handling your request!\",\"object\":{}}");
        }
    }

}
