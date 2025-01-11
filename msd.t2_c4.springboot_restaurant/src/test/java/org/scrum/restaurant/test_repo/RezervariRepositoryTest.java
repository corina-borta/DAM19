package org.scrum.restaurant.test_repo;

import org.junit.jupiter.api.Test;
import org.scrum.restaurant.management.Rezervari;
import org.scrum.restaurant.repo.RezervariRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class RezervariRepositoryTest {

    @Autowired
    private RezervariRepository rezervariRepository;

    @Test
    public void testFindByNumeClient() {
        Rezervari rezervare1 = new Rezervari(1, "Popescu", 2, null, null, null, null);
        Rezervari rezervare2 = new Rezervari(2, "Popescu", 4, null, null, null, null);
        rezervariRepository.save(rezervare1);
        rezervariRepository.save(rezervare2);

        List<Rezervari> result = rezervariRepository.findByNumeClient("Popescu");
        assertThat(result).hasSize(2);
    }

    @Test
    public void testFindByDataRezervare() {
        Rezervari rezervare1 = new Rezervari(1, "Popescu", 2, null, null, null, null);
        rezervariRepository.save(rezervare1);

        List<Rezervari> result = rezervariRepository.findByDataRezervare(null); // Test cu valoare null pentru data
        assertThat(result).isNotEmpty();
    }
}

