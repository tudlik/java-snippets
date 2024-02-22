package cz.jty.springboot_blog.model.dto.mappers;

import cz.jty.springboot_blog.data.entities.ArticleEntity;
import cz.jty.springboot_blog.model.dto.ArticleDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-22T08:59:09+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Amazon.com Inc.)"
)
@Component
public class ArticleMapperImpl implements ArticleMapper {

    @Override
    public ArticleEntity toEntity(ArticleDTO source) {
        if ( source == null ) {
            return null;
        }

        ArticleEntity articleEntity = new ArticleEntity();

        articleEntity.setArticleId( source.getArticleId() );
        articleEntity.setTitle( source.getTitle() );
        articleEntity.setDescription( source.getDescription() );
        articleEntity.setContent( source.getContent() );

        return articleEntity;
    }

    @Override
    public ArticleDTO toDTO(ArticleEntity source) {
        if ( source == null ) {
            return null;
        }

        ArticleDTO articleDTO = new ArticleDTO();

        articleDTO.setArticleId( source.getArticleId() );
        articleDTO.setTitle( source.getTitle() );
        articleDTO.setDescription( source.getDescription() );
        articleDTO.setContent( source.getContent() );

        return articleDTO;
    }
}
