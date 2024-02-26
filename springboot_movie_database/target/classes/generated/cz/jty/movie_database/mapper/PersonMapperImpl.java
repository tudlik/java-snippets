package cz.jty.movie_database.mapper;

import cz.jty.movie_database.model.dto.PersonDTO;
import cz.jty.movie_database.model.entity.PersonEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-26T09:59:03+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Amazon.com Inc.)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonDTO toPersonDTO(PersonEntity personEntity) {
        if ( personEntity == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setId( personEntity.getId() );
        personDTO.setName( personEntity.getName() );
        personDTO.setBirthDate( personEntity.getBirthDate() );
        personDTO.setCountry( personEntity.getCountry() );
        personDTO.setBiography( personEntity.getBiography() );
        personDTO.setRole( personEntity.getRole() );

        return personDTO;
    }

    @Override
    public PersonEntity toPerson(PersonDTO personDTO) {
        if ( personDTO == null ) {
            return null;
        }

        PersonEntity personEntity = new PersonEntity();

        personEntity.setId( personDTO.getId() );
        personEntity.setName( personDTO.getName() );
        personEntity.setBirthDate( personDTO.getBirthDate() );
        personEntity.setCountry( personDTO.getCountry() );
        personEntity.setBiography( personDTO.getBiography() );
        personEntity.setRole( personDTO.getRole() );

        return personEntity;
    }
}
