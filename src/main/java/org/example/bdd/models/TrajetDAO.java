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
    @JoinColumn(name = "gare_via_id")
    private GareDAO gareVia; // optionnel

    @ManyToOne
    @JoinColumn(name = "gare_arrivee_id")
    private GareDAO gareArrivee;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private TrainDAO train;

    public TrajetDAO() {}

    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public GareDAO getGareDepart() { return gareDepart; }
    public void setGareDepart(GareDAO gareDepart) { this.gareDepart = gareDepart; }

    public GareDAO getGareVia() { return gareVia; }
    public void setGareVia(GareDAO gareVia) { this.gareVia = gareVia; }

    public GareDAO getGareArrivee() { return gareArrivee; }
    public void setGareArrivee(GareDAO gareArrivee) { this.gareArrivee = gareArrivee; }

    public TrainDAO getTrain() { return train; }
    public void setTrain(TrainDAO train) { this.train = train; }
}
