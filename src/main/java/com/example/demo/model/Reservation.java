package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation {
    @Id
    private Integer idReservetion;
    @Column
    private LocalDate dateReservation;
    @Column
    private LocalTime HeursReservation;
    @ManyToOne
    private Evenement evenement;
    @ManyToOne
    private User user;

}
