package org.example.bdd.models;

import jakarta.persistence.*;

@Entity
@Table(name = "chemin_de_fer")
public class CheminDeFerDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "gare_depart_id")
    private GareDAO gareDepart;

    @ManyToOne(optional = false)
    @JoinColumn(name = "gare_arrivee_id")
    private GareDAO gareArrivee;

    private float distance;

    @Column(name = "nb_voies")
    private int nbVoies;

    public CheminDeFerDAO() {}

    // getters/setters
    public Integer getId() { return id; }

    public GareDAO getGareDepart() { return gareDepart; }
    public void setGareDepart(GareDAO gareDepart) { this.gareDepart = gareDepart; }

    public GareDAO getGareArrivee() { return gareArrivee; }
    public void setGareArrivee(GareDAO gareArrivee) { this.gareArrivee = gareArrivee; }

    public float getDistance() { return distance; }
    public void setDistance(float distance) { this.distance = distance; }

    public int getNbVoies() { return nbVoies; }
    public void setNbVoies(int nbVoies) { this.nbVoies = nbVoies; }
}
