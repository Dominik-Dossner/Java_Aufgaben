package de.tha.prog2.blatt5.task1;

public interface Game {
    public int getPoints();
    public boolean recordAnswer(String input);
    public String nextQuestion();
    public boolean hasMoreQuestions();
}
