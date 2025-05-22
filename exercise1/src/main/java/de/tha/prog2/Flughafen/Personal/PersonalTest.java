package de.tha.prog2.Flughafen.Personal;

public class PersonalTest {
    public static void main(String[] args) {
        // 1. Pilot Test
        Pilot pilot = new Pilot("Max", "Muster", Rang.CO_PILOT);
        pilot.befoerdern();
        pilot.befoerdern();
        System.out.println("Pilot Endgehalt: " + pilot.gehaltBerechnen() + " EUR");

        // 2. Flugbegleiter Test
        Flugbegleiter flugbegleiter = new Flugbegleiter("Anna", "Sauer");
        flugbegleiter.befoerdern();
        flugbegleiter.befoerdern();
        System.out.println("Flugbegleiter Endgehalt: " + flugbegleiter.gehaltBerechnen() + " EUR");

        // 3. Bodenpersonal Test
        Bodenpersonal bodenpersonal = new Bodenpersonal("Lukas", "Lieb", Abteilung.SICHERHEIT, 20);
        bodenpersonal.befoerdern();
        bodenpersonal.befoerdern();
        bodenpersonal.abteilungWechseln(Abteilung.TECHNIK);
        System.out.println("Bodenpersonal Endgehalt: " + bodenpersonal.gehaltBerechnen() + " EUR");

        // 4. Ergebnisüberprüfung
        System.out.println("\n========== ERGEBNISÜBERPRÜFUNG ==========\n");

        // Pilot Überprüfung
        boolean pilotKorrekt = Rang.CO_PILOT.getGrundgehalt() == 5000.0 &&
                Rang.FIRST_OFFICER.getGrundgehalt() == 7000.0 &&
                Rang.CAPTAIN.getGrundgehalt() == 9000.0;

        System.out.println("Pilot Gehälter: " + (pilotKorrekt ? "KORREKT ✓" : "NICHT KORREKT ✗"));
        System.out.println("  CO_PILOT:      " + Rang.CO_PILOT.getGrundgehalt() + " EUR (Soll: 5000 EUR)");
        System.out.println("  FIRST_OFFICER: " + Rang.FIRST_OFFICER.getGrundgehalt() + " EUR (Soll: 7000 EUR)");
        System.out.println("  CAPTAIN:       " + Rang.CAPTAIN.getGrundgehalt() + " EUR (Soll: 9000 EUR)\n");

        // Flugbegleiter Überprüfung
        Flugbegleiter testFB = new Flugbegleiter("Test", "Person");
        double fbStart = testFB.gehaltBerechnen();
        testFB.befoerdern();
        double fbNachBef = testFB.gehaltBerechnen();
        boolean fbGehaltKorrekt = Math.abs(fbStart - 3500.0) < 0.01;
        boolean fbErhoehungKorrekt = Math.abs((fbNachBef - fbStart) - (fbStart * 0.15)) < 0.01;
        boolean flugbegleiterKorrekt = fbGehaltKorrekt && fbErhoehungKorrekt && testFB.isLeiter;

        System.out.println("Flugbegleiter: " + (flugbegleiterKorrekt ? "KORREKT ✓" : "NICHT KORREKT ✗"));
        System.out.println("  Startgehalt:      " + fbStart + " EUR (Soll: 3500 EUR)");
        System.out.println("  Nach Beförderung: " + fbNachBef + " EUR (Soll: 4025 EUR)");
        System.out.println("  Status Leiter:    " + (testFB.isLeiter ? "Ja" : "Nein") + " (Soll: Ja)\n");

        // Bodenpersonal Überprüfung
        boolean abteilungKorrekt = Abteilung.SICHERHEIT.getGrundgehalt() == 3200.0 &&
                Abteilung.TECHNIK.getGrundgehalt() == 3500.0 &&
                Abteilung.GEPÄCKABFERRTIGUNG.getGrundgehalt() == 3000.0 &&
                Abteilung.CHECK_IN.getGrundgehalt() == 2800.0;

        System.out.println("Bodenpersonal Abteilungsgehälter: " + (abteilungKorrekt ? "KORREKT ✓" : "NICHT KORREKT ✗"));
        System.out.println("  SICHERHEIT:        " + Abteilung.SICHERHEIT.getGrundgehalt() + " EUR (Soll: 3200 EUR)");
        System.out.println("  TECHNIK:           " + Abteilung.TECHNIK.getGrundgehalt() + " EUR (Soll: 3500 EUR)");
        System.out.println("  GEPÄCKABFERTIGUNG: " + Abteilung.GEPÄCKABFERRTIGUNG.getGrundgehalt() + " EUR (Soll: 3000 EUR)");
        System.out.println("  CHECK_IN:          " + Abteilung.CHECK_IN.getGrundgehalt() + " EUR (Soll: 2800 EUR)\n");

        // Gesamtergebnis
        boolean alleKorrekt = pilotKorrekt && flugbegleiterKorrekt && abteilungKorrekt;

        System.out.println("========================================");
        System.out.println("GESAMTERGEBNIS: " + (alleKorrekt ? "KORREKT ✓" : "NICHT KORREKT ✗"));
        System.out.println("Die Implementierung " + (alleKorrekt ? "entspricht" : "entspricht nicht") + " der Aufgabenstellung.");
        System.out.println("========================================\n");
    }
}
