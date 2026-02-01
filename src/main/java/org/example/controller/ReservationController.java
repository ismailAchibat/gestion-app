package org.example.controller;

import org.example.bdd.models.ReservationDAO;
import org.example.service.ReservationService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // POST /reservations?horaireId=..&departId=..&arriveeId=..&nom=..&prenom=..&naissance=2000-01-01
    @PostMapping
    public ReservationDAO reserver(@RequestParam Integer horaireId,
                                   @RequestParam Integer departId,
                                   @RequestParam Integer arriveeId,
                                   @RequestParam String nom,
                                   @RequestParam String prenom,
                                   @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate naissance) {
        return reservationService.reserver(horaireId, departId, arriveeId, nom, prenom, naissance);
    }
}
