package org.example.bdd.models;

import jakarta.persistence.*;

@Entity(name = "gare")
public class GareDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nom;
    private int nombreQuais;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNombreQuais() {
        return nombreQuais;
    }

    public void setNombreQuais(int nombreQuais) {
        this.nombreQuais = nombreQuais;
    }

    public GareDAO(String nom, int nombreQuais) {
        this.nom = nom;
        this.nombreQuais = nombreQuais;
    }

    public GareDAO() {
    }
}
