package com.example.demo.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.demo.entities.Departement;
import com.example.demo.demo.entities.Projet;
import com.example.demo.demo.services.ProjetService;

import java.util.List;
@RestController
@RequestMapping("/projet")
public class ProjetController {
    @Autowired
    private ProjetService projetService;

    @GetMapping("/description/{description}")
    public ResponseEntity<List<Projet>> findByDescriptionContaining(@PathVariable String description) {
        List<Projet> projets = projetService.findByDescriptionContaining(description);
        if (projets.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(projets, HttpStatus.OK);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Projet> createProjet(@RequestBody Projet projet) {
        if (projet.getEmployes().isEmpty()) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        } else {
            Projet createdProjet = projetService.createProjet(projet);
            return new ResponseEntity<>(createdProjet, HttpStatus.CREATED);
        }
    }
    
    
}
