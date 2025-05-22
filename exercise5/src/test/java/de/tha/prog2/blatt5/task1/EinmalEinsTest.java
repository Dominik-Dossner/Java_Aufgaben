package de.tha.prog2.blatt5.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EinmalEinsTest {

    @Test
    public void testImplementsGameDefinition() {
        assertTrue(GameDefinition.class.isAssignableFrom(EinmalEins.class),
                "EinmalEins sollte GameDefinition implementieren");
    }

    @Test
    public void testHasInnerClassImplementingGame() {
        Class<?>[] innerClasses = EinmalEins.class.getDeclaredClasses();
        boolean found = false;

        for (Class<?> inner : innerClasses) {
            if (Game.class.isAssignableFrom(inner)) {
                found = true;
                break;
            }
        }

        assertTrue(found, "Es sollte eine innere Klasse geben, die Game implementiert");
    }

    @Test
    public void testGameObjectIsNotNullAndImplementsGame() {
        GameDefinition def = new EinmalEins();
        Game game = def.getGame(3);

        assertNotNull(game, "getGame() sollte kein null zurückgeben");
        assertTrue(game instanceof Game, "Das zurückgegebene Objekt sollte Game implementieren");
    }

    @Test
    public void testGameBasicFlow() {
        Game game = new EinmalEins().getGame(1);
        assertTrue(game.hasMoreQuestions(), "Es sollte Fragen geben");
        String q = game.nextQuestion();
        assertNotNull(q);
        game.recordAnswer("0");
        assertTrue(game.getPoints() >= 0);
    }
}
