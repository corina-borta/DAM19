package org.scrum.feedback;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class feedback {
    private Integer idFeedback;
    private String textFeedback;
    private Integer rating;
    private TipFeedback tipFeedback;
    private NivelSatisfactie nivelSatisfactie;

    public feedback(Integer idFeedback, String textFeedback, Integer rating, TipFeedback tipFeedback, NivelSatisfactie nivelSatisfactie) {
        this.idFeedback = idFeedback;
        this.textFeedback = textFeedback;
        this.rating = rating;
        this.tipFeedback = tipFeedback;
        this.nivelSatisfactie = nivelSatisfactie;
    }

    // Enum pentru tipurile de feedback clasifică feedback-ul în funcție de ce aspect al experienței este evaluat
    public enum TipFeedback {
        SERVICIU,
        CALITATE_PRODUS,
        TIMP_LIVRARE,
        ALTELE
    }

    // Enum pentru nivelul de satisfacție generală exprimat de client:
    public enum NivelSatisfactie {
        FOARTE_SLAB,
        SLAB,
        MEDIU,
        BUN,
        EXCELENT
    }
}
