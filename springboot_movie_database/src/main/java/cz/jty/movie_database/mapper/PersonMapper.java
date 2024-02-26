package cz.jty.movie_database.mapper;

import cz.jty.movie_database.model.dto.PersonDTO;
import cz.jty.movie_database.model.entity.PersonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDTO toPersonDTO(PersonEntity personEntity);
    PersonEntity toPerson(PersonDTO personDTO);
}
