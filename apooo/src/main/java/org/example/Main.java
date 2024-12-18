package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Creăm un meniu pentru Mâncare
        Meniu meniuMancare = new Meniu(new Factory.MancareFactory());
        Preparat pizza = meniuMancare.adaugaPreparat(1, "Pizza Margherita", 30.0, "Pizza clasică cu brânză");

        // Creăm un meniu pentru Desert
        Meniu meniuDesert = new Meniu(new Factory.DesertFactory());
        Preparat tiramisu = meniuDesert.adaugaPreparat(2, "Tiramisu", 15.0, "Desert italian cu mascarpone");

        // Afisare detalii
        System.out.println("Preparat: " + pizza.getDenumire() + " - Pret: " + pizza.getPret());
        System.out.println("Preparat: " + tiramisu.getDenumire() + " - Pret: " + tiramisu.getPret());
    }
}