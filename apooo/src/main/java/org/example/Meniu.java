package org.example;

public class Meniu {
    private PreparatFactory factory;

    public Meniu(PreparatFactory factory) {
        this.factory = factory;
    }

    public Preparat adaugaPreparat(int cod, String denumire, double pret, String descriere) {
        return factory.creeazaPreparat(cod, denumire, pret, descriere);
    }
}

