package org.scrum.restaurant.test_repository;

import org.junit.jupiter.api.Test;
import org.scrum.restaurant.repo.ComenziRepository;
import org.scrum.restaurant.management.Comenzi;
import org.scrum.restaurant.management.StatusComanda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ComenziRepositoryTest {

    @Autowired
    private ComenziRepository comenziRepository;

    @Test
    public void testSaveAndFindById() {
        // Creare entitate
        Comenzi comanda = new Comenzi();
        comanda.setNumarMasa("10");
        comanda.setDataComenzii(new Date());
        comanda.setStatus(StatusComanda.IN_ASTEPTARE); // Înlocuiește cu o valoare validă din StatusComanda
        comanda.setMetodaPlata(null); // sau metoda de plată dorită
        comanda.setStatusPlata(null);
        comanda.setTotalComanda(BigDecimal.valueOf(100));

        // Salvare în repo
        Comenzi saved = comenziRepository.save(comanda);

        // Verificare salvare
        assertThat(saved).isNotNull();
        assertThat(saved.getIdComanda()).isNotNull();

        // Verificare căutare după ID
        Comenzi found = comenziRepository.findById(saved.getIdComanda()).orElse(null);
        assertThat(found).isNotNull();
        assertThat(found.getNumarMasa()).isEqualTo("10");
    }
}
