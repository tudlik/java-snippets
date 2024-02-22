package cz.jty.restApiBasics.mapper;

import cz.jty.restApiBasics.model.dto.UserDTO;
import cz.jty.restApiBasics.model.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-22T09:00:15+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toUserDTO(User source) {
        if ( source == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( source.getId() );
        userDTO.setFirstName( source.getFirstName() );
        userDTO.setLastName( source.getLastName() );
        userDTO.setAge( source.getAge() );
        userDTO.setOccupation( source.getOccupation() );

        return userDTO;
    }

    @Override
    public User toUser(UserDTO source) {
        if ( source == null ) {
            return null;
        }

        User user = new User();

        user.setId( source.getId() );
        user.setFirstName( source.getFirstName() );
        user.setLastName( source.getLastName() );
        user.setAge( source.getAge() );
        user.setOccupation( source.getOccupation() );

        return user;
    }
}
