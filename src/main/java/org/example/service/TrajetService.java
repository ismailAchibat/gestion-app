package org.example.service;

import org.example.bdd.models.GareDAO;
import org.example.bdd.models.HoraireDAO;
import org.example.bdd.models.TrajetDAO;
import org.example.bdd.models.TrainDAO;
import org.example.bdd.repositories.CheminDeFerRepository;
import org.example.bdd.repositories.GareRepository;
import org.example.bdd.repositories.HoraireRepository;
import org.example.bdd.repositories.TrajetRepository;
import org.example.bdd.repositories.TrainRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TrajetService {

    private final CheminDeFerRepository cheminRepository;
    private final TrajetRepository trajetRepository;
    private final HoraireRepository horaireRepository;
    private final GareRepository gareRepository;
    private final TrainRepository trainRepository;

    public TrajetService(TrajetRepository trajetRepository,
                         HoraireRepository horaireRepository,
                         GareRepository gareRepository,
                         CheminDeFerRepository cheminRepository,
                         TrainRepository trainRepository) {
        this.trajetRepository = trajetRepository;
        this.horaireRepository = horaireRepository;
        this.gareRepository = gareRepository;
        this.cheminRepository = cheminRepository;
        this.trainRepository = trainRepository;
    }

    // SCENARIO 3 : créer un trajet A -> C via B avec un train
    public TrajetDAO creerTrajetVia(Integer trainId, Integer departId, Integer viaId, Integer arriveeId) {

        GareDAO depart = gareRepository.findById(departId).orElseThrow();
        GareDAO via = gareRepository.findById(viaId).orElseThrow();
        GareDAO arrivee = gareRepository.findById(arriveeId).orElseThrow();
        TrainDAO train = trainRepository.findById(trainId).orElseThrow();

        if (cheminRepository.findFirstByGareDepart_IdAndGareArrivee_Id(departId, viaId) == null) {
            throw new IllegalArgumentException("Aucun chemin entre départ et via (A->B).");
        }
        if (cheminRepository.findFirstByGareDepart_IdAndGareArrivee_Id(viaId, arriveeId) == null) {
            throw new IllegalArgumentException("Aucun chemin entre via et arrivée (B->C).");
        }

        TrajetDAO trajet = new TrajetDAO();
        trajet.setTrain(train);
        trajet.setGareDepart(depart);
        trajet.setGareVia(via);
        trajet.setGareArrivee(arrivee);

        return trajetRepository.save(trajet);
    }

    // SCENARIO 4/USAGER : chercher horaires par noms de gares (direct)
    public List<HoraireDAO> findSchedules(String nomGareDepart, String nomGareArrivee) {

        GareDAO depart = gareRepository.findFirstByNom(nomGareDepart);
        GareDAO arrivee = gareRepository.findFirstByNom(nomGareArrivee);

        if (depart == null || arrivee == null) return Collections.emptyList();

        // On retourne les horaires liés aux trajets dont les gares matchent
        return horaireRepository.findByTrajet_GareDepart_NomAndTrajet_GareArrivee_Nom(nomGareDepart, nomGareArrivee);
    }

    public Iterable<TrajetDAO> lister() {
        return trajetRepository.findAll();
    }
}
