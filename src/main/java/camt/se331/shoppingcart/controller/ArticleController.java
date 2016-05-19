package camt.se331.shoppingcart.controller;

import camt.se331.shoppingcart.entity.Article;
import camt.se331.shoppingcart.entity.Image;
import camt.se331.shoppingcart.entity.Product;
import camt.se331.shoppingcart.entity.User;
import camt.se331.shoppingcart.service.ArticleService;
import camt.se331.shoppingcart.service.ProductService;
import camt.se331.shoppingcart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Iterator;
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


    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Article add(@RequestParam("topic")String topic,@RequestParam("content")String content,@RequestParam("username")String username){
        Article article = new Article(topic,content);
        article.setUser( userService.findByUserName( username ) );
        return articleService.addArticle(article);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public  Article delete(@PathVariable("id") Long id){
        return articleService.deleteArticle(id);
    }

    @RequestMapping(value = "/addImage",method = RequestMethod.POST)
    @ResponseBody
    public Article addImage(HttpServletRequest request,
                            HttpServletResponse response, @RequestParam("articleid")Long articleid){
        MultipartHttpServletRequest mRequest;
        Article article = articleService.getArticle(articleid);
        try{
            mRequest = (MultipartHttpServletRequest)request;
            Iterator<String> itr= mRequest.getFileNames();
            while(itr.hasNext()){
                MultipartFile multipartFile = mRequest.getFile(itr.next());
                Image image = new Image();
                image.setFileName(multipartFile.getOriginalFilename());
                image.setContentType(multipartFile.getContentType());
                image.setContent(multipartFile.getBytes());;
                image.setCreated(Calendar.getInstance().getTime());
                articleService.addImage(article,image);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return article;
    }
}
