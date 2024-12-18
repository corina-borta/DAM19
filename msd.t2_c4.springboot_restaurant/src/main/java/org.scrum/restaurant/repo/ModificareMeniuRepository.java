package org.scrum.restaurant.repo;

import org.scrum.restaurant.meniu.ModificareMeniu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModificareMeniuRepository extends JpaRepository<ModificareMeniu, Long> {
    // Găsește modificări ale unui anumit meniu
    List<ModificareMeniu> findByMeniu_IdMeniu(Long idMeniu);

    // Găsește modificări efectuate într-un anumit interval de timp
    List<ModificareMeniu> findByDataModificariiBetween(String startDate, String endDate);
}