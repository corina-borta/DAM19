package org.scrum.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@Entity
public class Rezervari {
    @EqualsAndHashCode.Include
    @Id @Min(1) @NotNull
    @GeneratedValue
    private Integer idRezervare;
    private String numeClient;
    @Min(1)
    private Integer numarPersoane;
    private Date dataRezervare;
    private StatusRezervare statusRezervare;
    private TipMasa tipMasa;

    @ManyToOne
    @JoinColumn(name = "idAngajat", nullable = false)
    private Angajat angajat;

    @ManyToOne
    @JoinColumn(name = "idClient", nullable = false)
    private Client client;

    public Rezervari(Integer idRezervare, String numeClient, Integer numarPersoane, Date dataRezervare, StatusRezervare statusRezervare, TipMasa tipMasa, Angajat angajat) {
        this.idRezervare = idRezervare;
        this.numeClient = numeClient;
        this.numarPersoane = numarPersoane;
        this.dataRezervare = dataRezervare;
        this.statusRezervare = statusRezervare;
        this.tipMasa = tipMasa;
        this.angajat = angajat;
    }
}
