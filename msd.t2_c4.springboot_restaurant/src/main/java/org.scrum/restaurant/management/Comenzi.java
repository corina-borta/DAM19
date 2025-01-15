package org.scrum.restaurant.management;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Comenzi {
    @EqualsAndHashCode.Include
    @Id
    @Min(1)
    @NotNull
    @GeneratedValue
    private Integer idComanda;

    private String numarMasa;
    private Date dataComenzii;

    @Enumerated(EnumType.STRING)
    private StatusComanda status;

    @Enumerated(EnumType.STRING)
    private MetodaPlata metodaPlata;

    @Enumerated(EnumType.STRING)
    private StatusPlata statusPlata;

    private BigDecimal totalComanda;

    @OneToMany(mappedBy = "comanda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comanda_Meniu> cmd_meniuList;

    @OneToMany(mappedBy = "comanda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Preluare_Comenzi> preluariList;

    public Comenzi(Integer idComanda, String numarMasa, Date dataComenzii, StatusComanda status,
                   MetodaPlata metodaPlata, StatusPlata statusPlata, BigDecimal totalComanda) {
        this.idComanda = idComanda;
        this.numarMasa = numarMasa;
        this.dataComenzii = dataComenzii;
        this.status = status;
        this.metodaPlata = metodaPlata;
        this.statusPlata = statusPlata;
        this.totalComanda = totalComanda;
    }

    // Getter și Setter pentru MetodaPlata
    public MetodaPlata getMetodaPlata() {
        return metodaPlata;
    }

    public void setMetodaPlata(MetodaPlata metodaPlata) {
        this.metodaPlata = metodaPlata;
    }

    // Getter și Setter pentru StatusPlata
    public StatusPlata getStatusPlata() {
        return statusPlata;
    }

    public void setStatusPlata(StatusPlata statusPlata) {
        this.statusPlata = statusPlata;
    }

    // Getter și Setter pentru IdComanda (Adăugat)
    public Integer getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(Integer idComanda) {
        this.idComanda = idComanda;
    }
}


