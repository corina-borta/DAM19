package org.scrum.restaurant.test_controller;

import org.junit.jupiter.api.Test;
import org.scrum.restaurant.persoane.Client;
import org.scrum.restaurant.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.scrum.restaurant.controller.ClientController;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClientController.class)
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;

    @Test
    public void testGetAllClienti() throws Exception {
        // Arrange
        when(clientService.getAllClienti()).thenReturn(Arrays.asList(
                new Client("Popescu", "0745123456", "popescu@example.com", true),
                new Client("Ionescu", "0731234567", "ionescu@example.com", false)
        ));

        // Act & Assert
        mockMvc.perform(get("/api/clienti"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].numeClient").value("Popescu"))
                .andExpect(jsonPath("$[1].email").value("ionescu@example.com"));
    }


    @Test
    public void testGetClientById() throws Exception {
        when(clientService.getClientById(1)).thenReturn(Optional.of(
                new Client("Popescu", "0723123456", "popescu@email.com", true)
        ));

        mockMvc.perform(get("/api/clienti/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.numeClient").value("Popescu"))
                .andExpect(jsonPath("$.telefon").value("0723123456"))
                .andExpect(jsonPath("$.email").value("popescu@email.com"))
                .andExpect(jsonPath("$.activ").value(true));
    }

    @Test
    public void testCreateClient() throws Exception {
        Client newClient = new Client("Popescu", "0723123456", "popescu@email.com", true);
        when(clientService.addClient(any(Client.class))).thenReturn(newClient);

        mockMvc.perform(post("/api/clienti")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"numeClient\":\"Popescu\",\"telefon\":\"0723123456\",\"email\":\"popescu@email.com\",\"activ\":true}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.numeClient").value("Popescu"))
                .andExpect(jsonPath("$.telefon").value("0723123456"))
                .andExpect(jsonPath("$.email").value("popescu@email.com"))
                .andExpect(jsonPath("$.activ").value(true));
    }

    @Test
    public void testDeleteClient() throws Exception {
        doNothing().when(clientService).deleteClient(1);

        mockMvc.perform(delete("/api/clienti/1"))
                .andExpect(status().isNoContent());
    }
}
