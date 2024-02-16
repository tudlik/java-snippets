package cz.jty.springboot_blog.model.services;

import cz.jty.springboot_blog.model.dto.ArticleDTO;

import java.util.List;

public interface ArticleService {
    void create(ArticleDTO article);

    List<ArticleDTO> getAll();

    ArticleDTO getById(long articleId);
}
