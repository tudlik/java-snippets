package cz.jty.movie_database;

import cz.jty.movie_database.dao.PersonRepository;
import cz.jty.movie_database.mapper.PersonMapper;
import cz.jty.movie_database.service.PersonService;
import cz.jty.movie_database.service.PersonServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class MovieDatabaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieDatabaseApplication.class, args);
    }



}
