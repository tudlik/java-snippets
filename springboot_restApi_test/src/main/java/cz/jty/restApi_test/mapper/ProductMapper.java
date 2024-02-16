package cz.jty.restApi_test.mapper;

import cz.jty.restApi_test.model.dto.ProductDTO;
import cz.jty.restApi_test.model.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toProductDTO(Product source);

    Product toProduct(ProductDTO source);


}
