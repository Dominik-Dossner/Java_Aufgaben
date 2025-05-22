import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import de.tha.prog2.blatt6.tools.TextProvider;

public class LetterCount {
    public void countChars(Map<Character, Integer> map, TextProvider textProvider) {
        for (String line : textProvider) {
            for(char letter : line.toLowerCase().toCharArray()) {
                if(letter >= 'a' && letter <= 'z') {
                    //schaut ob der Buchstabe enthalten ist ? Nein -> 0 + 1 ja -> counter wird erhöht
                    map.put(letter, map.getOrDefault(letter, 0) + 1);
                }
            }
        }
        // map.entrySet() liefert alle Einträge aus der Map
        for(Map.Entry<Character, Integer> output : map.entrySet()) {
            System.out.println(output.getKey() + " " + output.getValue());
        }

        if(!map.isEmpty()) {
            // Map.Entry gibt Werte zurück -> werden Verglichen -> größter bleibt
            char mostLetter = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
            System.out.println("Der Häufigste Buchstabe ist: " + mostLetter);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Reihenfolge: A - Z ===");
        TextProvider provider1 = new TextProvider();
        Map<Character, Integer> charMap1 = new TreeMap<>();
        LetterCount counter = new LetterCount();
        counter.countChars(charMap1, provider1);

        System.out.println();

        System.out.println("=== Reihenfolge: Z - A ===");
        TextProvider provider2 = new TextProvider();
        Map<Character, Integer> charMap2 = new TreeMap<>(Collections.reverseOrder());
        counter.countChars(charMap2, provider2);
    }
}
