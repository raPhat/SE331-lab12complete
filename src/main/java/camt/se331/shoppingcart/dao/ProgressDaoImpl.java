package camt.se331.shoppingcart.dao;

import camt.se331.shoppingcart.entity.Progress;
import camt.se331.shoppingcart.repository.ProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by raPhat on 5/18/16 AD.
 */
@Repository
public class ProgressDaoImpl implements ProgressDao {
    @Autowired
    ProgressRepository progressRepository;

    @Override
    public List<Progress> getProgresses() {
        return progressRepository.findAll();
    }

    @Override
    public List<Progress> getProgressesByProgressName(String name) {
        return progressRepository.findByProgressNameContainingIgnoreCase(name);
    }

    @Override
    public Progress getProgress(Long id) {
        return progressRepository.findOne(id);
    }

    @Override
    public Progress addProgress(Progress progress) {
        return progressRepository.save(progress);
    }

    @Override
    public Progress deleteProgress(Progress progress) {
        progressRepository.delete(progress);
        progress.setId(null);
        return progress;
    }

    @Override
    public Progress updateProgress(Progress progress) {
        return progressRepository.save(progress);
    }
}
