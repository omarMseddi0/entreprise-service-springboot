package com.example.demo.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.demo.repository.DepartementRepository;

import com.example.demo.demo.entities.Departement;

import com.example.demo.demo.services.DepartementService;


@RestController
@RequestMapping("/departement")
public class DepartementController {
    @Autowired
    private DepartementService departementService;

    @GetMapping("/search")
    public ResponseEntity<List<Departement>> findByEntrepriseNom(@RequestParam String name) {
        List<Departement> departements = departementService.findByEntrepriseNom(name);
        if (departements.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(departements, HttpStatus.OK);
        }
    }


    @PostMapping("/")
    public ResponseEntity<Departement> createDepartement(@RequestBody Departement departement) {
        if (departement.getEntreprise() == null) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        } else {
            Departement createdDepartement = departementService.createDepartement(departement);
            return new ResponseEntity<>(createdDepartement, HttpStatus.CREATED);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departement> updateDepartement(@PathVariable Long id, @RequestBody Departement departement) {
        departement.setId(id);
        Departement updatedDepartement = departementService.updateDepartement(departement);
        if (updatedDepartement != null) {
            return new ResponseEntity<>(updatedDepartement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @Autowired
    private DepartementRepository departementRepository;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartement(@PathVariable Long id) {
        Optional<Departement> departement = departementRepository.findById(id);
        if (departement.isPresent()) {
            departementRepository.deleteById(id);
            return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No content", HttpStatus.NO_CONTENT);
        }
    }

}
