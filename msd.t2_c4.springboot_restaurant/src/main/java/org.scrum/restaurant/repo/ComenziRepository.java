package org.scrum.restaurant.repo;

import org.scrum.restaurant.management.Comenzi;
import org.scrum.restaurant.management.StatusComanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ComenziRepository extends JpaRepository<Comenzi, Integer> {

    // Găsește comenzile după status
    List<Comenzi> findByStatus(StatusComanda status);

    // Găsește comenzile după metodă de plată
    List<Comenzi> findByMetodaPlata(String metodaPlata);

    // Găsește comenzile dintr-un interval de timp
    List<Comenzi> findByDataComenziiBetween(Date startDate, Date endDate);

    // Găsește comenzile care au suma totală mai mare decât o anumită valoare
    List<Comenzi> findByTotalComandaGreaterThanEqual(Double total);
}

