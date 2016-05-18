package camt.se331.shoppingcart.service;

import camt.se331.shoppingcart.dao.ArticleDao;
import camt.se331.shoppingcart.entity.Article;
import camt.se331.shoppingcart.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by raPhat on 5/18/16 AD.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;

    @Override
    public List<Article> getArticles() {
        return articleDao.getArticles();
    }

    @Override
    public Article getArticle(Long id) {
        return articleDao.getArticle(id);
    }

    @Override
    public Article addArticle(Article article) {
        return articleDao.addArticle(article);
    }

    @Override
    public Article deleteArticle(Long id) {
        Article article = getArticle(id);
        return articleDao.deleteArticle(article);
    }

    @Override
    public Article updateArticle(Article article) {
        return articleDao.updateArticle(article);
    }

    @Override
    public List<Article> getArticlesByTopic(String topic) {
        return articleDao.getArticlesByTopic(topic);
    }

    @Override
    public Article addProduct(Article article, Product product) {
        article.getProductSet().add(product);
        articleDao.updateArticle(article);
        return article;
    }
}
