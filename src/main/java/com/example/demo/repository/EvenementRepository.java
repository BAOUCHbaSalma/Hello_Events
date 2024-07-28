package com.example.demo.repository;

import com.example.demo.model.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface EvenementRepository extends JpaRepository<Evenement, Integer> , QuerydslPredicateExecutor<Evenement> {

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

//    List <Evenement> findByUser_UserId(Integer userId);
//    @Query(value = "SELECT e.* FROM Evenement e INNER JOIN Reservation r ON e.idEvenement = r.evenement_id INNER JOIN " +
//            "User u ON r.user_id = u.user_id WHERE u.user_id = :idUser AND u.role = 'USER'",
//            nativeQuery = true)
//    List<Evenement> findEvenementReservee(@Param("idUser") Integer idUser);
}