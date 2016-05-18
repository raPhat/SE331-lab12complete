package camt.se331.shoppingcart.dao;

import camt.se331.shoppingcart.entity.Article;
import camt.se331.shoppingcart.entity.Progress;

import java.util.List;

/**
 * Created by raPhat on 5/18/16 AD.
 */
public interface ProgressDao {
    List<Progress> getProgresses();
    List<Progress> getProgressesByProgressName(String name);
    Progress getProgress(Long id);
    Progress addProgress(Progress progress);
    Progress deleteProgress(Progress progress);
    Progress updateProgress(Progress progress);
}
