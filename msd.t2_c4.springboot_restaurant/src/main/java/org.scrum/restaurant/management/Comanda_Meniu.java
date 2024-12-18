package org.scrum.restaurant.management;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scrum.restaurant.meniu.Meniu;
@Data
@Entity
@NoArgsConstructor
public class Comanda_Meniu {
    @Id @Min(1) @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Min(1)
    private Integer cantitate;

    @ManyToOne
    @JoinColumn(name = "idComanda", nullable = false)
    private Comenzi comanda;

    @ManyToOne
    @JoinColumn(name = "idMeniu", nullable = false)
    private Meniu meniu;



    public Comanda_Meniu(Integer id, Comenzi comanda, Meniu meniu, Integer cantitate) {
        this.id = id;
        this.comanda = comanda;
        this.meniu = meniu;
        this.cantitate = cantitate;
    }
}
