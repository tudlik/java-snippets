package cz.jty.springboot_blog.data.repositories;

import cz.jty.springboot_blog.data.entities.ArticleEntity;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<ArticleEntity, Long> {
}
