package org.example.controller;

import org.example.bdd.repositories.GareRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminCartographieController {

    private final GareRepository gareRepository;

    public AdminCartographieController(GareRepository gareRepository) {
        this.gareRepository = gareRepository;
    }

    @GetMapping("/admin/cartographie")
    public String page(Model model) {
        model.addAttribute("gares", gareRepository.findAll());
        return "admin_cartographie";
    }
}
