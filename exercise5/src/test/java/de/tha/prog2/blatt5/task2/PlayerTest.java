package de.tha.prog2.blatt5.task2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void testRecordPoints() {
        Player player = new Player("Max");
        player.recordPoints(10);
        player.recordPoints(5);
        assertEquals("15 - Max", player.toString(), "Punkte sollten korrekt aufsummiert werden");
    }

    @Test
    public void testCompareTo() {
        Player p1 = new Player("A");
        Player p2 = new Player("B");
        p1.recordPoints(10);
        p2.recordPoints(5);
        assertTrue(p1.compareTo(p2) > 0, "Spieler mit mehr Punkten sollte als größer gelten");
        assertTrue(p2.compareTo(p1) < 0, "Spieler mit weniger Punkten sollte als kleiner gelten");
    }
}



