package camt.se331.shoppingcart.dao;

import camt.se331.shoppingcart.entity.Article;

import java.util.List;

/**
 * Created by raPhat on 5/18/16 AD.
 */
public interface ArticleDao {
    List<Article> getArticles();
    List<Article> getArticlesByTopic(String topic);
    Article getArticle(Long id);
    Article addArticle(Article article);
    Article deleteArticle(Article article);
    Article updateArticle(Article article);
}
