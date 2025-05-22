package de.tha.prog2.blatt5.task2;

public class Player implements Comparable<Player> {
    private int points;
    private String name;

    public Player(String name) {
        this.name = name;
        this.points = 0;
    }

    public void recordPoints(int amount) {
        this.points += amount;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Player player) {
        return this.points - player.points;
    }

    @Override
    public String toString() {
        return getPoints() + " - " + getName();
    }
}
