package org.scrum.restaurant.repo;

import org.scrum.restaurant.meniu.ModificareMeniu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModificareMeniuRepository extends JpaRepository<ModificareMeniu, Integer> {
    // Găsește modificări ale unui anumit meniu
    List<ModificareMeniu> findByidAngajat (Integer idAngajat);

    // Găsește modificări efectuate într-un anumit interval de timp
    List<ModificareMeniu> findByDataModificariiBetween(String startDate, String endDate);
    List<ModificareMeniu> findByMeniu_Id(Integer idMeniu);

}
