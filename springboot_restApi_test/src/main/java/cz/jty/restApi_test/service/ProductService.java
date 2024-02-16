package cz.jty.restApi_test.service;

import cz.jty.restApi_test.model.dto.ProductDTO;
import cz.jty.restApi_test.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();

    void createProduct(ProductDTO productDTO);

    ProductDTO getProductById(long id);

    void updateProductById(long id, ProductDTO productDTO);

    void deleteProductById(long id);

}
