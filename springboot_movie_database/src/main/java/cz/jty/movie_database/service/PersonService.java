package cz.jty.movie_database.service;

import cz.jty.movie_database.model.dto.PersonDTO;

import java.util.List;

public interface PersonService {
    void addPerson(PersonDTO personDTO);

    void updatePerson(PersonDTO personDTO, long id);
    List<PersonDTO> getAllPeople();

    PersonDTO getPersonById(long id);

}
