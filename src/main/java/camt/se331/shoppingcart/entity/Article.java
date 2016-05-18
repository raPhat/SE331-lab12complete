package camt.se331.shoppingcart.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by raPhat on 5/18/16 AD.
 */
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String topic;
    private String content;

    @ManyToOne
    private User user;

    @ManyToMany
    @Cascade(CascadeType.ALL)
    private Set<Product> productSet = new HashSet<>();


    @Temporal(TemporalType.TIMESTAMP)
    Date createdDate;

    public Article() {
    }

    public Article(String topic, String content) {
        this.topic = topic;
        this.content = content;
        this.setCreatedDate(Calendar.getInstance().getTime());
    }

    public Article(String topic, String content, User user, Set<Product> productSet, Date createdDate) {
        this.topic = topic;
        this.content = content;
        this.user = user;
        this.productSet = productSet;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;

        Article article = (Article) o;

        if (getId() != null ? !getId().equals(article.getId()) : article.getId() != null) return false;
        if (getTopic() != null ? !getTopic().equals(article.getTopic()) : article.getTopic() != null) return false;
        if (getContent() != null ? !getContent().equals(article.getContent()) : article.getContent() != null)
            return false;
        if (getUser() != null ? !getUser().equals(article.getUser()) : article.getUser() != null) return false;
        if (getProductSet() != null ? !getProductSet().equals(article.getProductSet()) : article.getProductSet() != null)
            return false;
        return !(getCreatedDate() != null ? !getCreatedDate().equals(article.getCreatedDate()) : article.getCreatedDate() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTopic() != null ? getTopic().hashCode() : 0);
        result = 31 * result + (getContent() != null ? getContent().hashCode() : 0);
        result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
        result = 31 * result + (getProductSet() != null ? getProductSet().hashCode() : 0);
        result = 31 * result + (getCreatedDate() != null ? getCreatedDate().hashCode() : 0);
        return result;
    }
}
