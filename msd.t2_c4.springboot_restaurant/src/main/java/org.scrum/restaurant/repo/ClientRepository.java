package org.scrum.restaurant.repo;

import org.scrum.restaurant.persoane.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findByNumeClient(String numeClient);
    List<Client> findByNumeClientContaining(String partialNumeClient);
    List<Client> findByActiv(Boolean activ);
    List<Client> findByEmail(String email);
}


