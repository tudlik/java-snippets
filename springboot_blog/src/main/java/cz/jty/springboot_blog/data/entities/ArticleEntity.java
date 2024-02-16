package cz.jty.springboot_blog.data.entities;

import jakarta.persistence.*;

@Entity
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator( )  // jedna se o volbu pokud by databaze neumoznila automaticke generovani
    private long articleId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private String description;


    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
