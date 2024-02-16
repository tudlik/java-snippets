package cz.jty.springboot_blog.model.services;

import cz.jty.springboot_blog.data.entities.ArticleEntity;
import cz.jty.springboot_blog.data.repositories.ArticleRepository;
import cz.jty.springboot_blog.model.dto.ArticleDTO;
import cz.jty.springboot_blog.model.dto.mappers.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleMapper articleMapper;


    @Override
    public void create(ArticleDTO article) {
        ArticleEntity newArticle = articleMapper.toEntity(article) ;

//        pouzit v pripade ze se nepouziva mapper
//        newArticle.setTitle(article.getTitle());
//        newArticle.setDescription(article.getDescription());
//        newArticle.setContent(article.getContent());

        articleRepository.save(newArticle);
    }

    @Override
    public List<ArticleDTO> getAll() {
        List<ArticleDTO> articleDTOList = new ArrayList<>();
        Iterable<ArticleEntity> articleEntities = articleRepository.findAll();
        for(ArticleEntity article: articleEntities ){
            articleDTOList.add(articleMapper.toDTO(article));
        }
        return articleDTOList;
    }

    @Override
    public ArticleDTO getById(long articleId) {
        ArticleEntity fetchedArticle = articleRepository.findById(articleId).orElseThrow();  // pokud neni clanek nalezen vyvhodi chybu NoSuchElementException
        return articleMapper.toDTO(fetchedArticle);
    }


}
