package org.scrum.restaurant.test_service;

import org.junit.jupiter.api.Test;
import org.scrum.restaurant.service.PreparateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class PreparatServiceTest {

    @Autowired
    private PreparateService preparatService;

    @Test
    public void testFindAllPreparate() {
        assertFalse(preparatService.getAllPreparate().isEmpty());

        ArrayList<String> list = new ArrayList<>();
        list.add("Element1");
        list.add("Element2");

        Iterator<String> iterator = list.iterator();
        // Parcurgem lista
        assertTrue(iterator.hasNext());
        iterator.next();  // Avansăm iteratorul

        // Apelăm remove() de două ori, ceea ce este invalid
        iterator.remove(); // Eliminăm elementul curent

        // Verificăm că o a doua eliminare aruncă IllegalStateException
        assertThrows(IllegalStateException.class, () -> {
            iterator.remove(); // Aceasta va arunca IllegalStateException
        });
    }
}
