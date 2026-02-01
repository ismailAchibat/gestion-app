package org.example.service;

import org.example.bdd.models.GareDAO;
import org.example.bdd.models.HoraireDAO;
import org.example.bdd.models.TrajetDAO;
import org.example.bdd.repositories.GareRepository;
import org.example.bdd.repositories.HoraireRepository;
import org.example.bdd.repositories.TrajetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TrajetService {

    private final TrajetRepository trajetRepository;
    private final HoraireRepository horaireRepository;
    private final GareRepository gareRepository;

    @Autowired
    public TrajetService(TrajetRepository trajetRepository, HoraireRepository horaireRepository, GareRepository gareRepository) {
        this.trajetRepository = trajetRepository;
        this.horaireRepository = horaireRepository;
        this.gareRepository = gareRepository;
    }

    public List<HoraireDAO> findSchedules(String nomGareDepart, String nomGareArrivee) {
        // Find departure and arrival stations
        GareDAO gareDepart = gareRepository.findFirstByNom(nomGareDepart);
        GareDAO gareArrivee = gareRepository.findFirstByNom(nomGareArrivee);

        if (gareDepart == null || gareArrivee == null) {
            return Collections.emptyList(); // One or both stations not found
        }

        // Find trajets between the two stations
        List<TrajetDAO> trajets = trajetRepository.findByGareDepart_NomAndGareArrivee_Nom(nomGareDepart, nomGareArrivee);

        if (trajets.isEmpty()) {
            return Collections.emptyList(); // No direct trajet found
        }

        // Assuming for simplicity that we only care about the first found trajet for schedules
        // In a real application, you might want to aggregate schedules from all matching trajets
        TrajetDAO primaryTrajet = trajets.get(0);

        // Find all schedules for this trajet
        return horaireRepository.findByTrajet_GareDepart_NomAndTrajet_GareArrivee_Nom(nomGareDepart, nomGareArrivee);
    }
}
