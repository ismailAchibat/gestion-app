package org.example.bdd.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "train")
public class TrainDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String matricule;
    private String type; // "TER" ou "TGV"

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WagonDAO> wagons = new ArrayList<>();

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public List<WagonDAO> getWagons() { return wagons; }
    public void setWagons(List<WagonDAO> wagons) { this.wagons = wagons; }
}
