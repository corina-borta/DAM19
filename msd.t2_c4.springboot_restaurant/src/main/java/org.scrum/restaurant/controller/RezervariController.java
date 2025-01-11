package org.scrum.restaurant.controller;

import org.scrum.restaurant.management.Rezervari;
import org.scrum.restaurant.service.RezervariService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rezervari")
public class RezervariController {

    private final RezervariService rezervariService;

    public RezervariController(RezervariService rezervariService) {
        this.rezervariService = rezervariService;
    }

    @GetMapping
    public ResponseEntity<List<Rezervari>> getAllRezervari() {
        List<Rezervari> rezervari = rezervariService.getAllRezervari();
        return ResponseEntity.ok(rezervari);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rezervari> getRezervareById(@PathVariable Integer id) {
        Optional<Rezervari> rezervare = rezervariService.getRezervareById(id);
        return rezervare.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Rezervari> createRezervare(@RequestBody Rezervari rezervare) {
        Rezervari newRezervare = rezervariService.addRezervare(rezervare);
        return ResponseEntity.ok(newRezervare);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rezervari> updateRezervare(@PathVariable Integer id, @RequestBody Rezervari rezervare) {
        rezervare.setIdRezervare(id);
        Rezervari updatedRezervare = rezervariService.updateRezervare(rezervare);
        return ResponseEntity.ok(updatedRezervare);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRezervare(@PathVariable Integer id) {
        rezervariService.deleteRezervare(id);
        return ResponseEntity.noContent().build();
    }
}

