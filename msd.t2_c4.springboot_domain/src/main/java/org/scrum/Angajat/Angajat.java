package org.scrum.Angajat;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Angajat {

    private Integer IDAngajat;
    private String NumeAngajat;
    private Integer Telefon;
    private String Email;
    private String RolAngajat;

    public Angajat(Integer IDAngajat, String numeAngajat, Integer telefon, String email,  String rolAngajat) {
        this.IDAngajat = IDAngajat;
        NumeAngajat = numeAngajat;
        Email = email;
        Telefon = telefon;
        RolAngajat = rolAngajat;
    }

    public Integer getIDAngajat() {
        return IDAngajat;
    }

    public void setIDAngajat(Integer IDAngajat) {
        this.IDAngajat = IDAngajat;
    }

    public String getNumeAngajat() {
        return NumeAngajat;
    }

    public void setNumeAngajat(String numeAngajat) {
        NumeAngajat = numeAngajat;
    }

    public Integer getTelefon() {
        return Telefon;
    }

    public void setTelefon(Integer telefon) {
        Telefon = telefon;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getRolAngajat() {
        return RolAngajat;
    }

    public void setRolAngajat(String rolAngajat) {
        RolAngajat = rolAngajat;
    }
}
