package org.scrum.angajat;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class angajat {

    private Integer IDAngajat;
    private String NumeAngajat;
    private Integer Telefon;
    private String Email;
    private Boolean RolAngajat;

    public angajat(Integer IDAngajat, String numeAngajat, String email, Integer telefon, Boolean rolAngajat) {
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

    public Boolean getRolAngajat() {
        return RolAngajat;
    }

    public void setRolAngajat(Boolean rolAngajat) {
        RolAngajat = rolAngajat;
    }
}
