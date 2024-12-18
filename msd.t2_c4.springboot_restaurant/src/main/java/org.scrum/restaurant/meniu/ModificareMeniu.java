package org.scrum.restaurant.meniu;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scrum.restaurant.persoane.Angajat;

import java.time.LocalDateTime;
@Entity
@NoArgsConstructor
@Data
public class ModificareMeniu {
    @Id @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataModificarii;
    private String descriereModificare;

    @ManyToOne
    @JoinColumn(name = "angajat_id", nullable = false)
    private Angajat angajat;

    @ManyToOne
    @JoinColumn(name = "meniu_id", nullable = false)
    private Meniu meniu;



    public ModificareMeniu(Angajat angajat, Meniu meniu, LocalDateTime dataModificarii, String descriereModificare) {
        this.angajat = angajat;
        this.meniu = meniu;
        this.dataModificarii = dataModificarii;
        this.descriereModificare = descriereModificare;
    }
}
