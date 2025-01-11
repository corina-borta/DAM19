package org.scrum.restaurant.persoane;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import org.scrum.restaurant.management.Feedback;
import org.scrum.restaurant.management.Preluare_Comenzi;
import org.scrum.restaurant.management.Rezervari;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clienti") // Specificăm numele tabelului în baza de date
public class Client {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;

    private String numeClient;
    private String telefon;
    private String email;

    @Column(nullable = false)
    private boolean activ; // Adăugăm atributul activ pentru clienți

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Feedback> feedbackList;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rezervari> rezervariList;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Preluare_Comenzi> preluariList;

    // Constructor suplimentar pentru inițializare mai ușoară
    public Client(String numeClient, String telefon, String email, boolean activ) {
        this.numeClient = numeClient;
        this.telefon = telefon;
        this.email = email;
        this.activ = activ;
    }

    // Constructor complet cu idClient
    public Client(Integer idClient, String numeClient, String telefon, String email, boolean activ) {
        this.idClient = idClient;
        this.numeClient = numeClient;
        this.telefon = telefon;
        this.email = email;
        this.activ = activ;
    }

    // Metode de acces (getters și setters) pentru compatibilitate manuală
    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    // Metodă `setId` pentru compatibilitate cu testele și controller-ul
    public void setId(Integer idClient) {
        this.idClient = idClient;
    }

    public String getNumeClient() {
        return numeClient;
    }

    public void setNumeClient(String numeClient) {
        this.numeClient = numeClient;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActiv() {
        return activ;
    }

    public void setActiv(boolean activ) {
        this.activ = activ;
    }

    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    public List<Rezervari> getRezervariList() {
        return rezervariList;
    }

    public void setRezervariList(List<Rezervari> rezervariList) {
        this.rezervariList = rezervariList;
    }

    public List<Preluare_Comenzi> getPreluariList() {
        return preluariList;
    }

    public void setPreluariList(List<Preluare_Comenzi> preluariList) {
        this.preluariList = preluariList;
    }
}
