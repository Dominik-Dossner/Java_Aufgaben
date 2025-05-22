package de.tha.prog2.Flughafen.Personal;

public class Flugbegleiter extends Personal {
    protected boolean isLeiter = false;

    public Flugbegleiter(String vorname, String name) {
        super(vorname, name, 3500);
    }
    @Override
    public void befoerdern() {
        if(isLeiter == false) {
            grundgehalt = Math.round(grundgehalt * 1.15);
            isLeiter = true;
            System.out.println("Flugbeleiter-Beförderung: " + grundgehalt);
        } else {
            System.out.println("Du wurdest schon befördert");
        }
    }
}
