package org.scrum.restaurant.test_repo;

import org.junit.jupiter.api.Test;
import org.scrum.restaurant.persoane.Angajat;
import org.scrum.restaurant.repo.AngajatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AngajatRepositoryTest {

    @Autowired
    private AngajatRepository angajatRepository;

    @Test
    public void testFindByRol() {
        // Salvăm angajați de test
        Angajat angajat1 = new Angajat("Popescu Ion", "0745123456", "popescu@email.com", "Bucatar", 3000.0);
        Angajat angajat2 = new Angajat("Ionescu Maria", "0734456789", "ionescu@email.com", "Bucatar", 3500.0);
        angajatRepository.save(angajat1);
        angajatRepository.save(angajat2);

        // Testăm metoda findByRol
        List<Angajat> angajati = angajatRepository.findByRolAngajat("Bucatar");
        assertThat(angajati).hasSize(2);
        assertThat(angajati.get(0).getRolAngajat()).isEqualTo("Bucatar");
        assertThat(angajati.get(1).getRolAngajat()).isEqualTo("Bucatar");
    }

    @Test
    public void testFindBySalariuBetween() {
        // Salvăm angajați de test
        Angajat angajat1 = new Angajat("Popescu Ion", "0745123456", "popescu@email.com", "Bucatar", 2500.0);
        Angajat angajat2 = new Angajat("Ionescu Maria", "0734456789", "ionescu@email.com", "Chelner", 3800.0);
        Angajat angajat3 = new Angajat("Georgescu Andrei", "0723123456", "georgescu@email.com", "Manager", 4500.0);
        angajatRepository.save(angajat1);
        angajatRepository.save(angajat2);
        angajatRepository.save(angajat3);

        // Testăm metoda findBySalariuBetween
        List<Angajat> angajati = angajatRepository.findBySalariuBetween(2000.0, 4000.0);
        assertThat(angajati).hasSize(2);
    }
}
