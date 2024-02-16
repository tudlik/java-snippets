package cz.jty.restApiBasics.mapper;

import cz.jty.restApiBasics.model.entity.User;
import cz.jty.restApiBasics.model.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDTO(User source);

    User toUser (UserDTO source);

}
