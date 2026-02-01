package org.example.service;

import org.example.bdd.models.*;
import org.example.bdd.repositories.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {

    private final UsagerRepository usagerRepo;
    private final ReservationRepository reservationRepo;
    private final HoraireRepository horaireRepo;
    private final GareRepository gareRepo;

    public ReservationService(UsagerRepository usagerRepo,
                              ReservationRepository reservationRepo,
                              HoraireRepository horaireRepo,
                              GareRepository gareRepo) {
        this.usagerRepo = usagerRepo;
        this.reservationRepo = reservationRepo;
        this.horaireRepo = horaireRepo;
        this.gareRepo = gareRepo;
    }

    public ReservationDAO reserver(Integer horaireId, Integer departId, Integer arriveeId,
                                   String nom, String prenom, LocalDate naissance) {

        HoraireDAO horaire = horaireRepo.findById(horaireId).orElseThrow();
        GareDAO depart = gareRepo.findById(departId).orElseThrow();
        GareDAO arrivee = gareRepo.findById(arriveeId).orElseThrow();

        UsagerDAO usager = usagerRepo.save(new UsagerDAO(nom, prenom, naissance));

        ReservationDAO r = new ReservationDAO();
        r.setUsager(usager);
        r.setHoraire(horaire);
        r.setGareDepart(depart);
        r.setGareArrivee(arrivee);

        return reservationRepo.save(r);
    }

    public List<ReservationDAO> reservationsPourHoraire(Integer horaireId) {
        return reservationRepo.findByHoraire_Id(horaireId);
    }
}
