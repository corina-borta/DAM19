package org.scrum.restaurant.repo;

import org.scrum.restaurant.persoane.Angajat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AngajatRepository extends JpaRepository<Angajat, Integer> {
    List<Angajat> findByRolAngajat(String rolAngajat); // Corect numele metodei

    List<Angajat> findBySalariuBetween(double min, double max);
}
