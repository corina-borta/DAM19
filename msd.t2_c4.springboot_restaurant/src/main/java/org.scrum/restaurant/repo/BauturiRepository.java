package org.scrum.restaurant.repo;

import org.scrum.restaurant.meniu.Bauturi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BauturiRepository extends JpaRepository<Bauturi, Integer> {
    List<Bauturi> findByVolum(double volum);

    List<Bauturi> findByAlcoolic(boolean alcoolic);
}
