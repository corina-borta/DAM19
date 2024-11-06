package org.scrum.meniu;

public class desert {

    private int idDesert;         // ID-ul desertului
    private String nume;          // Numele desertului
    private String ingrediente;   // Ingrediente
    private double pret;          // Prețul desertului

    public desert(int idDesert, String nume, String ingrediente, double pret) {
        this.idDesert = idDesert;
        this.nume = nume;
        this.ingrediente = ingrediente;
        this.pret = pret;
    }

    public int getIdDesert() {
        return idDesert;
    }

    public void setIdDesert(int idDesert) {
        this.idDesert = idDesert;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "desert{" +
                "idDesert=" + idDesert +
                ", nume='" + nume + '\'' +
                ", ingrediente='" + ingrediente + '\'' +
                ", pret=" + pret +
                '}';
    }
}
