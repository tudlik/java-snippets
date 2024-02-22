package cz.jty.service;

import cz.jty.dao.PersonRepository;
import cz.jty.mapper.PersonMapper;
import cz.jty.model.dto.PersonDTO;
import cz.jty.model.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    public void addPerson(PersonDTO personDTO) {
         personRepository.save(personMapper.toPersonEntity(personDTO));
    }

    @Override
    public List<PersonDTO> allPersons() {
        List <PersonDTO> personsDTO = new ArrayList<>();
        List<PersonEntity> persons= personRepository.findAll();
        for(PersonEntity person : persons){
            personsDTO.add(personMapper.toPersonDTO(person));
        }
        return personsDTO;
    }
}
