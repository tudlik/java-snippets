package cz.jty.movie_database.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.mapstruct.Mapping;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    @JsonProperty("_id")
    private long id;
    private String name;
    private LocalDate birthDate;
    private String country;
    private String biography;
    private String role;
}
