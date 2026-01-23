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
}
