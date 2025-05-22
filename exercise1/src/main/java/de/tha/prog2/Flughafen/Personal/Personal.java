package de.tha.prog2.Flughafen.Personal;

abstract public class Personal {
    protected String name;
    protected String vorname;
    protected double grundgehalt;
    protected int persNr;
    private static int nextPersNr = 1;

    public Personal(String vorname, String name, double grundgehalt) {
        this.vorname = vorname;
        this.name = name;
        this.grundgehalt = grundgehalt;
        this.persNr = nextPersNr++;
    }

    public String toString() {
        return "Person " + persNr + ": " + vorname + " " + name + ", Grundgehalt: " + grundgehalt + "€";
    }

    abstract public void befoerdern();

    public int getPersNr() {
        return persNr;
    }
    public double gehaltBerechnen() {
        return grundgehalt;
    }
}
