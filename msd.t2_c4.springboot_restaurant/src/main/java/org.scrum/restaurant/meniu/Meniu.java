package org.scrum.restaurant.meniu;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.scrum.restaurant.management.Comanda_Meniu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "meniu", orphanRemoval = true)
    private List<Preparat> preparate = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ModificareMeniu> modificariMeniu = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comanda_Meniu> comenziMeniu = new ArrayList<>();

    // Constructor cu parametri
    public Meniu(Integer idMeniu, String numeMeniu, List<Preparat> preparate,
                 List<ModificareMeniu> modificariMeniu, List<Comanda_Meniu> comenziMeniu) {
        this.idMeniu = idMeniu;
        this.numeMeniu = numeMeniu;
        this.preparate = preparate != null ? preparate : new ArrayList<>();
        this.modificariMeniu = modificariMeniu != null ? modificariMeniu : new ArrayList<>();
        this.comenziMeniu = comenziMeniu != null ? comenziMeniu : new ArrayList<>();
    }

    // Getter pentru idMeniu
    public Integer getIdMeniu() {
        return idMeniu;
    }

    // Metodă pentru adăugarea unui preparat în meniu
    public void adaugaPreparat(Preparat preparat) {
        if (!preparate.stream().anyMatch(p -> p.getIdPreparat().equals(preparat.getIdPreparat()))) {
            preparate.add(preparat);
        } else {
            System.out.println("Preparatul cu ID-ul " + preparat.getIdPreparat() + " deja există în meniu.");
        }
    }

    // Metodă pentru obținerea preparatelor pe baza tipului
    public List<Preparat> getPreparateByTip(TipPreparat tip) {
        return preparate.stream()
                .filter(preparat -> preparat.getTipPreparat() == tip)
                .collect(Collectors.toList());
    }

    // Getter explicit pentru preparate
    public List<Preparat> getPreparate() {
        return preparate;
    }

    // Getter explicit pentru numeMeniu
    public String getNumeMeniu() {
        return numeMeniu;
    }

    // Metodă toString îmbunătățită pentru afișare
    @Override
    public String toString() {
        return "Meniu{" +
                "idMeniu=" + idMeniu +
                ", numeMeniu='" + numeMeniu + '\'' +
                ", preparate=" + preparate.stream().map(Preparat::getNume).collect(Collectors.toList()) +
                ", modificariMeniu=" + modificariMeniu.size() + " modificări" +
                ", comenziMeniu=" + comenziMeniu.size() + " comenzi" +
                '}';
    }
}
