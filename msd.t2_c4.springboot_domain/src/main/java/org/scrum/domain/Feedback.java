package org.scrum.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Feedback {
    @EqualsAndHashCode.Include
    @Id @NotNull
    @GeneratedValue
    private Integer idFeedback;
    private String textFeedback;
    private Integer rating;
    private TipFeedback tipFeedback;
    private NivelSatisfactie nivelSatisfactie;

    @ManyToOne
    @JoinColumn(name = "idClient", nullable = false)
    private Client client;

    public Feedback(Integer idFeedback, String textFeedback, Integer rating, TipFeedback tipFeedback, NivelSatisfactie nivelSatisfactie) {
        this.idFeedback = idFeedback;
        this.textFeedback = textFeedback;
        this.rating = rating;
        this.tipFeedback = tipFeedback;
        this.nivelSatisfactie = nivelSatisfactie;
    }


}
