package org.scrum.restaurant.service;

import org.scrum.restaurant.management.Preluare_Comenzi;
import org.scrum.restaurant.repo.PreluareComenziRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PreluareComenziService {

    @Autowired
    private PreluareComenziRepository preluareComenziRepository;

    // Adaugă o nouă preluare de comandă
    public Preluare_Comenzi addPreluareComanda(Preluare_Comenzi preluareComenzi) {
        return preluareComenziRepository.save(preluareComenzi);
    }

    // Găsește o preluare de comandă după ID
    public Optional<Preluare_Comenzi> getPreluareComandaById(Long id) {
        return preluareComenziRepository.findById(id);
    }

    // Găsește toate comenzile preluate de un angajat
    public List<Preluare_Comenzi> getPreluariByAngajatId(Long angajatId) {
        return preluareComenziRepository.findByAngajat_Id(angajatId);
    }

    // Găsește toate comenzile preluate de un client
    public List<Preluare_Comenzi> getPreluariByClientId(Long clientId) {
        return preluareComenziRepository.findByClient_Id(clientId);
    }

    // Găsește toate comenzile preluate într-un interval de timp
    public List<Preluare_Comenzi> getPreluariInInterval(LocalDateTime start, LocalDateTime end) {
        return preluareComenziRepository.findByOraPreluariiBetween(start, end);
    }

    // Șterge o preluare de comandă după ID
    public void deletePreluareComanda(Long id) {
        preluareComenziRepository.deleteById(id);
    }
}
