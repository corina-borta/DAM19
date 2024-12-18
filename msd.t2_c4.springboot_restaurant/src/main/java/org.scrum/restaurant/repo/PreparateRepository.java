package org.scrum.restaurant.repo;

import org.scrum.restaurant.meniu.Preparat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreparateRepository extends JpaRepository<Preparat, Long> {

     List<Preparat> findByNume(String nume);

    // Găsește preparate cu preț mai mic decât o anumită valoare
    List<Preparat> findByPretLessThan(Double pret);
}
