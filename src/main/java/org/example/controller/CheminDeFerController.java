package org.example.controller;

import org.example.bdd.models.CheminDeFerDAO;
import org.example.service.CheminDeFerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chemins")
public class CheminDeFerController {

    private final CheminDeFerService service;

    public CheminDeFerController(CheminDeFerService service) {
        this.service = service;
    }

    @PostMapping
    public CheminDeFerDAO creer(
            @RequestParam Integer departId,
            @RequestParam Integer arriveeId,
            @RequestParam float distance,
            @RequestParam int nbVoies
    ) {
        return service.creer(departId, arriveeId, distance, nbVoies);
    }

    @GetMapping
    public List<CheminDeFerDAO> listerParDepart(@RequestParam Long departId) {
        return service.listerParDepart(departId);
    }
}
