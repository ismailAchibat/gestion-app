package org.example.service;

import org.example.bdd.models.TrainDAO;
import org.example.bdd.repositories.TrainRepository;
import org.openapitools.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class TrainService {

    /**
     * Crée un nouvel objet Train avec le matricule donné.
     * @param matricule Le matricule du train.
     * @return Un nouvel objet Train.
     */
    public Train creer(String matricule) {
        Train train = new Train();
        train.setMatricule(matricule);
        train.setWagons(new ArrayList<>()); // Initialise avec une liste de wagons vide
        return train;
    }
    private final TrainRepository repository;
    @Autowired
    public TrainService(TrainRepository repository) {
        this.repository = repository;
    }
    public Train rechercher(String matricule) {
        TrainDAO trainDAO = repository.findByMatricule(matricule);
        if (trainDAO == null) {return null;}
        Train train = new Train();
        train.setMatricule(trainDAO.getMatricule());
        train.setWagons(new ArrayList<>());
        return train;
    }

}
