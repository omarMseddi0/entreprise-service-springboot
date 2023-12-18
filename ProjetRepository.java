package com.example.demo.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.demo.entities.Projet;

import java.util.List;
public interface ProjetRepository extends JpaRepository<Projet, Long> {
    @Query("select p from Projet p where p.description like %?1%")
    List<Projet> findByDescriptionContaining(String description);
}
