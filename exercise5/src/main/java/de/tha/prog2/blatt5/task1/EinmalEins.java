package de.tha.prog2.blatt5.task1;

import java.util.Random;

public class EinmalEins implements GameDefinition {
    @Override
    public Game getGame(int amount) {
        EinmalEinsGame game = new EinmalEinsGame(amount);
        return game;
    }
    static class EinmalEinsGame implements Game {
        protected int questions;
        protected int points;
        protected int result;

        EinmalEinsGame(int amount) {
            questions = amount;
        }

        @Override
        public int getPoints() {
            return points;
        }

        @Override
        public boolean recordAnswer(String input) {
            int value = Integer.parseInt(input);
            if(value == result) {
                points++;
                questions--;
                return true;
            }
            return false;
        }

        @Override
        public String nextQuestion() {
            Random random = new Random();
            int number1 = random.nextInt(0, 10) +1;
            int number2 = random.nextInt(0, 10) +1;
            result = number1 * number2;
            return "Wie viel ist " + number1 + " * " + number2;
        }

        @Override
        public boolean hasMoreQuestions() {
            if(questions > 0) return true;
            return false;
        }
    }
}
