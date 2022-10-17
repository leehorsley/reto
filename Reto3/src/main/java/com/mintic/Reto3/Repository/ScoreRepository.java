package com.mintic.Reto3.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mintic.Reto3.Model.Score;
import com.mintic.Reto3.Repository.Crud.ScoreCRUDRepository;

@Repository
public class ScoreRepository {
    
    @Autowired
    private ScoreCRUDRepository scoreCrudRepository;

    public List<Score> getAll(){
        return (List<Score>)scoreCrudRepository.findAll();
    }

    public Optional<Score> getScore(int id){
        return scoreCrudRepository.findById(id);
    }
    
    public Score save(Score score){
        return scoreCrudRepository.save(score);
    }

    public void delete(Score score){
        scoreCrudRepository.delete(score);
    }
}
