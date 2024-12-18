package org.example;

public class Mancare implements Preparat {
    private int cod;
    private String denumire;
    private double pret;
    private String descriere;

    public Mancare(int cod, String denumire, double pret, String descriere) {
        this.cod = cod;
        this.denumire = denumire;
        this.pret = pret;
        this.descriere = descriere;
    }

    public String getDenumire() { return denumire; }
    public double getPret() { return pret; }
    public String getDescriere() { return descriere; }
}
