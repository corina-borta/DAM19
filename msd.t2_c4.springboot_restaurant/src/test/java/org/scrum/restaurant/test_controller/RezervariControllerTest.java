package org.scrum.restaurant.test_controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.scrum.restaurant.controller.RezervariController;
import org.scrum.restaurant.management.Rezervari;
import org.scrum.restaurant.service.RezervariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RezervariController.class)
public class RezervariControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RezervariService rezervariService;

    @Test
    public void testGetAllRezervari() throws Exception {
        when(rezervariService.getAllRezervari()).thenReturn(Arrays.asList(
                new Rezervari(1, "Popescu", 2, null, null, null, null),
                new Rezervari(2, "Ionescu", 4, null, null, null, null)
        ));

        mockMvc.perform(get("/api/rezervari"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idRezervare").value(1))
                .andExpect(jsonPath("$[1].numeClient").value("Ionescu"));
    }

    @Test
    public void testGetRezervareById() throws Exception {
        when(rezervariService.getRezervareById(1)).thenReturn(Optional.of(
                new Rezervari(1, "Popescu", 2, null, null, null, null)
        ));

        mockMvc.perform(get("/api/rezervari/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.numeClient").value("Popescu"));
    }

    @Test
    public void testCreateRezervare() throws Exception {
        Rezervari rezervare = new Rezervari(1, "Popescu", 2, null, null, null, null);
        when(rezervariService.addRezervare(Mockito.any(Rezervari.class))).thenReturn(rezervare);

        mockMvc.perform(post("/api/rezervari")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"numeClient\":\"Popescu\",\"numarPersoane\":2}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.numeClient").value("Popescu"));
    }

    @Test
    public void testDeleteRezervare() throws Exception {
        doNothing().when(rezervariService).deleteRezervare(1);

        mockMvc.perform(delete("/api/rezervari/1"))
                .andExpect(status().isNoContent());
    }
}
