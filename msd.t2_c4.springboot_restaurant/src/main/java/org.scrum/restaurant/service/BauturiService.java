package org.scrum.restaurant.service;

import org.scrum.restaurant.meniu.Bauturi;
import org.scrum.restaurant.meniu.Preparat;
import org.scrum.restaurant.meniu.TipPreparat;
import org.scrum.restaurant.repo.BauturiRepository;
import org.scrum.restaurant.repo.PreparateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BauturiService {

    @Autowired
    private final BauturiRepository bauturiRepository;


    public BauturiService(BauturiRepository bauturiRepository) {
        this.bauturiRepository = bauturiRepository;
    }

    // Salvarea unei băuturi
    public Bauturi saveBautura(Bauturi bauturi) {
        if (bauturi.getVolum() <= 0) {
            throw new IllegalStateException("Volumul băuturii trebuie să fie mai mare decât 0.");
        }
        return bauturiRepository.save(bauturi);
    }

    // Obținerea tuturor băuturilor
    public List<Bauturi> getAllBauturi() {
        return bauturiRepository.findAll();
    }

    // Obținerea băuturilor după volum
    public List<Bauturi> getByVolum(double volum) {
        return bauturiRepository.findByVolum(volum);
    }

    // Obținerea băuturilor alcoolice sau non-alcoolice
    public List<Bauturi> getByAlcoolic(boolean alcoolic) {
        return bauturiRepository.findByAlcoolic(alcoolic);
    }

    // Ștergerea unei băuturi după ID
    public void deleteBauturaById(Integer idBautura) {
        if (bauturiRepository.existsById(idBautura)) {
            bauturiRepository.deleteById(idBautura);
        } else {
            throw new RuntimeException("Băutura cu ID-ul " + idBautura + " nu a fost găsită.");
        }
    }

    // Actualizarea unei băuturi
    public Bauturi updateBautura(Integer idBautura, Bauturi bauturi) {
        if (bauturiRepository.existsById(idBautura)) {
            bauturi.setIdPreparat(idBautura); // menținem același ID
            return bauturiRepository.save(bauturi);
        } else {
            throw new RuntimeException("Băutura cu ID-ul " + idBautura + " nu a fost găsită.");
        }
    }



}
