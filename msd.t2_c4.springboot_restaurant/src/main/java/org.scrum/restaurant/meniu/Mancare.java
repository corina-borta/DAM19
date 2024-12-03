package org.scrum.restaurant.meniu;


import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Entity
public class Mancare extends Meniu{

    private String nume;
    private String ingrediente;
    @Min(1)
    private double pret;

    public Mancare(int idMeniu, String descriere,  String nume, String ingrediente, double pret) {
        super(idMeniu, descriere);

        this.nume = nume;
        this.ingrediente = ingrediente;
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "mancare{" +
                ", nume='" + nume + '\'' +
                ", ingrediente='" + ingrediente + '\'' +
                ", pret=" + pret +
                '}';
    }
}
