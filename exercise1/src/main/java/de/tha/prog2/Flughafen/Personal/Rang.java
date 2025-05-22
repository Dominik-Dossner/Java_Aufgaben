package de.tha.prog2.Flughafen.Personal;

public enum Rang {
    CO_PILOT(5000), FIRST_OFFICER(7000), CAPTAIN(9000);
    private double grundgehalt;

    Rang(double grundgehalt) {
        this.grundgehalt = grundgehalt;
    }

    public double getGrundgehalt() {
        return grundgehalt;
    }
}
