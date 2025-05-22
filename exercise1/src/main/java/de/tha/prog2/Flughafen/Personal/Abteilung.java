package de.tha.prog2.Flughafen.Personal;

public enum Abteilung {
    TECHNIK(3500), GEPÄCKABFERRTIGUNG(3000), SICHERHEIT(3200), CHECK_IN(2800);
    private double grundgehalt;

    Abteilung(double grundgehalt) {
        this.grundgehalt = grundgehalt;
    }

    public double getGrundgehalt() {
        return grundgehalt;
    }
}
