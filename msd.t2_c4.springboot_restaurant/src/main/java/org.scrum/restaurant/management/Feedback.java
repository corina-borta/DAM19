package org.scrum.restaurant.management;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.scrum.restaurant.persoane.Client;

@Data
@NoArgsConstructor
@Entity
public class Feedback {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFeedback;

    private String textFeedback;

    @Min(1)
    private Integer rating;

    private String nivelSatisfactie; // Adăugată proprietatea nivelSatisfactie

    @ManyToOne
    @JoinColumn(name = "idClient", nullable = false)
    private Client client;

    // Getter și Setter pentru textFeedback
    public String getTextFeedback() {
        return textFeedback;
    }

    public void setTextFeedback(String textFeedback) {
        this.textFeedback = textFeedback;
    }

    // Getter și Setter pentru rating
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    // Getter și Setter pentru nivelSatisfactie
    public String getNivelSatisfactie() {
        return nivelSatisfactie;
    }

    public void setNivelSatisfactie(String nivelSatisfactie) {
        this.nivelSatisfactie = nivelSatisfactie;
    }

    // Getter și Setter pentru client
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
