package com.example.demo.repository;

import com.example.demo.model.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvenementRepository extends JpaRepository<Evenement ,Integer> {
}
