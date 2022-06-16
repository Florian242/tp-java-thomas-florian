package com.example.model;

import javax.persistence.*;

@Entity
@Table(name="table_cours")
public class Cour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public String nom;
    public String heureDebut;
    public String heureFin;


    public Cour(long id, String nom, String heureDebut, String heureFin, String niveauScolaire) {
        this.id = id;
        this.nom = nom;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    public Cour() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

}
