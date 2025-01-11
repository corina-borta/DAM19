package org.scrum.restaurant.repo;

import org.scrum.restaurant.management.Rezervari;
import org.scrum.restaurant.management.StatusRezervare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RezervariRepository extends JpaRepository<Rezervari, Integer> {
    // Găsește rezervările după numele clientului
    List<Rezervari> findByNumeClient(String numeClient);

    // Găsește rezervările după data rezervării
    List<Rezervari> findByDataRezervare(Date dataRezervare);

    // Găsește rezervările după status
    List<Rezervari> findByStatusRezervare(StatusRezervare statusRezervare);

    // Alte metode personalizate, dacă sunt necesare
}
