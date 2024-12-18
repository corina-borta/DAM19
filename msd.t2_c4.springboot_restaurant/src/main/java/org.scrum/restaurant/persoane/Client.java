package org.scrum.restaurant.persoane;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.scrum.restaurant.management.Feedback;
import org.scrum.restaurant.management.Preluare_Comenzi;
import org.scrum.restaurant.management.Rezervari;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@Entity
public class Client {
@EqualsAndHashCode.Include
@Id @Min(1) @NotNull @GeneratedValue
   private Integer idClient;
   private String NumeClient;
   private  String Telefon;
   private String Email;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Feedback> feedbackList;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rezervari> rezervariList;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Preluare_Comenzi> preluariList;

   public Client(Integer idClient, String numeClient, String telefon, String email) {
        this.idClient = idClient;
        this.NumeClient = NumeClient;
        this.Telefon = Telefon;
        this.Email = Email;
    }

    public @Min(1) @NotNull Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(@Min(1) @NotNull Integer idClient) {
        this.idClient = idClient;
    }

    public String getNumeClient() {
        return NumeClient;
    }

    public void setNumeClient(String numeClient) {
        NumeClient = numeClient;
    }

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String telefon) {
        Telefon = telefon;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
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
