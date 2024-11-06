package org.scrum.meniu;

public class maniu {
    private int idMeniu;           // ID-ul meniului
    private String descriere;      // Descrierea meniului

    // Constructor
    public maniu(int idMeniu, String descriere) {
        this.idMeniu = idMeniu;
        this.descriere = descriere;
    }

    // Getters și Setters
    public int getIdMeniu() {
        return idMeniu;
    }

    public void setIdMeniu(int idMeniu) {
        this.idMeniu = idMeniu;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    @Override
    public String toString() {
        return "Meniu{" +
                "idMeniu=" + idMeniu +
                ", descriere='" + descriere + '\'' +
                '}';
    }

}
