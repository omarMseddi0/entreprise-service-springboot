package com.example.demo.demo.entities;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;




import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String adresse;
    private String secteur;

    @OneToMany(mappedBy = "entreprise", cascade = CascadeType.ALL)
    private List<Departement> departements;
   
    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public String getSecteur() { return secteur; }
    public void setSecteur(String secteur) { this.secteur = secteur; }
    public List<Departement> getDepartements() { return departements; }
    public void setDepartements(List<Departement> departements) { this.departements = departements; }
}