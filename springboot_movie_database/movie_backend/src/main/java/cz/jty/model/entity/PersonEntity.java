package cz.jty.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity(name="person") // vytvori tabulku s navem person misto person_entity
@Getter
@Setter
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Date birthDay;
    @Column(nullable = false)
    private String country;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String biography;
    @Column(nullable = false)
    private String role;

}
