package org.scrum.domain;
import jakarta.persistence.*;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Angajat {
    @EqualsAndHashCode.Include
    @Id @Min(1) @NotNull @GeneratedValue
    private Integer idAngajat;
    private String NumeAngajat;
    private String Telefon;
    private String Email;
    private String rolAngajat;

    @OneToMany(mappedBy = "angajat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rezervari> rezervariList;

    @OneToMany(mappedBy = "angajat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Preluare_Comenzi> preluariList;

    @OneToMany(mappedBy = "angajat", cascade = CascadeType.ALL)
    private List<ModificareMeniu> modificariList;

    public Angajat(Integer idAngajat, String numeAngajat, String telefon, String email,  String rolAngajat) {
        this.idAngajat = idAngajat;
        NumeAngajat = numeAngajat;
        Email = email;
        Telefon = telefon;
        rolAngajat = rolAngajat;
    }

    
}
