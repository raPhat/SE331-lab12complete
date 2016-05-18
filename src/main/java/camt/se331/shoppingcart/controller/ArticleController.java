package camt.se331.shoppingcart.controller;

import camt.se331.shoppingcart.entity.Article;
import camt.se331.shoppingcart.entity.Product;
import camt.se331.shoppingcart.entity.User;
import camt.se331.shoppingcart.service.ArticleService;
import camt.se331.shoppingcart.service.ProductService;
import camt.se331.shoppingcart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by raPhat on 5/18/16 AD.
 */
@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Article> list(){
        return articleService.getArticles();
    }


    @RequestMapping(value = "/getArticles",method = RequestMethod.GET)
    public  List<Article> getListByTopic(@RequestParam("topic")String topic){
        return articleService.getArticlesByTopic(topic);
    }
    @RequestMapping(value = "/user/{topic}/{content}",method = RequestMethod.GET)
    public Article addUser(@PathVariable("topic") String topic, @PathVariable("content") String content){
        Article article = new Article(topic,content);
        article.setUser( userService.findByUserName("user") );
        return articleService.addArticle(article);
    }
    @RequestMapping(value = "/product/{id}/{idProduct}",method = RequestMethod.GET)
    public Article addProduct(@PathVariable("id") Long id, @PathVariable("idProduct") Long idProduct){
        Article article = articleService.getArticle(id);
        Product product = productService.getProduct(idProduct);
        article.getProductSet().add(product);
        return articleService.addArticle(article);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Article get(@PathVariable("id") Long id){
        return articleService.getArticle(id);
    }
}
