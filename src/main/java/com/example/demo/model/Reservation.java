package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservetion;
    @Column
    private LocalDate dateReservation;
    @Column
    private LocalTime heursReservation;
    @ManyToOne
    @JoinColumn(name = "idEvenement")
    private Evenement evenement;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

}
