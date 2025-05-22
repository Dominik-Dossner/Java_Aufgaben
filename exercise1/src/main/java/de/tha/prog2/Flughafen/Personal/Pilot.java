package de.tha.prog2.Flughafen.Personal;

public class Pilot extends Personal {
    private Rang rang;

    public Pilot(String vorname, String name, Rang rang) {
        super(vorname, name, rang.getGrundgehalt());
        this.rang = rang;
    }
    @Override
    public void befoerdern() {
        switch(rang) {
            case CO_PILOT:
                rang = Rang.FIRST_OFFICER;
                grundgehalt = rang.getGrundgehalt();
                System.out.println("Von CO-Pilot auf First-Officer befördert.");
                break;
            case FIRST_OFFICER:
                rang = Rang.CAPTAIN;
                grundgehalt = rang.getGrundgehalt();
                System.out.println("Von FIRST-OFFICER auf CAPTAIN befördert.");
                break;
            default:
                break;
        }
    }

}
