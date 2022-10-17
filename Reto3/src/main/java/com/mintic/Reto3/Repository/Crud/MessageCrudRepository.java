package com.mintic.Reto3.Repository.Crud;

import org.springframework.data.repository.CrudRepository;

import com.mintic.Reto3.Model.Message;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
    
}
