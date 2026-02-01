package org.example.controller;

import org.example.service.TrainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/transport")
public class AdminTransportController {

    private final TrainService trainService;

    public AdminTransportController(TrainService trainService) {
        this.trainService = trainService;
    }

    @GetMapping
    public String page(Model model) {
        model.addAttribute("trains", trainService.lister());
        return "admin_transport";
    }

    @PostMapping("/train/ter")
    public String creerTer(
            @RequestParam String matricule,
            @RequestParam int p1,
            @RequestParam int p2,
            @RequestParam int p3
    ) {
        trainService.creerTerAvecWagons(matricule, p1, p2, p3);
        return "redirect:/admin/transport";
    }
}
