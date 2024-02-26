package cz.jty.movie_database.service;

import cz.jty.movie_database.dao.PersonRepository;
import cz.jty.movie_database.mapper.PersonMapper;
import cz.jty.movie_database.model.dto.PersonDTO;
import cz.jty.movie_database.model.entity.PersonEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class PersonServiceImpl implements PersonService {

    private static Logger longger = LoggerFactory.getLogger(PersonServiceImpl.class);
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    public void addPerson(PersonDTO personDTO) {
        System.out.println("addPerson sout");
        System.out.println(personDTO.getName());
        longger.info("jsem v addPerson service");
        personRepository.save(personMapper.toPerson(personDTO));
    }

    @Override
    public void updatePerson(PersonDTO personDTO, long id) {
        longger.info("jsem v updatePerson service");
        PersonDTO updatePerson = getPersonById(id);
        updatePerson.setName(personDTO.getName());
        updatePerson.setRole(personDTO.getRole());
        updatePerson.setBiography(personDTO.getBiography());
        updatePerson.setCountry(personDTO.getCountry());
        updatePerson.setBirthDate(personDTO.getBirthDate());

    }

    @Override
    public List<PersonDTO> getAllPeople() {
        longger.info("jsem v getAllPeople service");
        List<PersonEntity> personEntities = personRepository.findAll();
        List<PersonDTO> personDTOS =new ArrayList<>();
        for(PersonEntity person : personEntities){
            System.out.println(person.getName()); // smazat
            personDTOS.add(personMapper.toPersonDTO(person));
        }
        return personDTOS;
    }

    @Override
    public PersonDTO getPersonById(long id) {
        return personMapper.toPersonDTO(personRepository.findById(id).orElseThrow(null));
    }
}
