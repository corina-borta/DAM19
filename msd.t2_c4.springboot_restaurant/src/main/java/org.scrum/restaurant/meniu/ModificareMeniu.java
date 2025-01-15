package org.scrum.restaurant.meniu;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scrum.restaurant.persoane.Angajat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class ModificareMeniu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private LocalDateTime dataModificarii;

    @NotNull
    private String descriereModificare;

    @ManyToOne
    @JoinColumn(name = "angajat_id", nullable = false)
    private Angajat angajat;

    @ManyToOne
    @JoinColumn(name = "meniu_id", nullable = false)
    private Meniu meniu;

    // Constructor complet pentru utilizare în servicii și alte componente
    public ModificareMeniu(Angajat angajat, Meniu meniu, LocalDateTime dataModificarii, String descriereModificare) {
        this.angajat = angajat;
        this.meniu = meniu;
        this.dataModificarii = dataModificarii;
        this.descriereModificare = descriereModificare;
    }
}

