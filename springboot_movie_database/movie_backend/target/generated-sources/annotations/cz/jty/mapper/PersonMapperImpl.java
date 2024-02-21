package cz.jty.mapper;

import cz.jty.model.dto.PersonDTO;
import cz.jty.model.entity.PersonEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-21T13:14:54+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Amazon.com Inc.)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonEntity toPersonEntity(PersonDTO source) {
        if ( source == null ) {
            return null;
        }

        PersonEntity personEntity = new PersonEntity();

        return personEntity;
    }

    @Override
    public PersonDTO toPersonDTO(PersonEntity source) {
        if ( source == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        return personDTO;
    }
}
