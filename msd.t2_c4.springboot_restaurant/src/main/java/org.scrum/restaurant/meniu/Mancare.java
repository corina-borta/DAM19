package org.scrum.restaurant.meniu;

import jakarta.persistence.Entity;
import org.scrum.restaurant.meniu.Preparat;

@Entity
public class Mancare extends Preparat {


    public Mancare(String nume, String ingrediente, double pret) {
        super(nume, ingrediente, pret);
    }

    @Override
    public String toString() {
        return "Mancare{}";
    }


}
