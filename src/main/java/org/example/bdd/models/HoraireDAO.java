package org.example.bdd.models;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity(name = "horaire")
public class HoraireDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "trajet_id")
    private TrajetDAO trajet;

    private LocalTime heureDepart;
    private LocalTime heureArrivee;

    // Assuming TrainDAO exists
    @ManyToOne
    @JoinColumn(name = "train_id")
    private TrainDAO train;

    public HoraireDAO() {
    }

    public HoraireDAO(TrajetDAO trajet, LocalTime heureDepart, LocalTime heureArrivee, TrainDAO train) {
        this.trajet = trajet;
        this.heureDepart = heureDepart;
        this.heureArrivee = heureArrivee;
        this.train = train;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TrajetDAO getTrajet() {
        return trajet;
    }

    public void setTrajet(TrajetDAO trajet) {
        this.trajet = trajet;
    }

    public LocalTime getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(LocalTime heureDepart) {
        this.heureDepart = heureDepart;
    }

    public LocalTime getHeureArrivee() {
        return heureArrivee;
    }

    public void setHeureArrivee(LocalTime heureArrivee) {
        this.heureArrivee = heureArrivee;
    }

    public TrainDAO getTrain() {
        return train;
    }

    public void setTrain(TrainDAO train) {
        this.train = train;
    }
}
