package org.scrum.domain.comenzi;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;


@Data // Creează automat getter, setter, toString, equals și hashCode
    @NoArgsConstructor // Creează un constructor fără parametri
    // Specifică faptul că această clasă reprezintă o entitate în baza de date
    public class comenzi {

    private Integer idComanda;
    private Integer numarMasa;
    private Date dataComenzii;
    private StatusComanda status;
    private MetodaPlata metodaPlata;
    private StatusPlata statusPlata;
    private BigDecimal totalComanda;

    public comenzi(Integer idComanda, Integer numarMasa, Date dataComenzii, StatusComanda status,
                   MetodaPlata metodaPlata, StatusPlata statusPlata, BigDecimal totalComanda) {
        this.idComanda = idComanda;
        this.numarMasa = numarMasa;
        this.dataComenzii = dataComenzii;
        this.status = status;
        this.metodaPlata = metodaPlata;
        this.statusPlata = statusPlata;
        this.totalComanda = totalComanda;
    }

    public enum StatusComanda {
        IN_ASTEPTARE,
        PROCESATA,
        LIVRATA
    }

    public enum MetodaPlata {
        CASH,
        CARD,
        ONLINE
    }

    public enum StatusPlata {
        NEPLATITA,
        PLATITA,
        ANULATA
    }
    }


