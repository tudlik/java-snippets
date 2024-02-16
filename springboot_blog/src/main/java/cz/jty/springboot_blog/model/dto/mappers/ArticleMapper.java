package cz.jty.springboot_blog.model.dto.mappers;

import cz.jty.springboot_blog.data.entities.ArticleEntity;
import cz.jty.springboot_blog.model.dto.ArticleDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    ArticleEntity toEntity(ArticleDTO source); // cte data z dto a predava je dovnitr

    ArticleDTO toDTO(ArticleEntity source); // cte data z entity a predava je ven
}
