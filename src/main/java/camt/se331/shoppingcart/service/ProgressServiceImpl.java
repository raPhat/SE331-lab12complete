package camt.se331.shoppingcart.service;

import camt.se331.shoppingcart.dao.ProgressDao;
import camt.se331.shoppingcart.entity.Progress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by raPhat on 5/19/16 AD.
 */
@Service
public class ProgressServiceImpl implements ProgressService {
    @Autowired
    ProgressDao progressDao;

    @Override
    public List<Progress> getProgresses() {
        return progressDao.getProgresses();
    }

    @Override
    public Progress getProgress(Long id) {
        return progressDao.getProgress(id);
    }

    @Override
    public Progress addProgress(Progress progress) {
        return progressDao.addProgress(progress);
    }

    @Override
    public Progress deleteProgress(Long id) {
        return progressDao.deleteProgress( getProgress(id) );
    }

    @Override
    public Progress updateProgress(Progress progress) {
        return progressDao.updateProgress(progress);
    }

    @Override
    public List<Progress> getProgressesByProgressName(String name) {
        return progressDao.getProgressesByProgressName(name);
    }

    @Override
    public List<Progress> getProgressesByCart(Long id) {
        return progressDao.getProgressesByCart(id);
    }
}
