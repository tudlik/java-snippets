package cz.jty.restApi_advanced.mapper;

import cz.jty.restApi_advanced.model.dto.ProductDTO;
import cz.jty.restApi_advanced.model.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toProductDTO(Product source);

    Product toProduct(ProductDTO source);


}
