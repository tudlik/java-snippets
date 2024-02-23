package cz.jty.restApi_advanced.service;

import cz.jty.restApi_advanced.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {


    List<ProductDTO> getAllProducts(String sortBy);

    void createProduct(ProductDTO productDTO);

    ProductDTO getProductById(long id);

    void updateProductById(long id, ProductDTO productDTO);

    void deleteProductById(long id);

}
