package cz.jty.restApiBasics.controller;
import cz.jty.restApiBasics.model.dto.UserDTO;
import cz.jty.restApiBasics.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name="RestApi - JDBC", description = "Spring basic app rest Api - operated by JDBC")
public class UserJdbcController {

    private final UserServiceImpl userServiceImp;

    @Autowired
    public UserJdbcController(  UserServiceImpl userServiceImp){
        this.userServiceImp = userServiceImp;
    }



    // JDBC part
    @GetMapping("/jdbc/users")
    @Operation(summary = "Get all user by JDBC")
    public @ResponseBody ResponseEntity<List<UserDTO>> getAllByJdbc(){
        try {
            List<UserDTO> usersDTO = userServiceImp.getAllByJdbc();
            return ResponseEntity.ok(usersDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/jdbc/user")
    @Operation(summary = "Get user by id by JDBC")
    public @ResponseBody ResponseEntity <UserDTO> getUserByIdByJdbc(long id){
        try {
            UserDTO usersDTO = userServiceImp.getByIdByJdbc(id);
            return ResponseEntity.ok(usersDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/jdbc/create")
    @Operation(summary = "Create new user by JDBC")
    public @ResponseBody ResponseEntity<String> createUserByJdbc(UserDTO userDTO){
        try {
            userServiceImp.createByJdbc(userDTO);
            return ResponseEntity.ok("User was created by JDBC");

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error "+ e);
        }
    }

    @PutMapping("/jdbc/update/{id}")
    @Operation(summary = "Update user by id by JDBC")
    public @ResponseBody ResponseEntity<String> updateUserByJdbc(long id, UserDTO userDTO){
        try {
            userServiceImp.update(userDTO,id);
            return ResponseEntity.ok("User with id "+id+ " was updated");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User wasn't updated "+e);
        }


    }

    @DeleteMapping("jdbc/delete")
    @Operation(summary = "Delete user by ID by JDBC")
    public @ResponseBody ResponseEntity<String> deleteUserById(long id){
        try {
            userServiceImp.deleteByJdbc(id);
            return ResponseEntity.ok("User with id "+id+" was deleted");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User wasn't deleted");
        }
    }

}


