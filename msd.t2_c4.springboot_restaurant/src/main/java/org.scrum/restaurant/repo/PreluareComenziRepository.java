package org.scrum.restaurant.repo;

import org.scrum.restaurant.management.Preluare_Comenzi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PreluareComenziRepository extends JpaRepository<Preluare_Comenzi, Long> {

    // Găsește toate comenzile preluate de un anumit angajat
    List<Preluare_Comenzi> findByAngajat_IdAngajat(Long idAngajat);

    // Găsește toate comenzile preluate de un anumit client
    List<Preluare_Comenzi> findByClient_IdClient(Long idClient);

    // Găsește toate comenzile preluate într-un interval de timp
    List<Preluare_Comenzi> findByOraPreluariiBetween(LocalDateTime start, LocalDateTime end);

    // Găsește comenzile preluate pentru o anumită comandă
    List<Preluare_Comenzi> findByComanda_IdComanda(Integer idComanda);
}

