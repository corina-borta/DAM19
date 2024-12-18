package org.scrum.restaurant.repo;

import org.scrum.restaurant.meniu.Bauturi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BauturiRepository extends JpaRepository<Bauturi, Long> {
    List<Bauturi> findByVolum(double volum);

    List<Bauturi> findByAlcoolic(boolean alcoolic);

    // Poți adăuga și un method customizat, dacă e nevoie
    List<Bauturi> findByNumeContaining(String nume);
}
