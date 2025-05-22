public class Team {
    private String name;
    private int spiele, siege, unentschieden, niederlagen;
    private int toreFuer, toreGegen, punkte;

    public Team(String input) {
        this.name = input;
    }

    public String getName() {return name;}
    public int getSpiele() {return spiele;}
    public int getSiege() {return siege;}
    public int getUnentschieden() {return unentschieden;}
    public int getNiederlagen() {return niederlagen;}
    public int getToreFuer() {return toreFuer;}
    public int getToregegen() {return toreGegen;}
    public int getPunkte() {return punkte;}

    public int Tordifferenz() {
        return toreFuer - toreGegen;
    }

    public void addSpiele(int eigeneTore, int gegnerTore) {
        spiele++;
        toreFuer += eigeneTore;
        toreGegen += gegnerTore;

        if(eigeneTore > gegnerTore) {
            siege++;
            punkte += 3;
        } else if (gegnerTore == eigeneTore) {
            unentschieden++;
            punkte += 1;
        } else {
            niederlagen++;
        }
    }
}