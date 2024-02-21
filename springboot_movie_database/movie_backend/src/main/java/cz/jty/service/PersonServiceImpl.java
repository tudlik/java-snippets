package cz.jty.service;

import cz.jty.dao.PersonRepository;
import cz.jty.mapper.PersonMapper;
import cz.jty.model.dto.PersonDTO;
import cz.jty.model.entity.PersonEntity;

public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonServiceImpl(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    public PersonDTO addPerson(PersonDTO personDTO) {
        PersonEntity personToSave = personRepository.save(personMapper.toPersonEntity(personDTO));
        return personMapper.toPersonDTO(personToSave);
    }
}
