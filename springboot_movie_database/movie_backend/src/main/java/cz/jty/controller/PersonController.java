package cz.jty.controller;

import cz.jty.model.dto.PersonDTO;
import cz.jty.service.PersonService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonController {

    private final PersonService personService;

    public PersonController(@Autowired PersonService personService) {
        this.personService = personService;
    }

    @PostMapping({"/people", "/people/"}) // meotda se bude volat pri POST pozadavku na adresu /api/people i /api/people/
    public ResponseEntity <PersonDTO> addPerson(@RequestBody PersonDTO personDTO){ // @RequestBody udava, ze soucati pozadavku je i telo s definovanym objektem
        try {
            return ResponseEntity.ok(personService.addPerson(personDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
