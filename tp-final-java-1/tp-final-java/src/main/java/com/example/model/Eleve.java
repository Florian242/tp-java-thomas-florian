package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "table_eleves")
public class Eleve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public String nom;
    public String prenom;
    public int age;
    public String adresse;


    public Eleve(int id, String nom, String prenom, int age, String adresse) {
        this.id=id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.adresse = adresse;
    }

    public Eleve() {

    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
