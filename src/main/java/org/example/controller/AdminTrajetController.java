package org.example.controller;

import org.example.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/trajets")
public class AdminTrajetController {

    private final TrajetService trajetService;
    private final GareService gareService;
    private final TrainService trainService;

    public AdminTrajetController(TrajetService trajetService, GareService gareService, TrainService trainService) {
        this.trajetService = trajetService;
        this.gareService = gareService;
        this.trainService = trainService;
    }

    @GetMapping
    public String page(Model model,
                       @RequestParam(value = "msg", required = false) String msg,
                       @RequestParam(value = "err", required = false) String err) {
        model.addAttribute("gares", gareService.listerGares());
        model.addAttribute("trains", trainService.lister());
        model.addAttribute("trajets", trajetService.lister());
        model.addAttribute("msg", msg);
        model.addAttribute("err", err);
        return "admin_trajets";
    }

    @PostMapping("/creer-via")
    public String creerVia(@RequestParam Integer trainId,
                           @RequestParam Integer departId,
                           @RequestParam Integer viaId,
                           @RequestParam Integer arriveeId) {
        try {
            trajetService.creerTrajetVia(trainId, departId, viaId, arriveeId);
            return "redirect:/admin/trajets?msg=Trajet+cr%C3%A9%C3%A9";
        } catch (Exception e) {
            return "redirect:/admin/trajets?err=" + e.getMessage().replace(" ", "+");
        }
    }
}
