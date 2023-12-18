package com.example.demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.demo.demo.entities.Entreprise;

import java.util.List;

// JpaRepository for Entreprise
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
    @Query("select e from Entreprise e where e.secteur = ?1")
    List<Entreprise> findBySecteur(String secteur);
}