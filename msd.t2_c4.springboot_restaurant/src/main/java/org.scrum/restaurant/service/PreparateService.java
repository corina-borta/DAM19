package org.scrum.restaurant.service;

import org.scrum.restaurant.meniu.Bauturi;
import org.scrum.restaurant.meniu.Preparat;
import org.scrum.restaurant.meniu.TipPreparat;
import org.scrum.restaurant.repo.PreparateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreparateService {
    @Autowired
    private final PreparateRepository preparatRepository;

    public PreparateService(PreparateRepository preparatRepository) {
        this.preparatRepository = preparatRepository;
    }

    // Metodă pentru a salva un preparat
    public Preparat savePreparat(Preparat preparat) {
        if (preparat.getPret() <= 0) {
            throw new IllegalStateException("Prețul preparatului trebuie să fie mai mare decât 0.");
        }
        if (preparat.getNume() == null || preparat.getNume().isEmpty()) {
            throw new IllegalStateException("Numele preparatului nu poate fi gol.");
        }
        return preparatRepository.save(preparat);
    }

    // Metodă pentru a găsi toate preparatele
    public List<Preparat> getAllPreparate() {
        return preparatRepository.findAll();
    }

    // Metodă pentru a găsi un preparat după nume
    public List<Preparat> getByNume(String nume) {
        return preparatRepository.findByNume(nume);
    }

    public List<Preparat> getPreparateByPretGreaterThanEqual(double pret) {
        return preparatRepository.findByPretGreaterThanEqual(pret);
    }

    public List<Preparat> getByMeniu(Long idMeniu) {
        return preparatRepository.findByMeniuIdMeniu(idMeniu);
    }


    // Metodă pentru a șterge un preparat după ID
    public void deletePreparatByidPreparat(Long idPreparat) {
        if (preparatRepository.existsById(idPreparat)) {
            preparatRepository.deleteById(idPreparat); // Ștergem preparatul din baza de date
        } else {
            throw new RuntimeException("Preparat cu id-ul " + idPreparat + " nu a fost găsit!"); // Aruncăm excepție dacă nu există
        }
    }
    public Preparat updatePreparat(Long idPreparat, Preparat preparat) {
        if (preparatRepository.existsById(idPreparat)) {
            preparat.setIdPreparat(idPreparat); // asigură-te că ID-ul rămâne același
            return preparatRepository.save(preparat);
        } else {
            throw new RuntimeException("Preparat cu id-ul " + idPreparat + " nu a fost găsit!"); // Poți returna un răspuns mai detaliat sau să arunci o excepție
        }
    }
    public List<Preparat> getPreparateByTip(TipPreparat tipPreparat) {
        return preparatRepository.findByTipPreparat(tipPreparat); // Apelăm un repository customizat pentru a căuta după tip
    }

}
