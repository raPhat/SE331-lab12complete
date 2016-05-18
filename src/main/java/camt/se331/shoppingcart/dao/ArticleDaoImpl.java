package camt.se331.shoppingcart.dao;

import camt.se331.shoppingcart.entity.Article;
import camt.se331.shoppingcart.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by raPhat on 5/18/16 AD.
 */
@Repository
public class ArticleDaoImpl implements ArticleDao {
    @Autowired
    ArticleRepository articleRepository;

    @Override
    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    @Override
    public List<Article> getArticlesByTopic(String topic) {
        return articleRepository.findByTopicContainingIgnoreCase(topic);
    }

    @Override
    public Article getArticle(Long id) {
        return articleRepository.findOne(id);
    }

    @Override
    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article deleteArticle(Article article) {
        articleRepository.delete(article);
        article.setId(null);
        return article;
    }

    @Override
    public Article updateArticle(Article article) {
        return articleRepository.save(article);
    }
}
