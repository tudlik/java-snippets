package cz.jty.restApiBasics.dao;

import cz.jty.restApiBasics.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
