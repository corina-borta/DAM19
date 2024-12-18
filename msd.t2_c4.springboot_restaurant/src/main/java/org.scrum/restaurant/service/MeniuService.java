package org.scrum.restaurant.service;

import org.scrum.restaurant.meniu.Meniu;
import org.scrum.restaurant.repo.MeniuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeniuService {
    private final MeniuRepository meniuRepository;

    public MeniuService(MeniuRepository meniuRepository) {
        this.meniuRepository = meniuRepository;
    }

    public List<Meniu> getAllMeniuri() {
        return meniuRepository.findAll();
    }

    public Meniu getMeniuById(Long id) {
        return meniuRepository.findById(id).orElse(null);
    }

    public List<Meniu> getMeniuriByDescriere(String descriere) {
        return meniuRepository.findByDescriereContainingIgnoreCase(descriere);
    }

    public Meniu saveMeniu(Meniu meniu) {
        return meniuRepository.save(meniu);
    }

    public void deleteMeniu(Long id) {
        meniuRepository.deleteById(id);
    }
}
