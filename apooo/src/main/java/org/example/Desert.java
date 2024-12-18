package org.example;

public class Desert implements Preparat {
    private int cod;
    private String denumire;
    private double pret;
    private String descriere;

    public Desert(int cod, String denumire, double pret, String descriere) {
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
        return "Desert{" +
                "cod=" + cod +
                ", denumire='" + denumire + '\'' +
                ", pret=" + pret +
                ", descriere='" + descriere + '\'' +
                '}';
    }
}

