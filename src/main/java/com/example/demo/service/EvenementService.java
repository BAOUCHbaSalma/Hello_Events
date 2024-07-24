package com.example.demo.service;

import com.example.demo.model.Evenement;
import com.example.demo.repository.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
       return evenementRepository.save(evenement1);
    }
}
