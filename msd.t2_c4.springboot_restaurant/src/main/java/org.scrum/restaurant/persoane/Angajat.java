package org.scrum.restaurant.persoane;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "angajati") // Numele tabelului din baza de date
public class Angajat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generare automată a ID-ului
    private Integer idAngajat;

    @Column(name = "nume_angajat", nullable = false) // Coloana numeAngajat în DB
    private String numeAngajat;

    @Column(name = "telefon", nullable = false) // Coloana telefon în DB
    private String telefon;

    @Column(name = "email", nullable = false, unique = true) // Coloana email în DB
    private String email;

    @Column(name = "rol_angajat", nullable = false) // Coloana rolAngajat în DB
    private String rolAngajat;

    @Column(name = "salariu", nullable = false) // Coloana salariu în DB
    private Double salariu;

    // Constructor fără ID (pentru crearea de obiecte noi)
    public Angajat(String numeAngajat, String telefon, String email, String rolAngajat, Double salariu) {
        this.numeAngajat = numeAngajat;
        this.telefon = telefon;
        this.email = email;
        this.rolAngajat = rolAngajat;
        this.salariu = salariu;
    }

    // Getteri și setteri dacă vrei să le adaugi explicit (opțional):
    public Integer getIdAngajat() {
        return idAngajat;
    }

    public void setIdAngajat(Integer idAngajat) {
        this.idAngajat = idAngajat;
    }

    public String getNumeAngajat() {
        return numeAngajat;
    }

    public void setNumeAngajat(String numeAngajat) {
        this.numeAngajat = numeAngajat;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRolAngajat() {
        return rolAngajat;
    }

    public void setRolAngajat(String rolAngajat) {
        this.rolAngajat = rolAngajat;
    }

    public Double getSalariu() {
        return salariu;
    }

    public void setSalariu(Double salariu) {
        this.salariu = salariu;
    }
}

