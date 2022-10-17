package com.mintic.Reto3.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.Reto3.Model.Score;
import com.mintic.Reto3.Repository.ScoreRepository;

@Service
public class ScoreService {
    
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id) {
        return scoreRepository.getScore(id);
    }

    public Score save(Score score) {
        if (score.getScoreId() == null) {
            return scoreRepository.save(score);
        } else {
            Optional<Score> score1 = scoreRepository.getScore(score.getScoreId());
            if (score1.isEmpty()) {
                return scoreRepository.save(score);
            } else {
                return score;
            }
        }
    }

    public Score update(Score score){
        if(score.getScoreId()!=null){
            Optional<Score>g= scoreRepository.getScore(score.getScoreId());
            if(!g.isEmpty()){
                if(score.getDescription()!=null){                    
                    g.get().setDescription(score.getDescription());
                }
                if(score.getPuntaje()!=null){
                    g.get().setPuntaje(score.getPuntaje());
                }
                scoreRepository.save(g.get());
                return g.get();
            }else{
                return score;
            }
        }else{
            return score;
        }
    }

    public boolean delete(int id){
        boolean flag = false;
        Optional<Score> g = scoreRepository.getScore(id);
        if(g.isPresent()){
            scoreRepository.delete(g.get());
        }
        return flag;
    }
}
