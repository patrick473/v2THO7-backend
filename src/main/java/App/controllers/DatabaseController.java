package App.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import App.databasebs.model.Database;
import App.databasebs.model.DatabaseType;
import App.databasebs.services.DatabaseService;

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
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"Something went wrong handling your request!\",\"object\":{}}");
        }
    }
}
