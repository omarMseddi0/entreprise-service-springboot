package com.example.demo.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.demo.demo.entities.Departement;

import java.util.List;
public interface DepartementRepository extends JpaRepository<Departement, Long> {
    @Query("select d from Departement d where d.entreprise.nom = ?1")
    List<Departement> findByEntrepriseNom(String nomEntreprise);
}
