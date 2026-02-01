package org.example.bdd.models;

import jakarta.persistence.*;

@Entity(name = "trajet")
public class TrajetDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "gare_depart_id")
    private GareDAO gareDepart;

    @ManyToOne
    @JoinColumn(name = "gare_arrivee_id")
    private GareDAO gareArrivee;

    public TrajetDAO() {
    }

    public TrajetDAO(GareDAO gareDepart, GareDAO gareArrivee) {
        this.gareDepart = gareDepart;
        this.gareArrivee = gareArrivee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GareDAO getGareDepart() {
        return gareDepart;
    }

    public void setGareDepart(GareDAO gareDepart) {
        this.gareDepart = gareDepart;
    }

    public GareDAO getGareArrivee() {
        return gareArrivee;
    }

    public void setGareArrivee(GareDAO gareArrivee) {
        this.gareArrivee = gareArrivee;
    }

}
