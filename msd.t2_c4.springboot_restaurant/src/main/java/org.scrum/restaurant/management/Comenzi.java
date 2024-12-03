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


@Data // Creează automat getter, setter, toString, equals și hashCode
    @NoArgsConstructor // Creează un constructor fără parametri
   @Entity // Specifică faptul că această clasă reprezintă o entitate în baza de date
    public class Comenzi {
    @EqualsAndHashCode.Include
    @Id @Min(1)  @NotNull
    @GeneratedValue
    private Integer idComanda;
    private String numarMasa;
    private Date dataComenzii;
    private StatusComanda status;
    private MetodaPlata metodaPlata;
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

    public MetodaPlata getMetodaPlata() {
        return metodaPlata;
    }

    public void setMetodaPlata(MetodaPlata metodaPlata) {
        this.metodaPlata = metodaPlata;
    }

    public StatusPlata getStatusPlata() {
        return statusPlata;
    }

    public void setStatusPlata(StatusPlata statusPlata) {
        this.statusPlata = statusPlata;
    }
}


