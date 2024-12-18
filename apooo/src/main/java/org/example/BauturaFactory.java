package org.example;

public class BauturaFactory extends PreparatFactory {
    @Override
    public Preparat creeazaPreparat(int cod, String denumire, double pret, String descriere) {
        return new Bautura(cod, denumire, pret, descriere);
    }
}