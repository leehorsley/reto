package com.mintic.Reto3.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.Reto3.Model.Category;
import com.mintic.Reto3.Repository.CategoryRepository;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    //@org.springframework.beans.factory.annotation.Autowired(required=true)
    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category save(Category category) {
        if (category.getId() == null) {
            return categoryRepository.save(category);
        } else {
            Optional<Category> category1 = categoryRepository.getCategory(category.getId());
            if (category1.isEmpty()) {
                return categoryRepository.save(category);
            } else {
                return category;
            }
        }
    }

    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category>g= categoryRepository.getCategory(category.getId());
            if(!g.isEmpty()){
                if(category.getDescription()!=null){                    
                    g.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    g.get().setName(category.getName());
                }
                if(category.getSkates()!=null){
                    g.get().setSkates(category.getSkates());
                }
                categoryRepository.save(g.get());
                return g.get();
            }else{
                return category;
            }
        }else{
            return category;
        }
    }

    /**public boolean deleteCategory(int id){
        return getCategory(id).map(category -> {
            categoryRepository.delete(category);
                return true;
                }
            ).orElse(false);
    }*/

    public boolean delete(int id){
        boolean flag = false;
        Optional<Category> g = categoryRepository.getCategory(id);
        if(g.isPresent()){
            categoryRepository.delete(g.get());
        }
        return flag;
    }
    
}
