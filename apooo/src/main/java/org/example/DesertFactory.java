package org.example;

public class DesertFactory extends PreparatFactory {
    @Override
    public Preparat creeazaPreparat(int cod, String denumire, double pret, String descriere) {
        return new Desert(cod, denumire, pret, descriere);
    }
}
