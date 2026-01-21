package org.example.service;

import org.openapitools.model.Train;
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
}
