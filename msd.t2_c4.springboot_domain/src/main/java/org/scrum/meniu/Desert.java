package org.scrum.meniu;


import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Entity
public class Desert extends Meniu {

    private String nume;
    private String ingrediente;
    @Min(1)// Ingrediente
    private double pret;

    public Desert(int idMeniu, String descriere,  String nume, String ingrediente, double pret) {
        super(idMeniu, descriere);
        this.nume = nume;
        this.ingrediente = ingrediente;
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "desert{" +
                ", nume='" + nume + '\'' +
                ", ingrediente='" + ingrediente + '\'' +
                ", pret=" + pret +
                '}';
    }
}
