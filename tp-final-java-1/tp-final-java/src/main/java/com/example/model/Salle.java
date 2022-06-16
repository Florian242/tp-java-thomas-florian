package com.example.model;

import javax.persistence.*;

@Entity
@Table(name="table_Salles")
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public int capacity;
    public String nom;
    public String code;

    public Salle(long id, int capacity, String nom, String code) {
        this.id = id;
        this.capacity = capacity;
        this.nom = nom;
        this.code = code;
    }

    public Salle() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
