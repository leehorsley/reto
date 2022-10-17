package com.mintic.Reto3.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.Reto3.Model.Reservation;
import com.mintic.Reto3.Repository.ReservationRepository;

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> reservation1 = reservationRepository.getReservation(reservation.getIdReservation());
            if (reservation1.isEmpty()) {
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation>g= reservationRepository.getReservation(reservation.getIdReservation());
            if(!g.isEmpty()){
                if(reservation.getStartDate()!=null){                    
                    g.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){                    
                    g.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){                    
                    g.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(g.get());
                return g.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean delete(int id){
        boolean flag = false;
        Optional<Reservation> g = reservationRepository.getReservation(id);
        if(g.isPresent()){
            reservationRepository.delete(g.get());
        }
        return flag;
    }
}
