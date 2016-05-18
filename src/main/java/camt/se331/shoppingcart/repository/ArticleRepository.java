package camt.se331.shoppingcart.repository;

import camt.se331.shoppingcart.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by raPhat on 5/18/16 AD.
 */
public interface ArticleRepository extends JpaRepository<Article,Long> {
    List<Article> findByTopicContainingIgnoreCase(String topic);
}
