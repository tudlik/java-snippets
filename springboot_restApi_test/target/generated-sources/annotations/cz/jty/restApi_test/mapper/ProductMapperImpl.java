package cz.jty.restApi_test.mapper;

import cz.jty.restApi_test.model.dto.ProductDTO;
import cz.jty.restApi_test.model.entity.Product;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-16T14:48:16+0100",
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
        if ( source.getPrice() != null ) {
            productDTO.setPrice( source.getPrice().toString() );
        }

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
        if ( source.getPrice() != null ) {
            product.setPrice( new BigDecimal( source.getPrice() ) );
        }

        return product;
    }
}
