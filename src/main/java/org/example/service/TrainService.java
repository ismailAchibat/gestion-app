package org.example.service;

import org.example.bdd.models.TrainDAO;
import org.example.bdd.models.WagonDAO;
import org.example.bdd.repositories.TrainRepository;
import org.openapitools.model.Train;
import org.openapitools.model.Wagon;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainService {

    private final TrainRepository repository;

    public TrainService(TrainRepository repository) {
        this.repository = repository;
    }

    // (Travail 21) création simple (pas DB)
    public Train creer(String matricule) {
        Train train = new Train();
        train.setMatricule(matricule);
        train.setWagons(new ArrayList<>());
        return train;
    }

    // (Scénario 2) création TER + 3 wagons en DB
    public TrainDAO creerTerAvecWagons(String matricule, int p1, int p2, int p3) {
        TrainDAO train = new TrainDAO();
        train.setMatricule(matricule);
        train.setType("TER");

        // important : initialise la liste si ton TrainDAO ne le fait pas
        if (train.getWagons() == null) {
            train.setWagons(new ArrayList<>());
        }

        WagonDAO w1 = new WagonDAO(); w1.setNombrePlaces(p1); w1.setTrain(train);
        WagonDAO w2 = new WagonDAO(); w2.setNombrePlaces(p2); w2.setTrain(train);
        WagonDAO w3 = new WagonDAO(); w3.setNombrePlaces(p3); w3.setTrain(train);

        train.getWagons().add(w1);
        train.getWagons().add(w2);
        train.getWagons().add(w3);

        return repository.save(train); // nécessite cascade sur TrainDAO -> wagons
    }

    // (Travail 24) recherche DB + conversion vers modèle OpenAPI
    public Train rechercher(String matricule) {
        TrainDAO trainDAO = repository.findByMatricule(matricule);
        if (trainDAO == null) return null;

        Train train = new Train();
        train.setMatricule(trainDAO.getMatricule());

        List<Wagon> wagons = new ArrayList<>();
        if (trainDAO.getWagons() != null) {
            for (WagonDAO w : trainDAO.getWagons()) {
                Wagon wagon = new Wagon();
                wagon.setNombrePlaces(w.getNombrePlaces());
                wagons.add(wagon);
            }
        }

        train.setWagons(wagons);
        return train;
    }

    public Iterable<TrainDAO> lister() {
        return repository.findAll();
    }
}
