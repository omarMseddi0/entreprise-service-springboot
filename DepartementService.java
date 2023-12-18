package com.example.demo.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.demo.repository.DepartementRepository;
import com.example.demo.demo.entities.Departement;


@Service
public class DepartementService {
    @Autowired
    private DepartementRepository departementRepository;

    public List<Departement> findByEntrepriseNom(String nomEntreprise) {
        return departementRepository.findByEntrepriseNom(nomEntreprise);
    }

    public Departement createDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    public Departement updateDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    public void deleteDepartement(Long id) {
        departementRepository.deleteById(id);
    }
}
