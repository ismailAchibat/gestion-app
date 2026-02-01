package org.example.bdd.models;

import jakarta.persistence.*;

@Entity(name = "wagon")
public class WagonDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="nombre_places")
    private Integer nombrePlaces;

    @ManyToOne
    @JoinColumn(name="train_id")
    private TrainDAO train;

    public Integer getId() { return id; }
    public Integer getNombrePlaces() { return nombrePlaces; }
    public void setNombrePlaces(Integer nombrePlaces) { this.nombrePlaces = nombrePlaces; }

    public TrainDAO getTrain() { return train; }
    public void setTrain(TrainDAO train) { this.train = train; }
}
