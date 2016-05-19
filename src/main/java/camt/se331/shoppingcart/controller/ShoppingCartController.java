package camt.se331.shoppingcart.controller;

import camt.se331.shoppingcart.entity.*;
import camt.se331.shoppingcart.service.ProductService;
import camt.se331.shoppingcart.service.ProgressService;
import camt.se331.shoppingcart.service.ShoppingCartService;
import camt.se331.shoppingcart.service.UserService;
import org.hibernate.internal.util.compare.CalendarComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Dto on 4/6/2015.
 */
@RestController
@RequestMapping("/shoppingcart")
@CrossOrigin
@Scope("session")
public class ShoppingCartController {
    @Autowired
    ShoppingCartService shoppingCartService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProgressService progressService;



    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ShoppingCart getShoppingCart(@PathVariable("id") Long id) {
        return shoppingCartService.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ShoppingCart updateShoppingCart(@PathVariable("id") Long id, @RequestBody ShoppingCart cart, BindingResult bindingResult) {
        return shoppingCartService.addShoppingCart(cart);
    }

    @RequestMapping(value = "/addToCart/{id}", method = RequestMethod.POST)
    public ShoppingCart addProduct(@PathVariable("id") Long id,@RequestBody ShoppingCart shoppingCart, BindingResult bindingResult, Model model, HttpServletRequest httpServletRequest) {

        Product product = productService.getProduct(id);
        return shoppingCartService.addSelectedProduct(shoppingCart, product);
    }

    @RequestMapping(value="/saveCart",method= RequestMethod.POST)
    public ShoppingCart saveCart(@RequestBody ShoppingCart shoppingCart){
        User user = userService.findByUserName(shoppingCart.getUser().getUsername());
        shoppingCart.setUser(user);
        ShoppingCart cart = shoppingCartService.addShoppingCart(shoppingCart);
        Progress progress = new Progress("",false,"WaitingForCalculation");
        progress.setCart(cart);
        progressService.addProgress(progress);
        return cart;
    }

    @RequestMapping(value = "/progress/{id}", method = RequestMethod.GET)
    public List<Progress> list(@PathVariable("id") Long id) {
        return progressService.getProgressesByCart(id);
    }

    @RequestMapping(value = "/progress", method = RequestMethod.GET)
    public List<Progress> listAll() {
        return progressService.getProgresses();
    }


}
