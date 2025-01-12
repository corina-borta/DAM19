package org.scrum.restaurant.repo;

import org.scrum.restaurant.meniu.Meniu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeniuRepository extends JpaRepository<Meniu, Long> {

    List<Meniu> findByNumeMeniu(String numeMeniu);

<<<<<<< HEAD
    // Găsește meniuri care conțin un anumit preparat
    List<Meniu> findByPreparateList_IdPreparat(Long idPreparat);

    // Găsește toate meniurile care au cel puțin o comandă
    List<Meniu> findByComenziMeniuIsNotNull();
=======
>>>>>>> origin/corina
}
