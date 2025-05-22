package de.tha.prog2.blatt5.task2;

import de.tha.prog2.blatt5.task1.Game;
import de.tha.prog2.blatt5.task1.GameDefinition;

import java.util.Scanner;

public class QuestionGame {
    protected GameDefinition gameDefinition;
    protected Game game;
    protected Player player;
    protected HighScore highScore;

    public QuestionGame() {
        this.highScore = new HighScore();
    }

    private void createGameDefinition(String classInput) {
        try {
            Class<?> className = Class.forName("de.tha.prog2.blatt5.task1." + classInput);

            if (GameDefinition.class.isAssignableFrom(className)) {
                this.gameDefinition = (GameDefinition) className.getDeclaredConstructor().newInstance();
            } else {
                System.out.println("Dulli: Klasse implement nicht GameDefinition!");
            }
        } catch (Exception e) {
            System.out.println("Fehlende Klasse: " + e.getMessage());
        }
    }


    private void createPlayer(String name) {
        this.player = new Player(name);
    }

    public void gameLoop() {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = true;

        while(gameOver) {
            System.out.println("Name des Spielers: ");
            String playerName = scanner.nextLine();
            createPlayer(playerName);

            System.out.println("Welches Spiel soll geladen werden: ");
            String gameName = scanner.nextLine();
            createGameDefinition(gameName);

            System.out.println("Wie viele Fragen sollen gestellt werden?");
            int questions = Integer.parseInt(scanner.nextLine());

            if (gameDefinition != null) {
                game = gameDefinition.getGame(questions);

                while (game.hasMoreQuestions()) {
                    String question = game.nextQuestion();
                    System.out.print(question + " ");
                    String answer = scanner.nextLine();
                    game.recordAnswer(answer);
                }

                player.recordPoints(game.getPoints());
                highScore.recordEntry(player);

                System.out.println(highScore);

                System.out.print("Noch eine Runde? [ja/nein]: ");
                gameOver = scanner.nextLine().toLowerCase().equals("ja");
            } else {
                System.out.println("Fehler.");
                gameOver = false;
            }
        }
    }

    public static void main(String[] args) {
        QuestionGame game = new QuestionGame();
        game.gameLoop();
    }
}
