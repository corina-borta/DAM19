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
    private final MeniuRepository meniuRepository;
    private final ModificareMeniuRepository modificareMeniuRepository;

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
        if (meniu.getPreparate() == null || meniu.getPreparate().isEmpty()) {
            throw new IllegalArgumentException("Meniul trebuie să conțină cel puțin un preparat.");
        }
        return meniuRepository.save(meniu);
    }

    public void deleteMeniu(Integer idMeniu) {
        if (meniuRepository.existsById(idMeniu)) {
            meniuRepository.deleteById(idMeniu);
        } else {
            throw new IllegalArgumentException("Meniul cu ID-ul " + idMeniu + " nu există.");
        }
    }

    public Meniu adaugaPreparatInMeniu(Integer idMeniu, Preparat preparat, Angajat angajat) {
        Optional<Meniu> meniuOptional = meniuRepository.findById(idMeniu);

        if (meniuOptional.isPresent()) {
            Meniu meniu = meniuOptional.get();
            meniu.adaugaPreparat(preparat);
            preparat.setMeniu(meniu);
            Meniu updatedMeniu = saveMeniu(meniu);

            String descriere = "Adăugat preparatul " + preparat.getNume();
            inregistreazaModificare(meniu, descriere, angajat);
            return updatedMeniu;
        } else {
            throw new IllegalArgumentException("Meniul cu ID-ul " + idMeniu + " nu a fost găsit.");
        }
    }

    public void removePreparatFromMeniu(Integer idMeniu, Integer idPreparat, Angajat angajat) {
        Meniu meniu = getMeniuById(idMeniu);
        if (meniu == null) {
            throw new IllegalArgumentException("Meniul cu ID-ul " + idMeniu + " nu a fost găsit.");
        }

        Preparat preparat = meniu.getPreparate().stream()
                .filter(p -> p.getIdPreparat().equals(idPreparat))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Preparatul cu ID-ul " + idPreparat + " nu a fost găsit în meniu."));

        meniu.getPreparate().remove(preparat);
        meniuRepository.save(meniu);

        String descriere = "Șters preparatul " + preparat.getNume();
        inregistreazaModificare(meniu, descriere, angajat);
    }

    public Meniu updateMeniu(Integer idMeniu, String numeMeniu, List<Preparat> preparate, Angajat angajat) {
        Optional<Meniu> meniuOptional = meniuRepository.findById(idMeniu);

        if (meniuOptional.isPresent()) {
            Meniu meniu = meniuOptional.get();
            meniu.setNumeMeniu(numeMeniu);
            meniu.setPreparate(preparate);
            Meniu updatedMeniu = saveMeniu(meniu);

            String descriere = "Actualizat meniul cu numele " + numeMeniu;
            inregistreazaModificare(updatedMeniu, descriere, angajat);

            return updatedMeniu;
        } else {
            throw new IllegalArgumentException("Meniul cu ID-ul " + idMeniu + " nu a fost găsit.");
        }
    }
}
