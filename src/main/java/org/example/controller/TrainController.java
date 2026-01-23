package org.example.controller;

import org.example.service.TrainService;
import org.openapitools.api.TrainApi; // Import the generated API interface
import org.openapitools.model.Train; // Import the generated Train model
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainController {

    @Autowired
    private TrainService service;

    @GetMapping(TrainApi.PATH_TRAIN_CONSULTER_GET) // Use the actual constant from generated code
    public Train consulterTrain(
            @RequestParam(value = "matricule", required = true) String matricule) {
        return service.rechercher(matricule); // As per PDF instructions, call service.creer
    }
}
