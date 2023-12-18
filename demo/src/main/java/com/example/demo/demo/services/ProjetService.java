package com.example.demo.demo.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.demo.repository.EntrepriseRepository;
import com.example.demo.demo.repository.ProjetRepository;
import com.example.demo.demo.entities.Entreprise;
import com.example.demo.demo.entities.Projet;

import java.util.List;

@Service
public class ProjetService {
    @Autowired
    private ProjetRepository projetRepository;

    public List<Projet> findByDescriptionContaining(String description) {
        return projetRepository.findByDescriptionContaining(description);
    }

    public Projet createProjet(Projet projet) {
        return projetRepository.save(projet);
    }
}
