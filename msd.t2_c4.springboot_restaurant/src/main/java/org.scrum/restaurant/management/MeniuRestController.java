package org.scrum.restaurant.controller;

import org.scrum.restaurant.meniu.Meniu;
import org.scrum.restaurant.meniu.Preparat;
import org.scrum.restaurant.persoane.Angajat;
import org.scrum.restaurant.service.MeniuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meniuri")  // Endpoint-ul de bază pentru API-ul de meniuri
public class MeniuRestController {

    private final MeniuService meniuService;

    @Autowired
    public MeniuRestController(MeniuService meniuService) {
        this.meniuService = meniuService;
    }
    // Obține toate meniurile
    @GetMapping
    public List<Meniu> getAllMeniuri() {
        return meniuService.getAllMeniuri();
    }

    // Obține un meniu după ID
    @GetMapping("/{id}")
    public ResponseEntity<Meniu> getMeniuById(@PathVariable Integer idMeniu) {
        Meniu meniu = meniuService.getMeniuById(idMeniu);
        if (meniu != null) {
            return ResponseEntity.ok(meniu);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Căutare meniuri după nume
    @GetMapping("/search")
    public List<Meniu> getMeniuriByNumeMeniu(@RequestParam String numeMeniu) {
        return meniuService.getMeniuriByNumeMeniu(numeMeniu);
    }

    // Salvează un meniu nou sau actualizează unul existent
    @PostMapping
    public ResponseEntity<Meniu> createMeniu(@RequestBody Meniu meniu) {
        Meniu savedMeniu = meniuService.saveMeniu(meniu);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMeniu);
    }

    @PostMapping("/{idMeniu}/adaugaPreparat")
    public Meniu adaugaPreparat(@PathVariable Integer idMeniu, @RequestBody Preparat preparat, @RequestParam Angajat angajat) {
        return meniuService.adaugaPreparatInMeniu(idMeniu, preparat, angajat);
    }

    // Endpoint pentru actualizarea unui meniu
    @PutMapping("/{idMeniu}")
    public ResponseEntity<Meniu> updateMeniu(
            @PathVariable Integer idMeniu,
            @RequestBody Meniu meniuActualizat,
            @RequestParam Integer idAngajat) {
        // Creează o instanță a angajatului
        Angajat angajat = new Angajat();
        angajat.setIdAngajat(idAngajat);

        Meniu meniu = meniuService.updateMeniu(
                idMeniu,
                meniuActualizat.getNumeMeniu(),
                meniuActualizat.getPreparate(),
                angajat
        );

        if (meniu != null) {
            return ResponseEntity.ok(meniu);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    // Actualizează un meniu existent
    @PutMapping("/{idMeniu}")
    public ResponseEntity<Meniu> updateMeniu(@PathVariable Integer idMeniu, @RequestBody Meniu meniu, @RequestParam Angajat angajat) {
        Meniu updatedMeniu = meniuService.updateMeniu(idMeniu, meniu.getNumeMeniu(), meniu.getPreparate(), angajat);
        if (updatedMeniu != null) {
            return ResponseEntity.ok(updatedMeniu);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    // Endpoint pentru ștergerea unui preparat din meniu
    @DeleteMapping("/{idMeniu}/preparate/{idPreparat}")
    public ResponseEntity<String> stergePreparatDinMeniu(
            @PathVariable Integer idMeniu,
            @PathVariable Integer idPreparat,
            @RequestParam Integer idAngajat) {
        // Creează o instanță a angajatului
        Angajat angajat = new Angajat();
        angajat.setIdAngajat(idAngajat);

        meniuService.removePreparatFromMeniu(idMeniu, idPreparat, angajat);

        return ResponseEntity.ok("Preparatul a fost șters cu succes.");
    }

    // Șterge un meniu după ID
    @DeleteMapping("/{idMeniu}")
    public ResponseEntity<Void> deleteMeniu(@PathVariable Integer idMeniu) {
        meniuService.deleteMeniu(idMeniu);
        return ResponseEntity.noContent().build();  // Răspuns fără conținut, semnificând că a fost șters
    }
}
