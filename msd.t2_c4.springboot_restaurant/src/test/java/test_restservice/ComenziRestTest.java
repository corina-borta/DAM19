package org.scrum.restaurant.test_restservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.scrum.restaurant.management.Comenzi;
import org.scrum.restaurant.repo.ComenziRepository;
import org.scrum.restaurant.controller.ComenziRest;
import org.scrum.restaurant.management.StatusComanda; // Import pentru StatusComanda
import org.scrum.restaurant.management.MetodaPlata; // Import pentru MetodaPlata
import org.scrum.restaurant.management.StatusPlata; // Import pentru StatusPlata
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.Date;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ComenziRestTest {

    @Mock
    private ComenziRepository comenziRepository; // Mock al repository-ului

    @InjectMocks
    private ComenziRest comenziRest; // Injectăm mock-ul în controller

    private MockMvc mockMvc; // Permite simularea cererilor HTTP

    private Comenzi comanda;

    @BeforeEach
    public void setUp() {
        // Inițializăm MockMvc
        mockMvc = MockMvcBuilders.standaloneSetup(comenziRest).build();

        // Inițializăm o comandă de test
        comanda = new Comenzi(1, "Masa 1", new Date(), StatusComanda.IN_ASTEPTARE,
                MetodaPlata.CASH, StatusPlata.PLATITA, new BigDecimal("100.00"));
    }

    @Test
    public void testCreateComanda() throws Exception {
        // Configurăm comportamentul mock-ului pentru salvarea unei comenzi
        when(comenziRepository.save(comanda)).thenReturn(comanda);

        // Simulăm un POST request pentru crearea unei comenzi
        mockMvc.perform(post("/comenzi")
                        .contentType("application/json")
                        .content("{\"idComanda\":1,\"numarMasa\":\"Masa 1\",\"dataComenzii\":\"2025-01-11T00:00:00.000+00:00\",\"status\":\"IN_ASTEPTARE\",\"metodaPlata\":\"CASH\",\"statusPlata\":\"PLATITA\",\"totalComanda\":100.00}"))
                .andExpect(status().isOk()); // Verificăm că răspunsul este 200 OK

        // Verificăm că save a fost apelat o dată
        verify(comenziRepository, times(1)).save(comanda);
    }
}
