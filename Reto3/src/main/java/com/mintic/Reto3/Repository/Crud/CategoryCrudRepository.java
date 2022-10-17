package com.mintic.Reto3.Repository.Crud;

import org.springframework.data.repository.CrudRepository;

import com.mintic.Reto3.Model.Category;

public interface CategoryCrudRepository extends CrudRepository<Category, Integer> {
    
}
