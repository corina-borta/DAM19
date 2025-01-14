package org.scrum.restaurant.meniu;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.scrum.restaurant.management.Comanda_Meniu;
import org.scrum.restaurant.meniu.Preparat;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Meniu {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMeniu;
@NotNull
    private String numeMeniu;

    @OneToMany(cascade = CascadeType.ALL,  mappedBy = "meniu")
    private List<Preparat> preparate= new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ModificareMeniu> modificariMeniu;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comanda_Meniu> comenziMeniu;

    public void adaugaPreparat(Preparat preparat) {
        if(!preparate.contains(preparat)){
        preparate.add(preparat);} else
        { System.out.println("Preparatul deja exista");}
    }

    public Meniu(Integer idMeniu, String numeMeniu, List<Preparat> preparate, List<ModificareMeniu> modificariMeniu, List<Comanda_Meniu> comenziMeniu) {
        this.idMeniu = idMeniu;
        this.numeMeniu = numeMeniu;
        this.preparate = preparate;
        this.modificariMeniu = modificariMeniu;
        this.comenziMeniu = comenziMeniu;
    }


    public List<Preparat> getPreparateByTip(TipPreparat tip) {
        List<Preparat> rezultate = new ArrayList<>();
        for (Preparat preparat : preparate) {
            if (preparat.getTipPreparat() == tip) {
                rezultate.add(preparat);
            }
        }
        return rezultate;
    }


    @Override
    public String toString() {
        return "Meniu{" +
                "idMeniu=" + idMeniu +
                ", numeMeniu='" + numeMeniu + '\'' +
                ", preparateList=" + preparate +
                ", modificariMeniu=" + modificariMeniu +
                ", comenziMeniu=" + comenziMeniu +
                '}';
    }
}
