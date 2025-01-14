package org.scrum.restaurant.controller;

import org.scrum.restaurant.meniu.Bauturi;
import org.scrum.restaurant.service.BauturiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bauturi")
public class BauturiController {

    @Autowired
    private BauturiService bauturiService;

    // Salvarea unei băuturi
    @PostMapping("/save")
    public ResponseEntity<Bauturi> saveBautura(@RequestBody Bauturi bauturi) {
        Bauturi savedBautura = bauturiService.saveBautura(bauturi);
        return new ResponseEntity<>(savedBautura, HttpStatus.CREATED);
    }

    // Obținerea tuturor băuturilor
    @GetMapping("/")
    public ResponseEntity<List<Bauturi>> getAllBauturi() {
        List<Bauturi> bauturiList = bauturiService.getAllBauturi();
        return new ResponseEntity<>(bauturiList, HttpStatus.OK);
    }

    // Obținerea băuturilor după volum
    @GetMapping("/volum/{volum}")
    public ResponseEntity<List<Bauturi>> getBauturiByVolum(@PathVariable double volum) {
        List<Bauturi> bauturiList = bauturiService.getByVolum(volum);
        return new ResponseEntity<>(bauturiList, HttpStatus.OK);
    }

    // Obținerea băuturilor alcoolice/non-alcoolice
    @GetMapping("/alcoolic/{alcoolic}")
    public ResponseEntity<List<Bauturi>> getBauturiByAlcoolic(@PathVariable boolean alcoolic) {
        List<Bauturi> bauturiList = bauturiService.getByAlcoolic(alcoolic);
        return new ResponseEntity<>(bauturiList, HttpStatus.OK);
    }

    // Ștergerea unei băuturi
    @DeleteMapping("/delete/{idBautura}")
    public ResponseEntity<String> deleteBautura(@PathVariable Integer idBautura) {
        bauturiService.deleteBauturaById(idBautura);
        return new ResponseEntity<>("Băutura a fost ștearsă cu succes.", HttpStatus.OK);
    }

    // Actualizarea unei băuturi
    @PutMapping("/update/{idBautura}")
    public ResponseEntity<Bauturi> updateBautura(@PathVariable Integer idBautura, @RequestBody Bauturi bauturi) {
        Bauturi updatedBautura = bauturiService.updateBautura(idBautura, bauturi);
        return new ResponseEntity<>(updatedBautura, HttpStatus.OK);
    }
}
