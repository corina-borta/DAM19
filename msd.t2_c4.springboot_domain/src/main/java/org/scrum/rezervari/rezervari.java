package org.scrum.rezervari;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
public class rezervari {
    private Integer idRezervare;
    private String numeClient;
    private Integer numarPersoane;
    private Date dataRezervare;
    private StatusRezervare statusRezervare;
    private TipMasa tipMasa;

    public rezervari(Integer idRezervare, String numeClient, Integer numarPersoane, Date dataRezervare, StatusRezervare statusRezervare, TipMasa tipMasa) {
        this.idRezervare = idRezervare;
        this.numeClient = numeClient;
        this.numarPersoane = numarPersoane;
        this.dataRezervare = dataRezervare;
        this.statusRezervare = statusRezervare;
        this.tipMasa = tipMasa;
    }

    // Enum pentru statusul rezervării
    public enum StatusRezervare {
        CONFIRMATA,
        IN_ASTEPTARE,
        ANULATA
    }

    // Enum pentru tipul mesei rezervate
    public enum TipMasa {
        INTERIOR,
        EXTERIOR,
        VIP
    }
}
