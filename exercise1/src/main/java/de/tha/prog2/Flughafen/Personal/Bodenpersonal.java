package de.tha.prog2.Flughafen.Personal;

public class Bodenpersonal extends Personal{
    private int stufe = 0;
    private Abteilung abteilung;
    private int ueberstunden;

    public Bodenpersonal(String vorname, String name, Abteilung abteilung, int ueberstunden) {
        super(vorname, name, abteilung.getGrundgehalt());
        this.abteilung = abteilung;
        this.ueberstunden = ueberstunden;
    }

    public double gehaltBerechnen() {
        double stundenlohn = grundgehalt / 160;
        double überstunden = stundenlohn * ueberstunden;
        double gehalt = grundgehalt * (1 + 0.05 * stufe);
        return gehalt + überstunden;
    }

    public void abteilungWechseln(Abteilung abteilung) {
        this.abteilung = abteilung;
        grundgehalt = abteilung.getGrundgehalt();
        this.stufe = 0;
    }
    @Override
    public void befoerdern() {
        if(stufe <= 3) {
            grundgehalt *= 1.05;
            System.out.println("Dein Grundgehalt ist um 5% gestiegen");
            stufe++;
        } else {
            System.out.println("Du kannst nicht mehr Befördert werden.");
        }
    }
}
