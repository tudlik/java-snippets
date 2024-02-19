package cz.jty.restApi_advanced.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    long id;

    String image;
    String name;
    BigDecimal price;


}
