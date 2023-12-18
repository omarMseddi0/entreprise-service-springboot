package com.example.demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.demo.entities.Employe;

import java.util.List;


public interface EmployeRepository extends JpaRepository<Employe, Long> {
	@Query("select e from Employe e join e.projets p where p.nom = ?1")
    List<Employe> findEmployesByProjetNom(String projetNom);

    @Transactional
    @Modifying
    @Query("delete from Employe e where e.poste = ?1")
    void deleteByPoste(String poste);
}


