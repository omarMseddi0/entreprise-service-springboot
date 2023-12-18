package com.example.demo.demo.entities;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String poste;
    private double salaire;

    @ManyToOne
    @JoinColumn(name = "departement_id")
    
    private Departement departement;

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    
    private List<Projet> projets = new ArrayList<>();

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPoste() { return poste; }
    public void setPoste(String poste) { this.poste = poste; }
    public double getSalaire() { return salaire; }
    public void setSalaire(double salaire) { this.salaire = salaire; }
    public Departement getDepartement() { return departement; }
    public void setDepartement(Departement departement) { this.departement = departement; }
    public List<Projet> getProjets() { return projets; }
    public void setProjets(List<Projet> projets) { this.projets = projets; }
}
