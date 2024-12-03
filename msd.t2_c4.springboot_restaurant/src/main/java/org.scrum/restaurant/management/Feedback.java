package org.scrum.restaurant.management;

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
    @Id @Min(1) @NotNull
    @GeneratedValue
    private Integer idFeedback;
    private String textFeedback;
    private Integer rating;

    public enum TipFeedback {
        SERVICIU,
        CALITATE_PRODUS
    }

    public enum NivelSatisfactie {
        FOARTE_SLAB,
        SLAB,
        MEDIU,
        BUN,
        EXCELENT
    }

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
