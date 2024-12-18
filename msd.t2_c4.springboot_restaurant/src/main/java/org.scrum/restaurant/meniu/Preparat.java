package org.scrum.restaurant.meniu;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Preparat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPreparat;
    private String nume;
    private String ingrediente;
    @Min(1)
    private double pret;

    public Preparat(String nume, String ingrediente, double pret) {
        this.nume = nume;
        this.ingrediente = ingrediente;
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Preparate{" +
                "nume='" + nume + '\'' +
                ", ingrediente='" + ingrediente + '\'' +
                ", pret=" + pret +
                '}';
    }
}
