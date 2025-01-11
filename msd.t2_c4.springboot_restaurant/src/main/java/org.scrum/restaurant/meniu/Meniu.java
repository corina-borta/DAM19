package org.scrum.restaurant.meniu;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.scrum.restaurant.management.Comanda_Meniu;
import org.scrum.restaurant.meniu.Preparat;

import java.util.List;

@Data
@Entity
public class Meniu {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMeniu;

    private String descriere;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Preparat> preparateList;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ModificareMeniu> modificariMeniu;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comanda_Meniu> comenziMeniu;

    public Meniu(String descriere, List<Preparat> preparateList) {
        this.descriere = descriere;
        this.preparateList = preparateList;
    }

    @Override
    public String toString() {
        return "Meniu{" +
                "idMeniu=" + idMeniu +
                ", descriere='" + descriere + '\'' +
                ", preparateList=" + preparateList +
                ", modificariMeniu=" + modificariMeniu +
                ", comenziMeniu=" + comenziMeniu +
                '}';
    }
}
