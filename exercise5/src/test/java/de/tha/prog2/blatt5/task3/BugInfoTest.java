package de.tha.prog2.blatt5.task3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

public class BugInfoTest {
	private Constructor<?> getConstructor() throws NoSuchMethodException, SecurityException, ClassNotFoundException {
		Class<?> bugInfoClass = Class.forName("de.tha.prog2.blatt5.task3.annotations.BugInfo");
		Class<?> bugAnnotation = Class.forName("de.tha.prog2.blatt5.task3.annotations.Bug");
		Class<?> typeEnum = bugAnnotation.getClasses()[0];
		return bugInfoClass.getConstructor(Class.class, Class.class, Method.class, typeEnum, String.class);
		
	}
	
	@Test
	public void testBugInfo() throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		Class<?> bugInfoClass = Class.forName("de.tha.prog2.blatt5.task3.annotations.BugInfo");
		assertNotNull(getConstructor());
	}
	
	@Test
	public void testToString() throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> bugAnnotation = Class.forName("de.tha.prog2.blatt5.task3.annotations.Bug");
		Class<?> typeEnum = bugAnnotation.getClasses()[0];
		Constructor<?> ct = getConstructor();
		Object innerClassObject = new Object() {
			public void method() {
				
			}
		};
		
		Object o = ct.newInstance(
				null, 
				innerClassObject.getClass(),
				null,
				typeEnum.getEnumConstants()[0],
				"This is a bug");
		assertEquals("null\tde.tha.prog2.blatt5.task3.BugInfoTest$1\tnull\tINVALID\tThis is a bug", o.toString());
		
		o = ct.newInstance(
				BugInfoTest.class, 
				innerClassObject.getClass(),
				innerClassObject.getClass().getMethod("method"),
				typeEnum.getEnumConstants()[0],
				"This is a bug");
		assertEquals("de.tha.prog2.blatt5.task3.BugInfoTest\tde.tha.prog2.blatt5.task3.BugInfoTest$1\tpublic void de.tha.prog2.blatt5.task3.BugInfoTest$1.method()\tINVALID\tThis is a bug", o.toString());
	}
}