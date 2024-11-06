package org.scrum.domain.services;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.scrum.Angajat.Angajat;
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
public class Test2Angajat {
  // private static Logger logger = Logger.getLogger(Test1_Client.class.getName());
  @Test
  public void testAngajatConstructor() {
      Angajat angajat = new Angajat(1, "Ion Popescu", 0745123456, "ion.popescu@example.com", "Chelner");

      assertEquals(Optional.of(1), angajat.getIDAngajat());
      assertEquals("Ion Popescu", angajat.getNumeAngajat());
      assertEquals("0745123456", angajat.getTelefon());
      assertEquals("ion.popescu@example.com", angajat.getEmail());
      assertEquals("Bucatar", angajat.getRolAngajat());
  }

    @Test
    public void testAngajatSetterMethods() {
        Angajat angajat = new Angajat();
        angajat.setNumeAngajat("Vasile Ionescu");
        angajat.setTelefon(0745321456);

        assertEquals("Vasile Ionescu", angajat.getNumeAngajat());
        assertEquals("0745321456", angajat.getTelefon());
    }

}