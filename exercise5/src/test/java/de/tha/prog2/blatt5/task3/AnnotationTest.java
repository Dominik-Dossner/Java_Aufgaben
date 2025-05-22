package de.tha.prog2.blatt5.task3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AnnotationTest {
	@Test
	public void testAnnotationClass() throws ClassNotFoundException, NoSuchFieldException, SecurityException, NoSuchMethodException {
		Class<?> bugAnnotation = Class.forName("de.tha.prog2.blatt5.task3.annotations.Bug");
		assertEquals(String.class, bugAnnotation.getMethod("description").getReturnType());
		Class<?> typeEnum = bugAnnotation.getClasses()[0];
		assertTrue(typeEnum.isEnum());
		for (String m: new String[] {"INVALID", "ENHANCEMENT", "MINOR", "SEVERE", "CRITICAL"}) {
			boolean found = false;
			for (Object o : typeEnum.getEnumConstants()) 
				if (o.toString().equals(m)) {
					found = true;
					break;
				}
				
			assertTrue(found, "Did not find all required values");
		}
		assertEquals(typeEnum, bugAnnotation.getMethod("type").getReturnType());
	}
}

