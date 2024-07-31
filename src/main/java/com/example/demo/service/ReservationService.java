package com.example.demo.service;

import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> showReservations(){
        return reservationRepository.findAll();
    }

    public Reservation addReservation(Reservation reservation){
        System.out.println("/////////////////:::"+reservation.getHeursReservation());


        return reservationRepository.save(reservation);
    }
    public List<Reservation> showReservationsByIdUser(Integer idUser){
        return reservationRepository.findByUser_UserId(idUser);
    }
}
