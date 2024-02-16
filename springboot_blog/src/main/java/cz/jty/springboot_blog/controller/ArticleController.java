package cz.jty.springboot_blog.controller;

import cz.jty.springboot_blog.model.dto.ArticleDTO;
import cz.jty.springboot_blog.model.services.ArticleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @GetMapping
    public String renderIndex(Model model){
        List<ArticleDTO> articles = articleService.getAll();
        model.addAttribute("articles", articles);
        return "pages/articles/index";
    }

    @GetMapping("/create")
    public String renderCreateForm(@ModelAttribute ArticleDTO article){
        return "pages/articles/create";
    }

    @PostMapping("/create")
    public String createArticle(@Valid @ModelAttribute ArticleDTO article, BindingResult result){
        if(result.hasErrors()){
            return renderCreateForm(article);
        }
        articleService.create(article);
        return "redirect:/articles";
    }

    @GetMapping("{articleId}")
    public String renderDetail(@PathVariable ("articleId") long articleId, Model model){
        ArticleDTO articleDTO = articleService.getById(articleId);
        model.addAttribute("article", articleDTO);
        return "pages/articles/detail";
    }

}
