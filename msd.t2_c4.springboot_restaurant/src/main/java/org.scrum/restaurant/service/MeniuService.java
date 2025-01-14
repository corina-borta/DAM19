package org.scrum.restaurant.service;

import org.scrum.restaurant.meniu.Meniu;
import org.scrum.restaurant.meniu.ModificareMeniu;
import org.scrum.restaurant.meniu.Preparat;
import org.scrum.restaurant.persoane.Angajat;
import org.scrum.restaurant.repo.MeniuRepository;
import org.scrum.restaurant.repo.ModificareMeniuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MeniuService {
    @Autowired
    private final MeniuRepository meniuRepository;
    @Autowired
    private ModificareMeniuRepository modificareMeniuRepository;
    @Autowired
    public MeniuService(MeniuRepository meniuRepository, ModificareMeniuRepository modificareMeniuRepository) {
        this.meniuRepository = meniuRepository;
        this.modificareMeniuRepository = modificareMeniuRepository;
    }

    private void inregistreazaModificare(Meniu meniu, String descriere, Angajat angajat) {
        ModificareMeniu modificare = new ModificareMeniu(
                angajat,
                meniu,
                LocalDateTime.now(),
                descriere
        );
        modificareMeniuRepository.save(modificare);
    }

    public List<Meniu> getAllMeniuri() {
        return meniuRepository.findAll();
    }

    public Meniu getMeniuById(Integer idMeniu) {
        return meniuRepository.findById(idMeniu).orElse(null);
    }

    public List<Meniu> getMeniuriByNumeMeniu(String numeMeniu) {
        return meniuRepository.findByNumeMeniu(numeMeniu);
    }
    public Meniu saveMeniu(Meniu meniu) {
        if (meniu.getPreparate().isEmpty()) {
            throw new IllegalArgumentException("Meniul trebuie să conțină cel puțin un preparat");
        }
        return meniuRepository.save(meniu);
    }

    public void deleteMeniu(Integer idMeniu) {
        meniuRepository.deleteById(idMeniu);
    }

    public Meniu adaugaPreparatInMeniu(Integer idMeniu, Preparat preparat, Angajat angajat) {
        Optional<Meniu> meniuOptional = meniuRepository.findById(idMeniu);

        if (meniuOptional.isPresent()) {
            Meniu meniu = meniuOptional.get();
            meniu.adaugaPreparat(preparat); // Folosind metoda deja existentă din Meniu
            preparat.setMeniu(meniu);  // Asigură-te că preparatul are meniu asociat
            saveMeniu(meniu);  // Salvează meniu actualizat

            String descriere = "Adăugat preparatul " + preparat.getNume();
            inregistreazaModificare(meniu, descriere, angajat);
            return meniu;
        } else {
            return null; // Returnează null dacă meniu nu a fost găsit
        }
    }
    public void removePreparatFromMeniu(Integer idMeniu, Integer idPreparat, Angajat angajat) {
        Meniu meniu = getMeniuById(idMeniu);
        Preparat preparat = meniu.getPreparate().stream()
                .filter(p -> p.getIdPreparat().equals(idPreparat))
                .findFirst().orElse(null);
        if (preparat != null) {
            meniu.getPreparate().remove(preparat);
            meniuRepository.save(meniu);
            String descriere = "Șters preparatul " + preparat.getNume();
            inregistreazaModificare(meniu, descriere, angajat);
        }

    }
    public Meniu updateMeniu(Integer idMeniu, String numeMeniu, List<Preparat> preparate, Angajat angajat) {
        Optional<Meniu> meniuOptional = meniuRepository.findById(idMeniu);

        if (meniuOptional.isPresent()) {
            Meniu meniu = meniuOptional.get();
            meniu.setNumeMeniu(numeMeniu);
            meniu.setPreparate(preparate);  // Setează preparatele actualizate
            return saveMeniu(meniu);

        } else {
            return null; // Returnează null dacă meniu nu a fost găsit
        }
    }
}
