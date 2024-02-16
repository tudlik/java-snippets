package cz.jty.restApiBasics.dao;

import cz.jty.restApiBasics.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserJdbcRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }


    public List<UserDTO> getUsersByJdbc (){
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, userRowmapper);
    }

    private final RowMapper<UserDTO> userRowmapper = (rs, rowNum)->{
        UserDTO userDTO = new UserDTO();
        userDTO.setId(rs.getLong("id"));
        userDTO.setFirstName(rs.getString("firstName"));
        userDTO.setLastName(rs.getString("lastName"));
        userDTO.setAge(rs.getInt("age"));
        userDTO.setOccupation(rs.getString("occupation"));
        return userDTO;
    };

    public UserDTO getUserByJdbc (long id){
        String sql = "SELECT * FROM user WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, userRowmapper);
    }

    public void insertUserByJdbc(UserDTO userDTO){
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("user").usingGeneratedKeyColumns("id");

        Map<String , Object> parameters = new HashMap<>();
        parameters.put("firstName", userDTO.getFirstName());
        parameters.put("lastName", userDTO.getLastName());
        parameters.put("age", userDTO.getAge());
        parameters.put("occupation", userDTO.getOccupation());
        jdbcInsert.executeAndReturnKey(parameters);
    }

    public void updateUserByJdbc(UserDTO userDTO, long id){
        String sql = "UPDATE user SET firstName=?, lastName=?, age=?, occupation=? WHERE id=?";
        jdbcTemplate.update(sql, userDTO.getFirstName(),userDTO.getLastName(),userDTO.getAge(),userDTO.getOccupation(),id);
    }

    public void deleteUserByJdbc(long id){
        String sql = "DELETE FROM user WHERE id=?";
        jdbcTemplate.update(sql,id);
    }
}
