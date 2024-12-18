package org.scrum.restaurant.service;

import org.scrum.restaurant.meniu.Preparat;
import org.scrum.restaurant.repo.PreparateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreparateService {
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
    public List<Preparat> findAllPreparate() {
        return preparatRepository.findAll();
    }

    // Metodă pentru a găsi un preparat după ID
    public List<Preparat> findByNume(String nume) {
        return preparatRepository.findByNume(nume);
    }


    // Metodă pentru a șterge un preparat după ID
    public void deletePreparatById(Long id) {
        preparatRepository.deleteById(id);
    }

    // Metodă personalizată, dacă este nevoie (ex: găsire după preț)
    public List<Preparat> findPreparateByPretLessThan(double maxPret) {
        return preparatRepository.findAll()
                .stream()
                .filter(preparat -> preparat.getPret() < maxPret)
                .toList();
    }
}
