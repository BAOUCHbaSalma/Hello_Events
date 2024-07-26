package com.example.demo.service;

import com.example.demo.model.Evenement;
import com.example.demo.repository.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class EvenementService {
    @Autowired
    private EvenementRepository evenementRepository;

    public Evenement addEvenement(Evenement evenement){
        return evenementRepository.save(evenement);
    }

    public List<Evenement> showEvents(){
        return evenementRepository.findAll();
    }
    public void deleteEvent(Integer idEvent){
        evenementRepository.deleteById(idEvent);
    }
    public Evenement showEvent(Integer idEvent){
       return evenementRepository.findById(idEvent).orElseThrow();
    }

    public Evenement updateEvent(Integer idEvenement,Evenement evenement){
        Evenement evenement1=showEvent(idEvenement);
        evenement1.setLieu(evenement.getLieu());
        evenement1.setImage(evenement.getImage());
        evenement1.setDescription(evenement.getDescription());
        evenement1.setDateEvenement(evenement.getDateEvenement());
        evenement1.setHeursEvenement(evenement.getHeursEvenement());
        evenement1.setTitre(evenement.getTitre());
        evenement1.setPrix(evenement.getPrix());
        evenement1.setCategorie(evenement.getCategorie());
       return evenementRepository.save(evenement1);
    }

//    public List<Evenement> searchEvents(String titre, String lieu, LocalDate dateEvenement, LocalTime heursEvenement) {
//        if (titre != null && lieu != null && dateEvenement != null && heursEvenement != null) {
//            return evenementRepository.findByTitreContainingIgnoreCaseAndLieuContainingIgnoreCaseAndDateEvenementAAndHeursEvenement(
//                    titre, lieu, dateEvenement, heursEvenement);
//        }
//        if (titre != null && lieu != null && dateEvenement != null) {
//            return evenementRepository.findByTitreContainingIgnoreCaseAndLieuContainingIgnoreCaseAndDateEvenementAAndHeursEvenement(
//                    titre, lieu, dateEvenement, heursEvenement);
//        }
//        // Add more conditions as needed based on combinations of parameters
//        return evenementRepository.findAll(); // Default to returning all events if no parameters are provided
//    }
//    public List<Evenement> findEventByTitre(String titre){
//        return evenementRepository.findByTitre(titre);
//    }
//    public List<Evenement> findEventByLieu(String lieu){
//        return evenementRepository.findByLieu(lieu);
//    }
//
//    public List<Evenement> findByDateEvenement(LocalDate dateEvenement){
//        return evenementRepository.findByDateEvenement(dateEvenement);
//    }

     public List<Evenement> findEvents(LocalDate date,String categorie,String lieu){
        return evenementRepository.findAllByDateEvenementOrCategorieOrLieu(date,categorie,lieu);
     }
//     public List<Evenement> findEventsByIduser(Integer idUser){
//        return evenementRepository.findByUser_UserId(idUser);
//     }
//     public List<Evenement> findEventsReserver(Integer idUser){
//        return evenementRepository.findEvenementReservee(idUser);
//
//     }
}
