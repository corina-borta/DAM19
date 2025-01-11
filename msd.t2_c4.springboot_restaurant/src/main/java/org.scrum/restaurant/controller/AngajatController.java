package org.scrum.restaurant.controller;

import org.scrum.restaurant.persoane.Angajat;
import org.scrum.restaurant.service.AngajatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/angajati")
public class AngajatController {
    private final AngajatService angajatService;

    public AngajatController(AngajatService angajatService) {
        this.angajatService = angajatService;
    }

    @GetMapping
    public ResponseEntity<List<Angajat>> getAllAngajati() {
        return ResponseEntity.ok(angajatService.getAllAngajati());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Angajat> getAngajatById(@PathVariable Integer id) {
        return angajatService.getAngajatById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Angajat> createAngajat(@RequestBody Angajat angajat) {
        Angajat newAngajat = angajatService.addAngajat(angajat);
        return ResponseEntity.ok(newAngajat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Angajat> updateAngajat(@PathVariable Integer id, @RequestBody Angajat angajat) {
        angajat.setIdAngajat(id); // Asigură-te că această metodă este corect implementată
        Angajat updatedAngajat = angajatService.updateAngajat(angajat);
        return ResponseEntity.ok(updatedAngajat);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAngajat(@PathVariable Integer id) {
        angajatService.deleteAngajat(id);
        return ResponseEntity.noContent().build();
    }
}
