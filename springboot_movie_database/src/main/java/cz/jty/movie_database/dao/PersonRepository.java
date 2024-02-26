package cz.jty.movie_database.dao;

import cz.jty.movie_database.model.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
