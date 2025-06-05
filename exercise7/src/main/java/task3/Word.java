package task3;

import java.util.Objects;

public class Word {
    private Position position;
    private String word;

    public Word(String word, Position position) {
        this.word = word.toLowerCase();
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public String getWord() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word1 = (Word) o;
        return Objects.equals(word, word1.word) && Objects.equals(position, word1.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, position);
    }

    public enum Position {
        START, MIDDLE, END
    }
}
