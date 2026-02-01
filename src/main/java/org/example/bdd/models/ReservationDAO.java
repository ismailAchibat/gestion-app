package org.example.bdd.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity(name="reservation")
public class ReservationDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="usager_id")
    private UsagerDAO usager;

    @ManyToOne
    @JoinColumn(name="horaire_id")
    private HoraireDAO horaire;

    // pour savoir ce que l’usager réserve réellement (C->B ou C->A)
    @ManyToOne
    @JoinColumn(name="gare_depart_id")
    private GareDAO gareDepart;

    @ManyToOne
    @JoinColumn(name="gare_arrivee_id")
    private GareDAO gareArrivee;

    private LocalDateTime dateReservation = LocalDateTime.now();

    public ReservationDAO() {}

    public Integer getId() { return id; }
    public UsagerDAO getUsager() { return usager; }
    public HoraireDAO getHoraire() { return horaire; }
    public GareDAO getGareDepart() { return gareDepart; }
    public GareDAO getGareArrivee() { return gareArrivee; }
    public LocalDateTime getDateReservation() { return dateReservation; }

    public void setId(Integer id) { this.id = id; }
    public void setUsager(UsagerDAO usager) { this.usager = usager; }
    public void setHoraire(HoraireDAO horaire) { this.horaire = horaire; }
    public void setGareDepart(GareDAO gareDepart) { this.gareDepart = gareDepart; }
    public void setGareArrivee(GareDAO gareArrivee) { this.gareArrivee = gareArrivee; }
    public void setDateReservation(LocalDateTime dateReservation) { this.dateReservation = dateReservation; }
}
