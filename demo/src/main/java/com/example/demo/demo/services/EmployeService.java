package com.example.demo.demo.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.demo.repository.EmployeRepository;
import com.example.demo.demo.repository.EntrepriseRepository;
import com.example.demo.demo.entities.Employe;
import com.example.demo.demo.entities.Entreprise;

import java.util.List;
@Service
public class EmployeService {
    @Autowired
    private EmployeRepository employeRepository;

    public List<Employe> findEmployesByProjetNom(String projetNom) {
        return employeRepository.findEmployesByProjetNom(projetNom);
    }

    public Employe createEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    public void deleteByPoste(String poste) {
        employeRepository.deleteByPoste(poste);
    }
}
