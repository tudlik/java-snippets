package cz.jty.restApi_advanced.service;

import cz.jty.restApi_advanced.dao.ProductRepository;
import cz.jty.restApi_advanced.mapper.ProductMapper;
import cz.jty.restApi_advanced.model.dto.ProductDTO;
import cz.jty.restApi_advanced.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public List<ProductDTO> getAllProducts(String sortBy) {
        Page<Product> products = productRepository.findAll(PageRequest.of(0, Integer.MAX_VALUE, Sort.by(Sort.Direction.ASC, sortBy))); // pageNumber - cislo stranky - pokud je 0 tak zobrazi pouze jednu stranku ,druha hodnota udava pocet prvku na strnku, pokud je integer max tak vypise vse, Sort.by -udava razeni, je vzdy rostouci, a bude se radit podle id, ktere ziska v metode
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
        ProductDTO updateProductDTO = productMapper.toProductDTO(productRepository.findById(id).orElseThrow());
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
