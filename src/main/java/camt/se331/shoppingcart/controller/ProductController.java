package camt.se331.shoppingcart.controller;

import camt.se331.shoppingcart.entity.Image;
import camt.se331.shoppingcart.entity.Product;
import camt.se331.shoppingcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * Created by Dto on 2/8/2015.
 */
@RestController
@RequestMapping("/")
@CrossOrigin
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "product",method = RequestMethod.GET)
    public  List<Product> list(){
        return productService.getProducts();
    }


    @RequestMapping(value = "getProduct",method = RequestMethod.GET)
    public  List<Product> getListByName(@RequestParam("name")String name){
        return productService.getProductsByName(name);
    }
    @RequestMapping(value = "product",method = RequestMethod.POST)
    public @ResponseBody Product add(@RequestBody Product product, BindingResult bindingResult){
        return productService.addProduct(product);
    }

    @RequestMapping(value = "product/{id}",method = RequestMethod.GET)
    public  Product getProduct(@PathVariable("id") Long id){
        return productService.getProduct(id);
    }

    @RequestMapping(value = "product/{id}",method = RequestMethod.PUT)
    public  Product edit(@PathVariable("id") Long id,@RequestBody Product product, BindingResult bindingResult){
        return productService.updateProduct(product);
    }

    @RequestMapping(value = "product/{id}",method = RequestMethod.DELETE)
    public  Product edit(@PathVariable("id") Long id){
        return productService.deleteProduct(id);
    }


    @RequestMapping(value = "product/delete/{id}/{productid}",method = RequestMethod.DELETE)
    public Product delete(@PathVariable("id") Long id,@PathVariable Long productid){
        Product product = productService.getProduct(productid);
        Set<Image> set = product.getImages();
        for (Image img : set) {
            if( img.getId().intValue() == id.intValue() ) {
                product.getImages().remove(img);
                break;
            }
        }
        return productService.updateProduct(product);
    }
}
