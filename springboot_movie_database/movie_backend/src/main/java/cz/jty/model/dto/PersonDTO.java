package cz.jty.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
    @JsonProperty("_id") //je nastaveno aby se v JSON objevilo id jako _id - pozadavek API na frontendu, ktere muze byt ale nemusi
    private long id;
    private String name;
    private Date birthDay;
    private String country;
    private String biography;
    private String role;

}
