package org.scrum.restaurant.restservice;

import org.scrum.restaurant.management.Preluare_Comenzi;
import org.scrum.restaurant.service.PreluareComenziService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/preluare-comenzi")
public class PreluareComenziRestService {

    @Autowired
    private PreluareComenziService preluareComenziService;

    // Adaugă o nouă preluare de comandă
    @PostMapping
    public ResponseEntity<Preluare_Comenzi> addPreluareComanda(@RequestBody Preluare_Comenzi preluareComenzi) {
        Preluare_Comenzi savedPreluare = preluareComenziService.addPreluareComanda(preluareComenzi);
        return ResponseEntity.ok(savedPreluare);
    }

    // Găsește o preluare de comandă după ID
    @GetMapping("/{id}")
    public ResponseEntity<Preluare_Comenzi> getPreluareComandaById(@PathVariable Long id) {
        Optional<Preluare_Comenzi> preluareComenzi = preluareComenziService.getPreluareComandaById(id);
        return preluareComenzi.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Găsește toate comenzile preluate de un angajat
    @GetMapping("/angajat/{angajatId}")
    public ResponseEntity<List<Preluare_Comenzi>> getPreluariByAngajatId(@PathVariable Long angajatId) {
        List<Preluare_Comenzi> preluari = preluareComenziService.getPreluariByAngajatId(angajatId);
        return ResponseEntity.ok(preluari);
    }

    // Găsește toate comenzile preluate de un client
    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Preluare_Comenzi>> getPreluariByClientId(@PathVariable Long clientId) {
        List<Preluare_Comenzi> preluari = preluareComenziService.getPreluariByClientId(clientId);
        return ResponseEntity.ok(preluari);
    }

    // Găsește toate comenzile preluate într-un interval de timp
    @GetMapping("/interval")
    public ResponseEntity<List<Preluare_Comenzi>> getPreluariInInterval(
            @RequestParam("start") String start,
            @RequestParam("end") String end) {
        LocalDateTime startTime = LocalDateTime.parse(start);
        LocalDateTime endTime = LocalDateTime.parse(end);
        List<Preluare_Comenzi> preluari = preluareComenziService.getPreluariInInterval(startTime, endTime);
        return ResponseEntity.ok(preluari);
    }

    // Șterge o preluare de comandă după ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePreluareComanda(@PathVariable Long id) {
        preluareComenziService.deletePreluareComanda(id);
        return ResponseEntity.noContent().build();
    }
}

