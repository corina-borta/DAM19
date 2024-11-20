package org.scrum.meniu;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.scrum.domain.Comanda_Meniu;
import org.scrum.domain.Comenzi;
import org.scrum.domain.ModificareMeniu;

import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Meniu {
    @EqualsAndHashCode.Include
    @Id @Min(1)
    @GeneratedValue
    private int idMeniu;
    private String descriere;

    @OneToMany(mappedBy = "meniu", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comanda_Meniu> cmd_meniuList;

    @OneToMany(mappedBy = "meniu", cascade = CascadeType.ALL)
    private List<ModificareMeniu> modificariList;

    // Constructor
    public Meniu(int idMeniu, String descriere) {
        this.idMeniu = idMeniu;
        this.descriere = descriere;
    }

    @Override
    public String toString() {
        return "Meniu{" +
                "idMeniu=" + idMeniu +
                ", descriere='" + descriere + '\'' +
                '}';
    }

}
