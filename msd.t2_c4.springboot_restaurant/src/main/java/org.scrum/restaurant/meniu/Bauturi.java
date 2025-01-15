package org.scrum.restaurant.meniu;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "bauturi") // Opțional
public class Bauturi extends Preparat {
    @Min(0)
    private double volum;
    private boolean alcoolic;

    public Bauturi(Integer idPreparat, String nume, String ingrediente, double pret, TipPreparat tipPreparat, double volum, boolean alcoolic) {
        super(idPreparat, nume, ingrediente, pret, tipPreparat);
        this.volum = volum;
        this.alcoolic = alcoolic;
    }

    @Min(0)
    public double getVolum() {
        return volum;
    }

    public void setVolum(@Min(0) double volum) {
        this.volum = volum;
    }

    public boolean isAlcoolic() {
        return alcoolic;
    }

    public void setAlcoolic(boolean alcoolic) {
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

