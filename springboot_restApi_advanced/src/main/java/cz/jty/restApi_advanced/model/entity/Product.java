package cz.jty.restApi_advanced.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String image;
    @Column
    private String name;
    @Column
    private BigDecimal price;

}
