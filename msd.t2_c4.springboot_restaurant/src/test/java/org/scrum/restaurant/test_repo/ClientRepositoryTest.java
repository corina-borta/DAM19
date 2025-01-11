package org.scrum.restaurant.test_repo;

import org.junit.jupiter.api.Test;
import org.scrum.restaurant.persoane.Client;
import org.scrum.restaurant.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void testFindByNumeClient() {
        Client client1 = new Client("Popescu", "0723123456", "popescu@email.com", true);
        Client client2 = new Client("Popescu", "0733456789", "maria@email.com", false);
        clientRepository.save(client1);
        clientRepository.save(client2);

        List<Client> result = clientRepository.findByNumeClient("Popescu");
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getNumeClient()).isEqualTo("Popescu");
        assertThat(result.get(1).getNumeClient()).isEqualTo("Popescu");
    }


    @Test
    public void testFindByActiv() {
        Client client1 = new Client("Popescu", "0723123456", "popescu@email.com", true);
        Client client2 = new Client("Ionescu", "0733456789", "ionescu@email.com", false);
        clientRepository.save(client1);
        clientRepository.save(client2);

        List<Client> result = clientRepository.findByActiv(true);
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getNumeClient()).isEqualTo("Popescu");
        assertThat(result.get(0).isActiv()).isTrue();
    }

}
