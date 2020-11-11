package com.phoebus.pandemic.test.teste_phoebus.services;

import com.phoebus.pandemic.test.teste_phoebus.domain.Score;
import com.phoebus.pandemic.test.teste_phoebus.repositories.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository repo;

    public List<Score> findAll() {
        return repo.findAll();
    }

    @Transactional
    public Score insert (Score obj){
        obj.setId(null);
        return repo.save(obj);
    }

    @Transactional
    public Score update(Integer id, Integer points) {
        Score score = repo.getOne(id);
        score.setPoints(points);
        return repo.save(score);
    }

}
