package org.scrum.restaurant.meniu;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Preparat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPreparat;

    @NotNull
    @Size(min = 2, message = "Numele preparatului trebuie să aibă cel puțin 2 caractere.")
    private String nume;

    @NotNull
    @Size(min = 5, message = "Ingredientele trebuie să aibă cel puțin 5 caractere.")
    private String ingrediente;

    @Min(value = 1, message = "Prețul trebuie să fie cel puțin 1.")
    private double pret;

    @Enumerated(EnumType.STRING)
    private TipPreparat tipPreparat;

    @ManyToOne
    @JoinColumn(name = "id_meniu", nullable = false)
    private Meniu meniu;

    public Preparat(Integer idPreparat, String nume, String ingrediente, double pret, TipPreparat tipPreparat) {
        this.idPreparat = idPreparat;
        this.nume = nume;
        this.ingrediente = ingrediente;
        this.pret = pret;
        this.tipPreparat = tipPreparat;
    }

    @Override
    public String toString() {
        return "Preparat{" +
                "idPreparat=" + idPreparat +
                ", nume='" + nume + '\'' +
                ", ingrediente='" + ingrediente + '\'' +
                ", pret=" + pret +
                ", tipPreparat=" + tipPreparat +
                ", meniuId=" + (meniu != null ? meniu.getIdMeniu() : "null") +
                '}';
    }

    // Getteri și setteri
    public Integer getIdPreparat() {
        return idPreparat;
    }

    public void setIdPreparat(Integer idPreparat) {
        this.idPreparat = idPreparat;
    }

    public @NotNull String getNume() {
        return nume;
    }

    public void setNume(@NotNull String nume) {
        this.nume = nume;
    }

    public @NotNull String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(@NotNull String ingrediente) {
        this.ingrediente = ingrediente;
    }

    @Min(1)
    public double getPret() {
        return pret;
    }

    public void setPret(@Min(1) double pret) {
        this.pret = pret;
    }

    public TipPreparat getTipPreparat() {
        return tipPreparat;
    }

    public void setTipPreparat(TipPreparat tipPreparat) {
        this.tipPreparat = tipPreparat;
    }

    public Meniu getMeniu() {
        return meniu;
    }

    public void setMeniu(Meniu meniu) {
        this.meniu = meniu;
    }
}
