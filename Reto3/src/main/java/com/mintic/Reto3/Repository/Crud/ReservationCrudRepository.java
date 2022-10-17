package com.mintic.Reto3.Repository.Crud;

import org.springframework.data.repository.CrudRepository;

import com.mintic.Reto3.Model.Reservation;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
    
}
