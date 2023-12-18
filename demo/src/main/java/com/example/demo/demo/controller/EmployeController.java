package com.example.demo.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.demo.repository.EmployeRepository;

import com.example.demo.demo.entities.Employe;

import com.example.demo.demo.services.EmployeService;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/employe")
public class EmployeController {
    @Autowired
    private EmployeService employeService;

    @GetMapping("/projet/{projetNom}")
    public ResponseEntity<List<Employe>> findEmployesByProjetNom(@PathVariable String projetNom) {
        List<Employe> employes = employeService.findEmployesByProjetNom(projetNom);
        if (employes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(employes, HttpStatus.OK);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Employe> createEmploye(@RequestBody Employe employe) {
        if (employe.getProjets().isEmpty()) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        } else {
            Employe createdEmploye = employeService.createEmploye(employe);
            return new ResponseEntity<>(createdEmploye, HttpStatus.CREATED);
        }
    }

    @Autowired
    private EmployeRepository employeRepository;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmploye(@PathVariable Long id) {
        Optional<Employe> employe = employeRepository.findById(id);
        if (employe.isPresent()) {
            employeRepository.deleteById(id);
            return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No content", HttpStatus.NO_CONTENT);
        }
    }

}
