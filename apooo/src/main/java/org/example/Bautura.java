package org.example;

public class Bautura implements Preparat {
    private int cod;
    private String denumire;
    private double pret;
    private String descriere;

    public Bautura(int cod, String denumire, double pret, String descriere) {
        this.cod = cod;
        this.denumire = denumire;
        this.pret = pret;
        this.descriere = descriere;
    }

    @Override
    public String getDenumire() {
        return denumire;
    }

    @Override
    public double getPret() {
        return pret;
    }

    @Override
    public String getDescriere() {
        return descriere;
    }

    @Override
    public String toString() {
        return "Bautura{" +
                "cod=" + cod +
                ", denumire='" + denumire + '\'' +
                ", pret=" + pret +
                ", descriere='" + descriere + '\'' +
                '}';
    }
}

