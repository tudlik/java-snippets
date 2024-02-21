package cz.jty.restApi_advanced.model.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    long id;

    @NotNull
    String image;
    @Size(min = 3)
    String name;
    @Min(1)
    BigDecimal price;


}
