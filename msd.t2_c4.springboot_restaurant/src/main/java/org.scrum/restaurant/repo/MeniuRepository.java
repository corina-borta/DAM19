package org.scrum.restaurant.repo;

import org.scrum.restaurant.meniu.Meniu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeniuRepository extends JpaRepository<Meniu, Integer> {

    List<Meniu> findByNumeMeniu(String numeMeniu);

    // Găsește meniuri care conțin un anumit preparat
    List<Meniu> findByPreparateList_IdPreparat(Integer idPreparat);


}
