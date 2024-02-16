package cz.jty.restApiBasics.service;

import cz.jty.restApiBasics.model.dto.UserDTO;

import java.util.List;

public interface UserService {
    void create (UserDTO userDTO);

    UserDTO getById(long userId);
    List<UserDTO> getAll();

    void update (UserDTO userDTO, long id);

    void delete (long id);

    void createByJdbc (UserDTO userDTO);

    UserDTO getByIdByJdbc(long userId);
    List<UserDTO> getAllByJdbc();

    void updateByJdbc (UserDTO userDTO, long id);

    void deleteByJdbc (long id);

}
