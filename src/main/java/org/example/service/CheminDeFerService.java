package org.example.service;

import org.example.bdd.models.CheminDeFerDAO;
import org.example.bdd.models.GareDAO;
import org.example.bdd.repositories.CheminDeFerRepository;
import org.example.bdd.repositories.GareRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheminDeFerService {

    private final CheminDeFerRepository cheminRepo;
    private final GareRepository gareRepo;

    public CheminDeFerService(CheminDeFerRepository cheminRepo, GareRepository gareRepo) {
        this.cheminRepo = cheminRepo;
        this.gareRepo = gareRepo;
    }

    public CheminDeFerDAO creer(Integer gareDepartId, Integer gareArriveeId, float distance, int nbVoies) {
        GareDAO depart = gareRepo.findById(gareDepartId)
                .orElseThrow(() -> new IllegalArgumentException("Gare départ introuvable"));
        GareDAO arrivee = gareRepo.findById(gareArriveeId)
                .orElseThrow(() -> new IllegalArgumentException("Gare arrivée introuvable"));

        CheminDeFerDAO c = new CheminDeFerDAO();
        c.setGareDepart(depart);
        c.setGareArrivee(arrivee);
        c.setDistance(distance);
        c.setNbVoies(nbVoies);

        return cheminRepo.save(c);
    }

    public List<CheminDeFerDAO> listerParDepart(Integer gareId) {
        return cheminRepo.findByGareDepart_Id(gareId);
    }
}
