package cz.jty.movie_database.controller;

import cz.jty.movie_database.model.dto.PersonDTO;
import cz.jty.movie_database.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Movie-database RestApi")
@RestController
@RequestMapping("/api")
public class PersonController {

    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @Operation(summary = "Get people", description = "get all people from database")
    @GetMapping({"/people", "/people/"})
    public ResponseEntity<List<PersonDTO>> getPeople(){
        try {
            return ResponseEntity.ok(personService.getAllPeople());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Operation(summary = "Add new person", description = "Add new person to database")
    @PostMapping({"/people", "/people/"})
    public ResponseEntity<String> addPerson(@RequestBody PersonDTO personDTO){
        try {
            personService.addPerson(personDTO);
            return ResponseEntity.ok("Person was added to database");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error, adding to database failed");
        }

    }

    @Operation(summary = "Get person by Id", description = "get specific person by id")
    @GetMapping("/people/{id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable("id") long id){
        try {
            return ResponseEntity.ok(personService.getPersonById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
