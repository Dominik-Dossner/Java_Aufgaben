package de.tha.prog2.blatt5.task2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HighScoreTest {

    @Test
    public void testRecordEntryWithSinglePlayer() {
        HighScore hs = new HighScore();
        Player player = new Player("Alice");
        player.recordPoints(10);
        hs.recordEntry(player);
        assertTrue(hs.toString().contains("Alice"), "Highscore sollte Spieler enthalten");
    }

    @Test
    public void testRecordEntrySortOrder() {
        HighScore hs = new HighScore();
        Player p1 = new Player("Bob");
        p1.recordPoints(5);
        hs.recordEntry(p1);

        Player p2 = new Player("Alice");
        p2.recordPoints(10);
        hs.recordEntry(p2);

        Player p3 = new Player("Charlie");
        p3.recordPoints(15);
        hs.recordEntry(p3);

        System.out.println(hs);
        String output = hs.toString();
        int indexP2 = output.indexOf("Alice");
        int indexP1 = output.indexOf("Bob");

        assertTrue(indexP2 < indexP1, "Spieler mit höherer Punktzahl sollte zuerst gelistet werden");
    }
}




