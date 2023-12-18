package com.example.demo.demo.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.demo.repository.EntrepriseRepository;
import com.example.demo.demo.entities.Entreprise;

import java.util.List;
@Service
public class EntrepriseService {
    @Autowired
    private EntrepriseRepository entrepriseRepository;

    public List<Entreprise> findBySecteur(String secteur) {
        return entrepriseRepository.findBySecteur(secteur);
    }

    public Entreprise createEntreprise(Entreprise entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    public void deleteEntreprise(Long id) {
        entrepriseRepository.deleteById(id);
    }
}
