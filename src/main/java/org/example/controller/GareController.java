package org.example.controller;

import org.example.service.GareService;
import org.example.service.TrainService;
import org.openapitools.api.TrainApi; // Import the generated API interface
import org.openapitools.model.Gare;
import org.openapitools.model.Train; // Import the generated Train model
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GareController {
    @Autowired
    private GareService service;

    @PostMapping("/gare/creer")
    public Gare creerGare(@RequestParam String nom, @RequestParam int nombreQuais)
    {
        return service.creer(nom,nombreQuais);
    }
    @GetMapping("/gare/consulter")
    public Gare consulterGare(
            @RequestParam(value = "nom", required = true) String nom) {
        return service.rechercher(nom);
    }

    @GetMapping("/gare/all")
    public List<Gare> getAllGares() {
        return service.listerGares().stream().map(gareDAO -> {
            Gare gare = new Gare();
            gare.setIdGare(gareDAO.getId());
            gare.setNomGare(gareDAO.getNom());
            gare.setNbQuai(gareDAO.getNombreQuais());
            return gare;
        }).collect(Collectors.toList());
    }
}