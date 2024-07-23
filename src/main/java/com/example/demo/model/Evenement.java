package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvenement;
    @Column
    private String titre;
    @Column
    private String description;
    @Column
    private String lieu;
    @Column
    private LocalDate dateEvenement;
    @Column
    private Double prix;
    @Column
    private LocalTime heursEvenement;
    @Column
    private String image;
    @OneToMany(mappedBy = "evenement")
    @JsonIgnore
    private List<Reservation> reservationList;
}
