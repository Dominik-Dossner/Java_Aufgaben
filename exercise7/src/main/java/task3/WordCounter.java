package task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    private Reader reader;
    private Map<Word, Integer> wordCounter;

    public WordCounter(Reader reader) {
        this.reader = reader;
        this.wordCounter = new HashMap<>();
    }

    public void read() {
    BufferedReader bufferedReader = new BufferedReader(reader);
    String line;

    try {
        while ((line = bufferedReader.readLine()) != null) {
            String[] words = line.trim().split("\\s");

            if(words.length == 1) {
                wordCounter.put(new Word(words[0], Word.Position.START),
                        wordCounter.getOrDefault(new Word(words[0], Word.Position.START), 0) + 1);

                wordCounter.put(new Word(words[0], Word.Position.MIDDLE),
                        wordCounter.getOrDefault(new Word(words[0], Word.Position.MIDDLE), 0) + 1);

                wordCounter.put(new Word(words[0], Word.Position.END),
                        wordCounter.getOrDefault(new Word(words[0], Word.Position.END), 0) + 1);
            } else {
                for(int i = 0; i < words.length; i++) {
                    Word.Position position;

                    if(i == 0) {
                        position = Word.Position.START;
                    } else if (i == words.length - 1) {
                        position = Word.Position.END;
                    } else {
                        position = Word.Position.MIDDLE;
                    }

                    wordCounter.put(new Word(words[i], position),
                            wordCounter.getOrDefault(new Word(words[i], position), 0) + 1);
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
        }
    }

    public Map<Word, Integer> getWordMap() {
        return wordCounter;
    }
}
