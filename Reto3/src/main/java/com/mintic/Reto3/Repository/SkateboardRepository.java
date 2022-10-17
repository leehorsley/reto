package com.mintic.Reto3.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mintic.Reto3.Model.Skate;
import com.mintic.Reto3.Repository.Crud.SkateboardCrudRepository;

@Repository
public class SkateboardRepository {

    @Autowired
    private SkateboardCrudRepository skateboardCrudRepository;

    public List<Skate> getAll(){
        return (List<Skate>)skateboardCrudRepository.findAll();
    }

    public Optional<Skate> getSkateboard(int id){
        return skateboardCrudRepository.findById(id);
    }
    
    public Skate save(Skate skate){
        return skateboardCrudRepository.save(skate);
    }

    public void delete(Skate skate){
        skateboardCrudRepository.delete(skate);
    }
}
