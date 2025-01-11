package org.scrum.restaurant.service;

import org.scrum.restaurant.management.Comenzi;
import org.scrum.restaurant.repo.ComenziRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComenziService {

    @Autowired
    private ComenziRepository comenziRepository;

    // Găsește toate comenzile
    public List<Comenzi> getAllComenzi() {
        return comenziRepository.findAll();
    }

    // Găsește o comandă după ID
    public Optional<Comenzi> getComandaById(Integer id) {
        return comenziRepository.findById(id);
    }

    // Adaugă o comandă nouă
    public Comenzi saveComanda(Comenzi comanda) {
        return comenziRepository.save(comanda);
    }

    // Șterge o comandă după ID
    public void deleteComanda(Integer id) {
        comenziRepository.deleteById(id);
    }

    // Găsește comenzile după status
    public List<Comenzi> getComenziByStatus(String status) {
        return comenziRepository.findByStatus(status);
    }
}
