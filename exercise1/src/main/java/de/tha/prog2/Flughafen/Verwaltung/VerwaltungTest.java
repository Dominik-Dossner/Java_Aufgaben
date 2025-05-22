package de.tha.prog2.Flughafen.Verwaltung;

import de.tha.prog2.Flughafen.Personal.*;

public class VerwaltungTest {
    public static void main(String[] args) {
        // Todo: Code zum Testen von Aufgabe 2

        PersonalListe liste = new PersonalListe();

        Pilot pilot = new Pilot("Max", "Muster", Rang.CO_PILOT);
        Flugbegleiter flugbegleiter = new Flugbegleiter("Anna", "Beispiel");
        Bodenpersonal bodenpersonal = new Bodenpersonal("Lukas", "Test", Abteilung.SICHERHEIT, 20);

        liste.hinzufuegen(pilot);
        liste.hinzufuegen(flugbegleiter);
        liste.hinzufuegen(bodenpersonal);

        System.out.println("Liste nach Hinzufügen:");
        System.out.println(liste);

        pilot.befoerdern();
        flugbegleiter.befoerdern();
        bodenpersonal.befoerdern();

        System.out.println("\nListe nach Beförderungen:");
        System.out.println(liste);

        liste.entfernen(flugbegleiter.getPersNr());

        System.out.println("Liste nach Entfernen eines Eintrags:");
        System.out.println(liste);

        liste.listPilots();

         //
    }
}