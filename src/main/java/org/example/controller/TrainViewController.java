package org.example.controller;

import org.example.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TrainViewController {

    @Autowired
    private TrainService service;

    @GetMapping("/ihm/train")
    public String ihmConsulterTrain(
            @RequestParam(value = "matricule", required = true) String matricule,
            Model model
    ) {
        model.addAttribute("train", service.rechercher(matricule));
        return "ihm_train";
    }
}
