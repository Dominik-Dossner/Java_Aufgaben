package de.tha.prog2.blatt5.task2;

public class HighScore {
    protected Player[] entries;
    protected int count;

    public HighScore() {
        entries = new Player[10];
    }

    public void recordEntry(Player player) {
        //Spieler schlechter als davorige
        if (count == 10 && player.getPoints() <= entries[9].getPoints()) {
            return;
        }

        int i = count - 1;
        while (i >= 0 && entries[i].getPoints() < player.getPoints()) {
            if (i < 9) entries[i + 1] = entries[i];
            i--;
        }

        entries[i + 1] = player;
        if (count < 10) count++;
    }

    public String toString () {
        StringBuilder sb = new StringBuilder();
        sb.append("** High SCORE**\n");

        for(int i = 0; i < count; i++) {
            sb.append(entries[i].toString()).append("\n");
        }

        return sb.toString();
    }
}
