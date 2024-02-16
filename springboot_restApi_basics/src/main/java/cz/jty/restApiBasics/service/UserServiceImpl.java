package cz.jty.restApiBasics.service;

import cz.jty.restApiBasics.dao.UserJdbcRepository;
import cz.jty.restApiBasics.model.entity.User;
import cz.jty.restApiBasics.dao.UserRepository;
import cz.jty.restApiBasics.model.dto.UserDTO;
import cz.jty.restApiBasics.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    private final UserJdbcRepository userJdbcRepository;



    @Autowired
    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository, UserJdbcRepository userJdbcRepository){
        this.userMapper=userMapper;
        this.userRepository=userRepository;
        this.userJdbcRepository=userJdbcRepository;
    }

    public void create(UserDTO userDTO) {
        User newUser = userMapper.toUser(userDTO);
        userRepository.save(newUser);
    }

    @Override
    public UserDTO getById(long id) {
        return userMapper.toUserDTO(userRepository.findById(id).orElseThrow());
    }

    @Override
    public List<UserDTO> getAll() {
        List<UserDTO> usersDTO = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for(User user : users){
            usersDTO.add(userMapper.toUserDTO(user));
        }
        return usersDTO;
    }

    @Override
    public void update(UserDTO userDTO, long id) {
        UserDTO updateUserDTO = userMapper.toUserDTO(userRepository.findById(id).orElseThrow());
        updateUserDTO.setFirstName(userDTO.getFirstName());
        updateUserDTO.setLastName(userDTO.getLastName());
        updateUserDTO.setAge(userDTO.getAge());
        updateUserDTO.setOccupation(userDTO.getOccupation());
        userRepository.save(userMapper.toUser(updateUserDTO));
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }


    // part with JDBC
    @Override
    public void createByJdbc(UserDTO userDTO) {
        userJdbcRepository.insertUserByJdbc(userDTO);
    }

    @Override
    public UserDTO getByIdByJdbc(long id) {
        return userJdbcRepository.getUserByJdbc(id);
    }

    @Override
    public List<UserDTO> getAllByJdbc() {
        return userJdbcRepository.getUsersByJdbc();
    }

    @Override
    public void updateByJdbc(UserDTO userDTO, long id) {
        userJdbcRepository.updateUserByJdbc(userDTO,id);
    }

    @Override
    public void deleteByJdbc(long id) {
        userJdbcRepository.deleteUserByJdbc(id);
    }
}
