package cz.jty.mapper;

import cz.jty.model.dto.PersonDTO;
import cz.jty.model.entity.PersonEntity;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonEntity toPersonEntity(PersonDTO source);
    PersonDTO toPersonDTO(PersonEntity source);
}
