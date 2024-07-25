package com.example.demo.repository;

import com.example.demo.model.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface EvenementRepository extends JpaRepository<Evenement, Integer> {

    List<Evenement> findAllByDateEvenementOrCategorieOrLieu(LocalDate date,String categorie,String lieu);

//    List<Evenement> findByTitre(String titre);
//
//    List<Evenement> findByLieu(String lieu);
//
//    List<Evenement> findByDateEvenement(LocalDate dateEvenement);
//
//    List<Evenement> findByHeursEvenement(LocalTime heursEvenement);

//    List<Evenement> findByTitreContainingIgnoreCaseAndLieuContainingIgnoreCaseAndDateEvenementAAndHeursEvenement(
//            String titre, String lieu, LocalDate dateEvenement, LocalTime heursEvenement);
//}
}