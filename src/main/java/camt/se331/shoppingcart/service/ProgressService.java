package camt.se331.shoppingcart.service;

import camt.se331.shoppingcart.entity.Image;
import camt.se331.shoppingcart.entity.Product;
import camt.se331.shoppingcart.entity.Progress;

import java.util.List;

/**
 * Created by raPhat on 5/19/16 AD.
 */
public interface ProgressService {
    List<Progress> getProgresses();
    Progress getProgress(Long id);
    Progress addProgress(Progress progress);
    Progress deleteProgress(Long id);
    Progress updateProgress(Progress progress);
    List<Progress> getProgressesByProgressName(String name);
    List<Progress> getProgressesByCart(Long id);
}
