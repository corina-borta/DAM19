package org.scrum.restaurant.service;

import org.scrum.restaurant.meniu.ModificareMeniu;
import org.scrum.restaurant.repo.ModificareMeniuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModificareMeniuService {

    @Autowired
    private ModificareMeniuRepository modificareMeniuRepository;

    // Salvarea unei modificări de meniu
    public ModificareMeniu saveModificareMeniu(ModificareMeniu modificareMeniu) {
        if (modificareMeniu.getDescriereModificare() == null || modificareMeniu.getDescriereModificare().isEmpty()) {
            throw new IllegalStateException("Descrierea modificării nu poate fi goală.");
        }
        return modificareMeniuRepository.save(modificareMeniu);
    }

    // Obținerea tuturor modificărilor de meniu
    public List<ModificareMeniu> getAllModificariMeniu() {
        return modificareMeniuRepository.findAll();
    }

    // Obținerea modificărilor de meniu după ID-ul meniului
    public List<ModificareMeniu> getModificariMeniuById(Long idMeniu) {
        return modificareMeniuRepository.findByMeniu_Id(idMeniu);
    }

    // Obținerea modificărilor de meniu după ID-ul angajatului
    public List<ModificareMeniu> getModificariMeniuByAngajatId(Integer idAngajat) {
        return modificareMeniuRepository.findByidAngajat(idAngajat);
    }

    // Ștergerea unei modificări de meniu după ID
    public void deleteModificareMeniuById(Long id) {
        if (modificareMeniuRepository.existsById(id)) {
            modificareMeniuRepository.deleteById(id);
        } else {
            throw new RuntimeException("Modificarea de meniu cu ID-ul " + id + " nu a fost găsită.");
        }
    }

}
