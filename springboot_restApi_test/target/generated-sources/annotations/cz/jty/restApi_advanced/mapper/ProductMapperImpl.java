package cz.jty.restApi_advanced.mapper;

import cz.jty.restApi_advanced.model.dto.ProductDTO;
import cz.jty.restApi_advanced.model.entity.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-22T08:49:49+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Amazon.com Inc.)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO toProductDTO(Product source) {
        if ( source == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId( source.getId() );
        productDTO.setImage( source.getImage() );
        productDTO.setName( source.getName() );
        productDTO.setPrice( source.getPrice() );

        return productDTO;
    }

    @Override
    public Product toProduct(ProductDTO source) {
        if ( source == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( source.getId() );
        product.setImage( source.getImage() );
        product.setName( source.getName() );
        product.setPrice( source.getPrice() );

        return product;
    }
}
