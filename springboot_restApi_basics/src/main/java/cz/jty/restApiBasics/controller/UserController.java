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
@Tag(name="RestApi - JPA", description = "Spring basic app rest Api - operated by JPA")
public class UserController {

    private final UserServiceImpl userServiceImp;

    @Autowired
    public UserController(  UserServiceImpl userServiceImp){
        this.userServiceImp = userServiceImp;
    }

    @GetMapping("/")
    @Operation(summary = "Rendering site with greeting")
    public @ResponseBody String welcomePage(){
        return "welcome  gsfghgdfjsdg :-)";
    }

    @GetMapping("/user/{id}")
    public @ResponseBody ResponseEntity<UserDTO> getUser(@PathVariable("id") long id) {
        try {
            UserDTO newUserDTO = userServiceImp.getById(id);
            return ResponseEntity.ok(newUserDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/users")
    @Operation(summary = "Returning list of users")
    public @ResponseBody ResponseEntity <List<UserDTO>> getAll() {
        try {
            List<UserDTO> usersDTO= userServiceImp.getAll();
            return ResponseEntity.ok(usersDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @PostMapping("/create")
    @Operation(summary = "Creating new user")
    public @ResponseBody ResponseEntity<String> createUser(@RequestBody UserDTO userDTO){
        try {
            userServiceImp.create(userDTO);
            return ResponseEntity.ok("User was created");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating user");
        }
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Updating user by specific id")
    public @ResponseBody ResponseEntity<String> updateUser(@PathVariable ("id") long id, @RequestBody UserDTO userDTO){
        try {
            userServiceImp.update(userDTO, id);
            return ResponseEntity.ok("User was updated..");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating user");
        }
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Deleting user")
        public @ResponseBody ResponseEntity<String> deleteUser(@PathVariable ("id") long id) {
        try {
            userServiceImp.delete(id);
            return ResponseEntity.ok("User was deleted");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Deleting user error");
        }
    }
}


