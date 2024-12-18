package org.scrum.restaurant;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.scrum.restaurant.persoane.Client;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * COMPUTATION Business Service Tests
 * Strategy: Simple-Facade
 *
 * https://www.logicbig.com/tutorials/spring-framework/spring-core/integration-testing.html
 */

//JUnit.5
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class Test1Client {
   // private static Logger logger = Logger.getLogger(Test1_Client.class.getName());
   @Test
   public void testClientConstructor() {
       Client client = new Client(1, "Maria Ionescu", "0746123456", "maria.ionescu@example.com");

       assertEquals(Optional.of(1), client.getIdClient());
       assertEquals("Maria Ionescu", client.getNumeClient());
       assertEquals("0746123456", client.getTelefon());
       assertEquals("maria.ionescu@example.com", client.getEmail());
   }

    @Test
    public void testClientSetterMethods() {
        Client client = new Client();
        client.setNumeClient("Ion Popescu");
        client.setTelefon("0756123456");
        client.setEmail("ion.popescu@example.com");

        assertEquals("Ion Popescu", client.getNumeClient());
        assertEquals("0756123456", client.getTelefon());
        assertEquals("ion.popescu@example.com", client.getEmail());
    }

   /* @Test
    public void testUpdateTelefon() {
        Client client = new Client();
        client.setTelefon(0745123456);
        assertEquals("0745123456", client.getTelefon());

        // Modificăm numărul de telefon
        client.setTelefon(0765123456);
        assertEquals("0765123456", client.getTelefon());
    }

    @Test
    public void testUpdateEmail() {
        Client client = new Client();
        client.setEmail("initial@example.com");
        assertEquals("initial@example.com", client.getEmail());

        // Modificăm adresa de email
        client.setEmail("actualizat@example.com");
        assertEquals("actualizat@example.com", client.getEmail());
    }

   /* @Test
    public void testInvalidTelefon() {
        Client client = new Client();
        client.setTelefon("abcd1234");
    }*/

  /*  @Test
    public void testInvalidEmail() {
        Client client = new Client();
        // Setăm un email invalid pentru a declanșa excepția
        client.setEmail("email_invalid"); // Presupunem că metoda aruncă o excepție pentru format invalid
    }*/

}