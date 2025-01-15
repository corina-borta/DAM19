package org.scrum.restaurant.repo;

import org.scrum.restaurant.meniu.ModificareMeniu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ModificareMeniuRepository extends JpaRepository<ModificareMeniu, Integer> {

    // Găsește modificări efectuate de un anumit angajat
    List<ModificareMeniu> findByAngajat_IdAngajat(Integer idAngajat);

    // Găsește modificări efectuate într-un anumit interval de timp
    List<ModificareMeniu> findByDataModificariiBetween(LocalDateTime startDate, LocalDateTime endDate);

    // Găsește modificări ale unui anumit meniu
    List<ModificareMeniu> findByMeniu_IdMeniu(Integer idMeniu);
}

