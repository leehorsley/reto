package com.mintic.Reto3.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.Reto3.Model.Skate;
import com.mintic.Reto3.Repository.SkateboardRepository;

@Service
public class SkateboardService {
    
    @Autowired
    private SkateboardRepository skateboardRepository;

    public List<Skate> getAll() {
        return skateboardRepository.getAll();
    }

    public Optional<Skate> getSkate(int id) {
        return skateboardRepository.getSkateboard(id);
    }

    public Skate save(Skate skate) {
        if (skate.getId() == null) {
            return skateboardRepository.save(skate);
        } else {
            Optional<Skate> skateboard1 = skateboardRepository.getSkateboard(skate.getId());
            if (skateboard1.isEmpty()) {
                return skateboardRepository.save(skate);
            } else {
                return skate;
            }
        }
    }

    

    public Skate update(Skate skateboard){
        if(skateboard.getId()!=null){
            Optional<Skate>g= skateboardRepository.getSkateboard(skateboard.getId());
            if(!g.isEmpty()){
                if(skateboard.getName()!=null){
                    g.get().setName(skateboard.getName());
                }
                if(skateboard.getBrand()!=null){
                    g.get().setBrand(skateboard.getBrand());
                }
                if(skateboard.getYear()!=null){
                    g.get().setYear(skateboard.getYear());
                }
                if(skateboard.getDescription()!=null){
                    g.get().setDescription(skateboard.getDescription());
                }
                skateboardRepository.save(g.get());
                return g.get();
            }else{
                return skateboard;
            }
        }else{
            return skateboard;
        }
    }

    /**public Skateboard update(Skateboard bike){
        if(bike.getId()!=null){
            Optional<Skateboard>g= skateboardRepository.getSkateboard(bike.getId());
            if(!g.isEmpty()){
                if(bike.getDescription()!=null){                    
                    g.get().setDescription(bike.getDescription());
                }
                if(bike.getName()!=null){
                    g.get().setName(bike.getName());
                }
                return skateboardRepository.save(g.get());
            }
        }
        return bike;
    }*/


    public boolean delete(int id){
        boolean flag = false;
        Optional<Skate> g = skateboardRepository.getSkateboard(id);
        if(g.isPresent()){
            skateboardRepository.delete(g.get());
        }
        return flag;
    }

    /**public boolean delete(int id){
        Boolean d= getSkateboard(id).map(skateboard -> {
                                                    skateboardRepository.delete(skateboard);
                                                        return true;
                                            }
                                      ).orElse(false);
        return d;
    }*/
}
