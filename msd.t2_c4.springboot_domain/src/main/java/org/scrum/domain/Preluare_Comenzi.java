package org.scrum.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@NoArgsConstructor
@Data
public class Preluare_Comenzi {
    @Id  @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime oraPreluarii;
    @ManyToOne
    @JoinColumn(name = "idAngajat", nullable = false)
    private Angajat angajat;

    @ManyToOne
    @JoinColumn(name = "idClient", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "idComanda", nullable = false)
    private Comenzi comanda;


    public Preluare_Comenzi(Long id, Angajat angajat, Client client, Comenzi comanda, LocalDateTime oraPreluarii) {
        this.id = id;
        this.angajat = angajat;
        this.client = client;
        this.comanda = comanda;
        this.oraPreluarii = oraPreluarii;
    }
}
