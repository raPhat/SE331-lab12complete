package camt.se331.shoppingcart.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dto on 2/7/2015.
 */
@Entity
public class Product implements Comparable{
    @Id
    @GeneratedValue
    Long id;
    String name;
    String nameTh;
    String description;
    String descriptionTh;
    Double totalPrice;
    Double wholesalePrice;


    @ManyToMany
    @Cascade(CascadeType.ALL)
    @JsonBackReference
    private Set<Article> articles = new HashSet<>();

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    Set<Image> images = new HashSet<>();

    public Product(Long id,String name, String description, Double totalPrice, Image image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.totalPrice = totalPrice;
        this.images.add(image) ;
    }



    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product(){

    };

    public Product(Long id,String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.totalPrice = price;
        this.id = id;
    }

    public Product(String name, String nameTh, String description, String descriptionTh, Double totalPrice, Double wholesalePrice) {
        this.name = name;
        this.nameTh = nameTh;
        this.description = description;
        this.descriptionTh = descriptionTh;
        this.totalPrice = totalPrice;
        this.wholesalePrice = wholesalePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (getId() != null ? !getId().equals(product.getId()) : product.getId() != null) return false;
        if (getName() != null ? !getName().equals(product.getName()) : product.getName() != null) return false;
        if (getNameTh() != null ? !getNameTh().equals(product.getNameTh()) : product.getNameTh() != null) return false;
        if (getDescription() != null ? !getDescription().equals(product.getDescription()) : product.getDescription() != null)
            return false;
        if (getDescriptionTh() != null ? !getDescriptionTh().equals(product.getDescriptionTh()) : product.getDescriptionTh() != null)
            return false;
        if (getTotalPrice() != null ? !getTotalPrice().equals(product.getTotalPrice()) : product.getTotalPrice() != null)
            return false;
        return !(getWholesalePrice() != null ? !getWholesalePrice().equals(product.getWholesalePrice()) : product.getWholesalePrice() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getNameTh() != null ? getNameTh().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getDescriptionTh() != null ? getDescriptionTh().hashCode() : 0);
        result = 31 * result + (getTotalPrice() != null ? getTotalPrice().hashCode() : 0);
        result = 31 * result + (getWholesalePrice() != null ? getWholesalePrice().hashCode() : 0);
        return result;
    }

    public String getNameTh() {
        return nameTh;
    }

    public void setNameTh(String nameTh) {
        this.nameTh = nameTh;
    }

    public String getDescriptionTh() {
        return descriptionTh;
    }

    public void setDescriptionTh(String descriptionTh) {
        this.descriptionTh = descriptionTh;
    }

    public Double getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(Double wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public int compareTo(Object o) {

        return (int) (this.getId() - ((Product)o).getId());
    }
}
