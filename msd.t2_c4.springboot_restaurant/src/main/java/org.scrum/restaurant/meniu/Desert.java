package org.scrum.restaurant.meniu;

import jakarta.persistence.Entity;
import org.scrum.restaurant.meniu.Preparat;

@Entity
public class Desert extends Preparat {

    public Desert(String nume, String ingrediente, double pret) {
        super(nume, ingrediente, pret);
    }

    @Override
    public String toString() {
        return "Desert{" + super.toString() + '}';
    }
}
