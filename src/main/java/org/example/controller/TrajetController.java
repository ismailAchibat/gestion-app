package org.example.controller;

import org.example.bdd.models.HoraireDAO;
import org.example.service.TrajetService;
import org.openapitools.model.Gare;
import org.openapitools.model.Horaire;
import org.openapitools.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TrajetController {

    private final TrajetService trajetService;

    @Autowired
    public TrajetController(TrajetService trajetService) {
        this.trajetService = trajetService;
    }

    @GetMapping("/trajet/schedules")
    public List<Horaire> getSchedules(
            @RequestParam String nomDepart,
            @RequestParam String nomArrivee) {

        List<HoraireDAO> horaireDAOs = trajetService.findSchedules(nomDepart, nomArrivee);
        List<Horaire> horaires = new ArrayList<>();

        for (HoraireDAO dao : horaireDAOs) {
            Horaire horaire = new Horaire();
            horaire.setId(dao.getId());
            horaire.setHeureDepart(dao.getHeureDepart());
            horaire.setHeureArrivee(dao.getHeureArrivee());

            // Map GareDAO to Gare DTO
            if (dao.getTrajet() != null && dao.getTrajet().getGareDepart() != null) {
                Gare gareDepart = new Gare();
                gareDepart.setIdGare(dao.getTrajet().getGareDepart().getId());
                gareDepart.setNomGare(dao.getTrajet().getGareDepart().getNom());
                gareDepart.setNbQuai(dao.getTrajet().getGareDepart().getNombreQuais());
                horaire.setGareDepart(gareDepart);
            }

            if (dao.getTrajet() != null && dao.getTrajet().getGareArrivee() != null) {
                Gare gareArrivee = new Gare();
                gareArrivee.setIdGare(dao.getTrajet().getGareArrivee().getId());
                gareArrivee.setNomGare(dao.getTrajet().getGareArrivee().getNom());
                gareArrivee.setNbQuai(dao.getTrajet().getGareArrivee().getNombreQuais());
                horaire.setGareArrivee(gareArrivee);
            }

            // Map TrainDAO to Train DTO
            if (dao.getTrain() != null) {
                Train train = new Train();
                train.setMatricule(dao.getTrain().getMatricule());
                train.setMatricule(dao.getTrain().getMatricule());
                horaire.setTrain(train);
            }
            horaires.add(horaire);
        }
        return horaires;
    }
}
