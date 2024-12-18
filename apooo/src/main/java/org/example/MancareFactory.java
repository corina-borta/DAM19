package org.example;

    public class MancareFactory extends PreparatFactory {
        @Override
        public Preparat creeazaPreparat(int cod, String denumire, double pret, String descriere) {
            return new Mancare(cod, denumire, pret, descriere);
        }
    }

