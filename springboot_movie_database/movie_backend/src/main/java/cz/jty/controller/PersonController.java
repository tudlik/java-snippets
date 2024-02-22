package cz.jty.controller;

import cz.jty.model.dto.PersonDTO;
import cz.jty.service.PersonService;
import cz.jty.service.PersonServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="MovieDB restApi")
@RestController
@RequestMapping("/api")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @Operation(summary = "create new person")
    @PostMapping({"/people", "/people/"}) // meotda se bude volat pri POST pozadavku na adresu /api/people i /api/people/
    public ResponseEntity <String> addPerson(@RequestBody PersonDTO personDTO){ // @RequestBody udava, ze soucati pozadavku je i telo s definovanym objektem
        try {
            personService.addPerson(personDTO);
            return ResponseEntity.ok("Person was added");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @Operation(summary = "get all persons")
    @GetMapping({"/people", "/people/"})
    public ResponseEntity<List<PersonDTO>> getAllPersons(){
        try {
            List<PersonDTO> personsDTO = personService.allPersons();
            return ResponseEntity.ok(personsDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
