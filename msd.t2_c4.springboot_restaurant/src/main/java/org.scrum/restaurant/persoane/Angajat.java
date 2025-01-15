package org.scrum.restaurant.persoane;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "angajati")
public class Angajat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAngajat;

    @Column(name = "nume_angajat", nullable = false)
    private String numeAngajat;

    @Column(name = "telefon", nullable = false)
    private String telefon;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "rol_angajat", nullable = false)
    private String rolAngajat;

    @Column(name = "salariu", nullable = false)
    private Double salariu;

    // Setter pentru idAngajat
    public void setIdAngajat(Integer idAngajat) {
        this.idAngajat = idAngajat;
    }
}
