package com.example.demo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.demo.entities.Entreprise;
import com.example.demo.demo.services.EntrepriseService;
import com.example.demo.demo.repository.EntrepriseRepository;


import java.util.List;
import java.util.Optional;

// Controller for Entreprise
@RestController
@RequestMapping("/entreprise")
public class EntrepriseController {
    @Autowired
    private EntrepriseService entrepriseService;

    @GetMapping("/secteur/{secteur}")
    public ResponseEntity<List<Entreprise>> findBySecteur(@PathVariable String secteur) {
        List<Entreprise> entreprises = entrepriseService.findBySecteur(secteur);
        if (entreprises.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(entreprises, HttpStatus.OK);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Entreprise> createEntreprise(@RequestBody Entreprise entreprise) {
        Entreprise createdEntreprise = entrepriseService.createEntreprise(entreprise);
        return new ResponseEntity<>(createdEntreprise, HttpStatus.CREATED);
    }

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntreprise(@PathVariable Long id) {
        Optional<Entreprise> entreprise = entrepriseRepository.findById(id);
        if (entreprise.isPresent()) {
            entrepriseRepository.deleteById(id);
            return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No content", HttpStatus.NO_CONTENT);
        }
    }

}
