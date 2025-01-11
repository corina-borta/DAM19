package org.scrum.restaurant;

import org.junit.jupiter.api.Test;
import org.scrum.restaurant.persoane.Angajat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test2Angajat {

    @Test
    public void testAngajatConstructor() {
        Angajat angajat = new Angajat(1, "Ion Popescu", "0745123456", "ion.popescu@example.com", "Chelner", 3500.0);

        assertEquals(Integer.valueOf(1), angajat.getIdAngajat());
        assertEquals("Ion Popescu", angajat.getNumeAngajat());
        assertEquals("0745123456", angajat.getTelefon());
        assertEquals("ion.popescu@example.com", angajat.getEmail());
        assertEquals("Chelner", angajat.getRolAngajat());
        assertEquals(3500.0, angajat.getSalariu());
    }

    @Test
    public void testAngajatSetterMethods() {
        Angajat angajat = new Angajat();
        angajat.setIdAngajat(2);
        angajat.setNumeAngajat("Vasile Ionescu");
        angajat.setTelefon("0751234567");
        angajat.setEmail("vasile.ionescu@example.com");
        angajat.setRolAngajat("Manager");
        angajat.setSalariu(4500.0);

        assertEquals(Integer.valueOf(2), angajat.getIdAngajat());
        assertEquals("Vasile Ionescu", angajat.getNumeAngajat());
        assertEquals("0751234567", angajat.getTelefon());
        assertEquals("vasile.ionescu@example.com", angajat.getEmail());
        assertEquals("Manager", angajat.getRolAngajat());
        assertEquals(4500.0, angajat.getSalariu());
    }
}
