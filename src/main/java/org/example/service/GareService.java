package org.example.service;

import org.example.bdd.models.GareDAO;
import org.example.bdd.models.TrainDAO;
import org.example.bdd.repositories.GareRepository;
import org.example.bdd.repositories.TrainRepository;
import org.openapitools.model.Gare;
import org.openapitools.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GareService {

    private final GareRepository repository;
    @Autowired
    public GareService(GareRepository repository) {
        this.repository = repository;
    }
    public Gare creer(String nom, int nombreQuais) {
        GareDAO gareDAO = new GareDAO(nom, nombreQuais);
        repository.save(gareDAO);
        Gare gare = new Gare();
        gare.setIdGare(gareDAO.getId());
        gare.setNomGare(gareDAO.getNom());
        gare.setNbQuai(gareDAO.getNombreQuais());
        return gare;
    }
    public Gare rechercher(String nom) {
        GareDAO gareDAO = repository.findFirstByNom(nom);
        if (gareDAO == null) {return null;}
        Gare gare = new Gare();
        gare.setIdGare(gareDAO.getId());
        gare.setNomGare(gareDAO.getNom());
        gare.setNbQuai(gareDAO.getNombreQuais());
        return gare;
    }

    public List<GareDAO> listerGares() {
        List<GareDAO> gares = new ArrayList<>();
        repository.findAll().forEach(gares::add);
        return gares;
    }


}
