package org.scrum.restaurant.test_controller;

import org.junit.jupiter.api.Test;
import org.scrum.restaurant.persoane.Angajat;
import org.scrum.restaurant.service.AngajatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.scrum.restaurant.controller.AngajatController;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AngajatController.class)
public class AngajatControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AngajatService angajatService;

    @Test
    public void testGetAllAngajati() throws Exception {
        // Arrange
        when(angajatService.getAllAngajati()).thenReturn(Arrays.asList(
                new Angajat(1, "Popescu", "0745123456", "popescu@email.com", "Bucatar", 3500.0),
                new Angajat(2, "Ionescu", "0734456789", "ionescu@email.com", "Chelner", 2500.0)
        ));

        // Act & Assert
        mockMvc.perform(get("/api/angajati"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].numeAngajat").value("Popescu"))
                .andExpect(jsonPath("$[1].numeAngajat").value("Ionescu"));
    }

    @Test
    public void testGetAngajatById() throws Exception {
        // Arrange
        when(angajatService.getAngajatById(1)).thenReturn(Optional.of(new Angajat(1, "Popescu", "0745123456", "popescu@email.com", "Bucatar", 3500.0)));

        // Act & Assert
        mockMvc.perform(get("/api/angajati/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.numeAngajat").value("Popescu"))
                .andExpect(jsonPath("$.rolAngajat").value("Bucatar"))
                .andExpect(jsonPath("$.salariu").value(3500.0));
    }

    @Test
    public void testCreateAngajat() throws Exception {
        // Arrange
        Angajat newAngajat = new Angajat(null, "Popescu", "0745123456", "popescu@email.com", "Manager", 4500.0);
        when(angajatService.addAngajat(any(Angajat.class))).thenReturn(newAngajat);

        // Act & Assert
        mockMvc.perform(post("/api/angajati")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"numeAngajat\":\"Popescu\",\"telefon\":\"0745123456\",\"email\":\"popescu@email.com\",\"rolAngajat\":\"Manager\",\"salariu\":4500.0}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.numeAngajat").value("Popescu"))
                .andExpect(jsonPath("$.rolAngajat").value("Manager"))
                .andExpect(jsonPath("$.salariu").value(4500.0));
    }

    @Test
    public void testUpdateAngajat() throws Exception {
        // Arrange
        Angajat updatedAngajat = new Angajat(1, "Popescu", "0745123456", "popescu@email.com", "Director", 5000.0);
        when(angajatService.updateAngajat(any(Angajat.class))).thenReturn(updatedAngajat);

        // Act & Assert
        mockMvc.perform(put("/api/angajati/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"numeAngajat\":\"Popescu\",\"telefon\":\"0745123456\",\"email\":\"popescu@email.com\",\"rolAngajat\":\"Director\",\"salariu\":5000.0}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.rolAngajat").value("Director"))
                .andExpect(jsonPath("$.salariu").value(5000.0));
    }

    @Test
    public void testDeleteAngajat() throws Exception {
        // Arrange
        doNothing().when(angajatService).deleteAngajat(1);

        // Act & Assert
        mockMvc.perform(delete("/api/angajati/1"))
                .andExpect(status().isNoContent());
    }
}

