package task3;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.CharArrayReader;
import java.io.Reader;
import java.lang.reflect.Method;
import java.util.Map;
import static java.util.Map.entry;

import org.junit.jupiter.api.Test;
import static task3.ClassNames.*;

public class TestWordCounter {


    public TestWordCounter() throws Exception {

    }

    private Object createWord(String word, String position) throws Exception {
		Class <?> wordClass = Class.forName(WORD_CLASS_NAME);
		Class <?> enumClass = Class.forName(ENUM_NAME);
		Object enumValue = Enum.valueOf((Class<Enum>) enumClass, position);
		return wordClass.getConstructor(String.class, enumClass).newInstance(word, enumValue);
	}

	private Map<Object, Integer> result1 = Map.ofEntries(
			entry(createWord("Dies", "START"), 1),
			entry(createWord("ist", "MIDDLE"), 1),
			entry(createWord("ein", "MIDDLE"), 1),
			entry(createWord("Testsatz", "MIDDLE"), 1),
			entry(createWord("mit", "MIDDLE"), 1),
			entry(createWord("einem", "MIDDLE"), 2),
			entry(createWord("dies", "MIDDLE"), 2),
			entry(createWord("in", "MIDDLE"), 1),
			entry(createWord("der", "MIDDLE"), 1),
			entry(createWord("Mitte", "MIDDLE"), 1),
			entry(createWord("und", "MIDDLE"), 1),
			entry(createWord("am", "MIDDLE"), 1),
			entry(createWord("Ende", "MIDDLE"), 1),
			entry(createWord("dies", "END"), 1)
	);
	
	private Map<Object, Integer> result2 = Map.ofEntries(
			entry(createWord("zweiten", "MIDDLE"), 1),
			entry(createWord("der", "MIDDLE"), 3),
			entry(createWord("bewusst", "MIDDLE"), 1),
			entry(createWord("mit", "MIDDLE"), 1),
			entry(createWord("feature", "MIDDLE"), 1),
			entry(createWord("um", "MIDDLE"), 1),
			entry(createWord("das", "MIDDLE"), 1),
			entry(createWord("ist", "MIDDLE"), 1),
			entry(createWord("ein", "MIDDLE"), 1),
			entry(createWord("nicht", "MIDDLE"), 1),
			entry(createWord("in", "MIDDLE"), 1),
			entry(createWord("ende", "MIDDLE"), 1),
			entry(createWord("implementieren", "END"), 1),
			entry(createWord("dies", "MIDDLE"), 2),
			entry(createWord("wir", "MIDDLE"), 1),
			entry(createWord("kompliziert", "MIDDLE"), 1),
			entry(createWord("einem", "MIDDLE"), 2),
			entry(createWord("noch", "MIDDLE"), 3),
			entry(createWord("testsatz", "MIDDLE"), 2),
			entry(createWord("einen", "MIDDLE"), 1),
			entry(createWord("auf", "MIDDLE"), 1),
			entry(createWord("auch", "MIDDLE"), 1),
			entry(createWord("und", "MIDDLE"), 1),
			entry(createWord("am", "MIDDLE"), 1),
			entry(createWord("dazu", "START"), 1),
			entry(createWord("dies", "START"), 1),
			entry(createWord("testen", "MIDDLE"), 1),
			entry(createWord("verzichtet", "MIDDLE"), 1),
			entry(createWord("implementierung", "MIDDLE"), 1),
			entry(createWord("wer", "START"), 1),
			entry(createWord("aber", "MIDDLE"), 2),
			entry(createWord("machen", "END"), 1),
			entry(createWord("möchte", "MIDDLE"), 1),
			entry(createWord("dies", "END"), 1),
			entry(createWord("kann", "MIDDLE"), 1),
			entry(createWord("mitte", "MIDDLE"), 1),
			entry(createWord("zu", "MIDDLE"), 1),
			entry(createWord("satzzeichen", "MIDDLE"), 1),
			entry(createWord("die", "MIDDLE"), 1),
			entry(createWord("unnötig", "MIDDLE"), 1)
	);	
	
	private Map<Object, Integer> result3 = Map.ofEntries(
			entry(createWord("wort", "START"), 1),
			entry(createWord("wOrt", "MIDDLE"), 1),
			entry(createWord("worT", "END"), 1)
			);
	
	@SuppressWarnings("unused")
	@Test
	public void testWordCounter() throws Throwable {
		Class<?> wordCounterClass = Class.forName(WORDCLASS_NAME);
		Object newInstance = wordCounterClass.getConstructor(Reader.class).newInstance((Object)null);
		Method read = wordCounterClass.getMethod("read");
		Method getWordMap = wordCounterClass.getMethod("getWordMap");
	}
	
	@Test
	public void testReadText1() throws Throwable {
		Reader reader = new CharArrayReader("Dies ist ein Testsatz mit einem dies in der Mitte und einem Dies am Ende dies".toCharArray());
		doLineTest(reader, result1);
	}
	
	@Test
	public void testReadText2() throws Throwable {

		Reader reader = new CharArrayReader(("Dies ist noch ein Testsatz mit einem dies in der Mitte und einem Dies am Ende dies\n"
											+ "Dazu testen wir noch einen zweiten TestSatz der aber bewusst auf Satzzeichen verzichtet um die Implementierung nicht unnötig kompliziert zu machen\n"
											+ "Wer möchte der kann das Feature aber auch noch implementieren").toCharArray());
		doLineTest(reader, result2);
			
	}
	
	@Test
	public void testReadSpecialLine() throws Throwable {
		Reader reader = new CharArrayReader(("Wort").toCharArray());
		doLineTest(reader, result3);		
	}
	
	@SuppressWarnings("unchecked")
	private void doLineTest(Reader reader, Map<Object, Integer> result) throws Throwable {
		Class<?> wordCounterClass = Class.forName(WORDCLASS_NAME);
		Method read = wordCounterClass.getMethod("read");
		Method getWordMap = wordCounterClass.getMethod("getWordMap");	
		Object wordCounter = wordCounterClass.getConstructor(Reader.class).newInstance(reader);
		read.invoke(wordCounter);
		Map<Object, Integer> wordMap = (Map<Object, Integer>) getWordMap.invoke(wordCounter);

		// Todo: uncomment for additional information
//		for (Object w : wordMap.keySet()) {
//			System.out.println(w.toString());
//		}
//		System.out.println("-------");
		
		assertTrue(wordMap.entrySet().containsAll(result.entrySet()));
		assertTrue(result.entrySet().containsAll(wordMap.entrySet()));
	}
}
