package org.scrum.meniu;

public class bauturi {
    private int idBautura;            // ID-ul băuturii
    private String nume;              // Numele băuturii
    private double volum;             // Volumul băuturii în litri
    private boolean tipBautura;       // Tipul băuturii (de ex.: alcoolică sau non-alcoolică)
    private double pret;              // Prețul băuturii
    private String descriere;         // Descrierea băuturii

    public bauturi(int idBautura, String nume, double volum, boolean tipBautura, double pret, String descriere) {
        this.idBautura = idBautura;
        this.nume = nume;
        this.volum = volum;
        this.tipBautura = tipBautura;
        this.pret = pret;
        this.descriere = descriere;
    }

    public int getIdBautura() {
        return idBautura;
    }

    public void setIdBautura(int idBautura) {
        this.idBautura = idBautura;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getVolum() {
        return volum;
    }

    public void setVolum(double volum) {
        this.volum = volum;
    }

    public boolean isTipBautura() {
        return tipBautura;
    }

    public void setTipBautura(boolean tipBautura) {
        this.tipBautura = tipBautura;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
    @Override
    public String toString() {
        return "Bauturi{" +
                "idBautura=" + idBautura +
                ", nume='" + nume + '\'' +
                ", volum=" + volum +
                ", tipBautura=" + tipBautura +
                ", pret=" + pret +
                ", descriere='" + descriere + '\'' +
                '}';
    }

}
