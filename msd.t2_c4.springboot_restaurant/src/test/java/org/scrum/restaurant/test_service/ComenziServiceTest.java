package org.scrum.restaurant.test_service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.scrum.restaurant.management.Comenzi;
import org.scrum.restaurant.management.StatusComanda;
import org.scrum.restaurant.management.MetodaPlata;
import org.scrum.restaurant.management.StatusPlata;
import org.scrum.restaurant.repo.ComenziRepository;
import org.scrum.restaurant.service.ComenziService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Folosește extensia Mockito
public class ComenziServiceTest {

    @Mock
    private ComenziRepository comenziRepository;

    @InjectMocks
    private ComenziService comenziService;

    private Comenzi comanda;

    @BeforeEach
    public void setUp() {
        comanda = new Comenzi(1, "Masa 1", new java.util.Date(),
                StatusComanda.IN_ASTEPTARE, MetodaPlata.CASH, StatusPlata.PLATITA, new BigDecimal("100.00"));
    }

    @Test
    public void testSaveComanda() {
        when(comenziRepository.save(any(Comenzi.class))).thenReturn(comanda);
        Comenzi savedComanda = comenziService.saveComanda(comanda);
        assertNotNull(savedComanda);
        assertEquals(comanda.getIdComanda(), savedComanda.getIdComanda());
        verify(comenziRepository, times(1)).save(comanda);
    }

    @Test
    public void testGetAllComenzi() {
        List<Comenzi> comenziList = Arrays.asList(comanda);
        when(comenziRepository.findAll()).thenReturn(comenziList);
        List<Comenzi> result = comenziService.getAllComenzi();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Masa 1", result.get(0).getNumarMasa());
        verify(comenziRepository, times(1)).findAll();
    }

    @Test
    public void testGetComandaById() {
        when(comenziRepository.findById(1)).thenReturn(Optional.of(comanda));
        Optional<Comenzi> result = comenziService.getComandaById(1);
        assertTrue(result.isPresent());
        assertEquals("Masa 1", result.get().getNumarMasa());
    }

    @Test
    public void testDeleteComanda() {
        doNothing().when(comenziRepository).deleteById(1);
        comenziService.deleteComanda(1);
        verify(comenziRepository, times(1)).deleteById(1);
    }
}
