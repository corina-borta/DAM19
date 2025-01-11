package org.scrum.restaurant.service;

import org.scrum.restaurant.persoane.Angajat;
import org.scrum.restaurant.repo.AngajatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AngajatService {
    private final AngajatRepository angajatRepository;

    public AngajatService(AngajatRepository angajatRepository) {
        this.angajatRepository = angajatRepository;
    }

    public Angajat addAngajat(Angajat angajat) {
        return angajatRepository.save(angajat);
    }

    public List<Angajat> getAllAngajati() {
        return angajatRepository.findAll();
    }

    public Optional<Angajat> getAngajatById(Integer id) {
        return angajatRepository.findById(id);
    }

    public Angajat updateAngajat(Angajat angajat) {
        return angajatRepository.save(angajat);
    }

    public void deleteAngajat(Integer id) {
        angajatRepository.deleteById(id);
    }
}
