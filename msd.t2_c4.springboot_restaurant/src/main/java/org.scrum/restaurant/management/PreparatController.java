package org.scrum.restaurant.controller;

import org.scrum.restaurant.meniu.Preparat;
import org.scrum.restaurant.meniu.TipPreparat;
import org.scrum.restaurant.service.PreparateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/preparate")
public class PreparatController {

    private final PreparateService preparateService;

    @Autowired
    public PreparatController(PreparateService preparateService) {
        this.preparateService = preparateService;
    }

    // Endpoint pentru a salva un preparat
    @PostMapping
    public ResponseEntity<Preparat> savePreparat(@RequestBody Preparat preparat) {
        try {
            Preparat savedPreparat = preparateService.savePreparat(preparat);
            return new ResponseEntity<>(savedPreparat, HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Endpoint pentru a obține toate preparatele
    @GetMapping
    public ResponseEntity<List<Preparat>> getAllPreparate() {
        List<Preparat> preparate = preparateService.getAllPreparate();
        return new ResponseEntity<>(preparate, HttpStatus.OK);
    }

    // Endpoint pentru a obține un preparat după nume
    @GetMapping("/nume/{nume}")
    public ResponseEntity<List<Preparat>> getByNume(@PathVariable("nume") String nume) {
        List<Preparat> preparate = preparateService.getByNume(nume);
        if (preparate.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(preparate, HttpStatus.OK);
    }

    // Endpoint pentru a obține preparate pe baza unui preț minim
    @GetMapping("/pret/{pret}")
    public ResponseEntity<List<Preparat>> getPreparateByPretGreaterThanEqual(@PathVariable("pret") double pret) {
        List<Preparat> preparate = preparateService.getPreparateByPretGreaterThanEqual(pret);
        return new ResponseEntity<>(preparate, HttpStatus.OK);
    }

    // Endpoint pentru a obține preparate pe baza tipului
    @GetMapping("/tip/{tipPreparat}")
    public ResponseEntity<List<Preparat>> getPreparateByTip(@PathVariable("tipPreparat") TipPreparat tipPreparat) {
        List<Preparat> preparate = preparateService.getPreparateByTip(tipPreparat);
        return new ResponseEntity<>(preparate, HttpStatus.OK);
    }

    // Endpoint pentru a obține preparate pe baza unui meniu
    @GetMapping("/meniu/{idMeniu}")
    public ResponseEntity<List<Preparat>> getByMeniu(@PathVariable("idMeniu") Integer idMeniu) {
        List<Preparat> preparate = preparateService.getByMeniu(idMeniu);
        return new ResponseEntity<>(preparate, HttpStatus.OK);
    }

    // Endpoint pentru a șterge un preparat după ID
    @DeleteMapping("/{idPreparat}")
    public ResponseEntity<Void> deletePreparat(@PathVariable("idPreparat") Integer idPreparat) {
        try {
            preparateService.deletePreparatByidPreparat(idPreparat);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pentru a actualiza un preparat
    @PutMapping("/{idPreparat}")
    public ResponseEntity<Preparat> updatePreparat(@PathVariable("idPreparat") Integer idPreparat, @RequestBody Preparat preparat) {
        try {
            Preparat updatedPreparat = preparateService.updatePreparat(idPreparat, preparat);
            return new ResponseEntity<>(updatedPreparat, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
