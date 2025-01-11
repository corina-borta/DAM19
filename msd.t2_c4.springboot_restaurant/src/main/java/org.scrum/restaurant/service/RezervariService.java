package org.scrum.restaurant.service;

import org.scrum.restaurant.management.Rezervari;
import org.scrum.restaurant.management.StatusRezervare;
import org.scrum.restaurant.repo.RezervariRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RezervariService {
    private final RezervariRepository rezervariRepository;

    public RezervariService(RezervariRepository rezervariRepository) {
        this.rezervariRepository = rezervariRepository;
    }

    public Rezervari addRezervare(Rezervari rezervare) {
        return rezervariRepository.save(rezervare);
    }

    public List<Rezervari> getAllRezervari() {
        return rezervariRepository.findAll();
    }

    public Optional<Rezervari> getRezervareById(Integer id) {
        return rezervariRepository.findById(id);
    }

    public List<Rezervari> getRezervariByNumeClient(String numeClient) {
        return rezervariRepository.findByNumeClient(numeClient);
    }

    public List<Rezervari> getRezervariByDataRezervare(Date dataRezervare) {
        return rezervariRepository.findByDataRezervare(dataRezervare);
    }

    public List<Rezervari> getRezervariByStatus(StatusRezervare statusRezervare) {
        return rezervariRepository.findByStatusRezervare(statusRezervare);
    }

    public Rezervari updateRezervare(Rezervari rezervare) {
        return rezervariRepository.save(rezervare);
    }

    public void deleteRezervare(Integer id) {
        rezervariRepository.deleteById(id);
    }
}
