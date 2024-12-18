package org.scrum.restaurant.meniu;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import org.scrum.restaurant.meniu.Preparat;

@Entity
public class Bauturi extends Preparat {
    @Min(0)
    private double volum;
    private boolean alcoolic; // true dacă este băutură alcoolică

    public Bauturi(String nume, String ingrediente, double pret, double volum, boolean alcoolic) {
        super(nume, ingrediente, pret);
        this.volum = volum;
        this.alcoolic = alcoolic;
    }

    @Override
    public String toString() {
        return "Bauturi{" +
                super.toString() +
                ", volum=" + volum +
                ", alcoolic=" + alcoolic +
                '}';
    }
}
