package camt.se331.shoppingcart.service;

import camt.se331.shoppingcart.entity.Article;
import camt.se331.shoppingcart.entity.Image;
import camt.se331.shoppingcart.entity.Product;
import camt.se331.shoppingcart.entity.User;

import java.util.List;

/**
 * Created by raPhat on 5/18/16 AD.
 */
public interface ArticleService {
    List<Article> getArticles();
    Article getArticle(Long id);
    Article addArticle(Article article);
    Article deleteArticle(Long id);
    Article updateArticle(Article article);
    List<Article> getArticlesByTopic(String topic);
    Article addProduct (Article article,Product product);
    Article addImage (Article article,Image image);
}
