package cz.jty.restApi_advanced.dao;

import cz.jty.restApi_advanced.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
