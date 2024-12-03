package org.scrum.restaurant.meniu;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;

@Entity
public class Bauturi extends Meniu {
    private String nume;
    @Min(0)
    private double volum;
    private boolean tipBautura;// Tipul băuturii (de ex.: alcoolică sau non-alcoolică)
    @Min(1)
    private double pret;
    private String ingrediente;

    public Bauturi(int idMeniu, String descriere, String nume, double volum, boolean tipBautura, double pret, String ingrediente) {
        super(idMeniu, descriere);
        this.nume = nume;
        this.volum = volum;
        this.tipBautura = tipBautura;
        this.pret = pret;
        this.ingrediente = ingrediente;
    }


    @Override
    public String toString() {
        return "Bauturi{"  +
                ", nume='" + nume + '\'' +
                ", volum=" + volum +
                ", tipBautura=" + tipBautura +
                ", pret=" + pret +
                ", ingrediente='" + ingrediente + '\'' +
                '}';
    }

}
