package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "table_niveau")
public class Niveau {
    @Id
    @GeneratedValue
    private long id;

    @Column
    String code;
    @Column
    String libelle;

    public Niveau() {
    }

    public Niveau(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
