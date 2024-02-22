package cz.jty.service;

import cz.jty.model.dto.PersonDTO;

import java.util.List;

public interface PersonService {
    void addPerson(PersonDTO personDTO);

    List<PersonDTO> allPersons();
}
