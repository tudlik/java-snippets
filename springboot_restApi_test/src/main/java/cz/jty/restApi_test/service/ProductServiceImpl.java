package cz.jty.restApi_test.service;

import cz.jty.restApi_test.dao.ProductRepository;
import cz.jty.restApi_test.mapper.ProductMapper;
import cz.jty.restApi_test.model.dto.ProductDTO;
import cz.jty.restApi_test.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(@Autowired ProductRepository productRepository, @Autowired ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productsDTO = new ArrayList<>();
        for(Product product: products){
            productsDTO.add(productMapper.toProductDTO(product));
        }
        return productsDTO;
    }

    @Override
    public void createProduct(ProductDTO productDTO) {
        productRepository.save(productMapper.toProduct(productDTO));
    }


    @Override
    public ProductDTO getProductById(long id) {
        return productMapper.toProductDTO(productRepository.findById(id).orElseThrow());
    }

    @Override
    public void updateProductById(long id, ProductDTO productDTO) {
        ProductDTO updateProductDTO =  getProductById(id);
        updateProductDTO.setName(productDTO.getName());
        updateProductDTO.setImage(productDTO.getImage());
        updateProductDTO.setPrice(productDTO.getPrice());
        productRepository.save(productMapper.toProduct(updateProductDTO));
    }

    @Override
    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }
}
