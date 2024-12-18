package org.scrum.restaurant.service;

import org.scrum.restaurant.meniu.ModificareMeniu;
import org.scrum.restaurant.repo.ModificareMeniuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModificareMeniuService {
    private final ModificareMeniuRepository modificareMeniuRepository;

    public ModificareMeniuService(ModificareMeniuRepository modificareMeniuRepository) {
        this.modificareMeniuRepository = modificareMeniuRepository;
    }

    public List<ModificareMeniu> getAllModificari() {
        return modificareMeniuRepository.findAll();
    }

    public List<ModificareMeniu> getModificariByMeniu(Long idMeniu) {
        return modificareMeniuRepository.findByMeniu_IdMeniu(idMeniu);
    }

    public ModificareMeniu saveModificare(ModificareMeniu modificare) {
        return modificareMeniuRepository.save(modificare);
    }

    public void deleteModificare(Long id) {
        modificareMeniuRepository.deleteById(id);
    }
}
