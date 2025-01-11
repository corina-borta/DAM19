package org.scrum.restaurant;

import org.junit.jupiter.api.Test;
import org.scrum.restaurant.persoane.Client;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test1Client {

    @Test
    public void testClientConstructor() {
        Client client = new Client(1, "Maria Ionescu", "0746123456", "maria.ionescu@example.com", true);

        assertEquals(Integer.valueOf(1), client.getIdClient());
        assertEquals("Maria Ionescu", client.getNumeClient());
        assertEquals("0746123456", client.getTelefon());
        assertEquals("maria.ionescu@example.com", client.getEmail());
        assertEquals(true, client.isActiv());
    }


    @Test
    public void testClientSetterMethods() {
        Client client = new Client();
        client.setIdClient(2);
        client.setNumeClient("Vasile Popescu");
        client.setTelefon("0753456789");
        client.setEmail("vasile.popescu@example.com");
        client.setActiv(false);

        assertEquals(Integer.valueOf(2), client.getIdClient());
        assertEquals("Vasile Popescu", client.getNumeClient());
        assertEquals("0753456789", client.getTelefon());
        assertEquals("vasile.popescu@example.com", client.getEmail());
        assertEquals(false, client.isActiv());
    }
}
