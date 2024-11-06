package org.scrum.meniu;

public class mancare {

    private int idMancare;        // ID-ul mâncării
    private String nume;          // Numele mâncării
    private String ingrediente;   // Ingrediente (de ex.: vegan/gluten-free)
    private double pret;          // Prețul mâncării

    public mancare(int idMancare, String nume, String ingrediente, double pret) {
        this.idMancare = idMancare;
        this.nume = nume;
        this.ingrediente = ingrediente;
        this.pret = pret;
    }

    public int getIdMancare() {
        return idMancare;
    }

    public void setIdMancare(int idMancare) {
        this.idMancare = idMancare;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    @Override
    public String toString() {
        return "mancare{" +
                "idMancare=" + idMancare +
                ", nume='" + nume + '\'' +
                ", ingrediente='" + ingrediente + '\'' +
                ", pret=" + pret +
                '}';
    }
}
