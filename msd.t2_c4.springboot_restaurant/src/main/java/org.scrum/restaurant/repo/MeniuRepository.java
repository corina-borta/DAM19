package org.scrum.restaurant.repo;

import org.scrum.restaurant.meniu.Meniu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeniuRepository extends JpaRepository<Meniu, Integer> {

    // Găsește meniurile care conțin un preparat specific
    List<Meniu> findByPreparate_IdPreparat(Integer idPreparat);

    // Găsește meniurile după numele lor
    List<Meniu> findByNumeMeniu(String numeMeniu);

    // Alte metode personalizate pot fi adăugate aici
}
