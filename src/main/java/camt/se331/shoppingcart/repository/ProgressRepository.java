package camt.se331.shoppingcart.repository;

import camt.se331.shoppingcart.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by raPhat on 5/18/16 AD.
 */
public interface ProgressRepository extends JpaRepository<Progress,Long> {
    List<Progress> findByProgressNameContainingIgnoreCase(String topic);
}