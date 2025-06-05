package task3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static task3.ClassNames.*;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

public class TestWord {
	@Test
	public void testWord()  throws Throwable {
		Class <?> wordClass = Class.forName(WORD_CLASS_NAME);
		Class <?> enumClass = Class.forName(ENUM_NAME);
		Method valueOf = enumClass.getMethod("valueOf", String.class);
		Object enumStart = valueOf.invoke(null, "START");
		Object enumMiddle = valueOf.invoke(null, "MIDDLE");
		Object enumEnd = valueOf.invoke(null,  "END");
		
		Object word = wordClass.getConstructor(String.class, enumClass).newInstance("TEsTVv", enumStart);
		Method getWord = wordClass.getMethod("getWord");
		Method getPosition = wordClass.getMethod("getPosition");
		
		assertEquals("testvv", getWord.invoke(word));
		assertEquals(enumStart, getPosition.invoke(word));
	}
	
	
}
