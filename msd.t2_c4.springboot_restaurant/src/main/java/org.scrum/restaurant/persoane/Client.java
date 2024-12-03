package org.scrum.restaurant.persoane;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

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

}
