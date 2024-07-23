package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Evenement {
    @Id
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
    private LocalTime heursEvenement;
    @Column
    private String image;
}
