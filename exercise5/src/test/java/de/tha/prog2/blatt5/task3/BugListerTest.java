package de.tha.prog2.blatt5.task3;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BugListerTest {
	Class<?> bugListerClass; 
	Object bugListerInstance;
	Method inspectClass;
	
	@BeforeEach
	public void setup() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		bugListerClass = Class.forName("de.tha.prog2.blatt5.task3.annotations.BugLister");
		inspectClass = bugListerClass.getMethod("getBugInfos", Class.class);
		bugListerInstance = bugListerClass.getConstructor().newInstance();
	}
	
	@Test
	public void testBugListerSimple() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException, ClassNotFoundException {
		inspectClass.invoke(bugListerInstance, Class.forName("de.tha.prog2.blatt5.task3.annotatedClasses.SimpleClass"));
		assertEquals("de.tha.prog2.blatt5.task3.annotatedClasses.SimpleClass\tnull\tnull\tINVALID\tTestBug\n", bugListerInstance.toString());

	}
	
	private String sortByLine(String string) {
		String[] lines = string.split(System.lineSeparator());
		Arrays.sort(lines);
		return String.join(System.lineSeparator(), lines);
	}
	
	@Test
	public void testBugListerComplex() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException, ClassNotFoundException {
		inspectClass.invoke(bugListerInstance, Class.forName("de.tha.prog2.blatt5.task3.annotatedClasses.ComplexClass"));
		String expectedResult = "de.tha.prog2.blatt5.task3.annotatedClasses.ComplexClass	null	null	MINOR	This class has a bug\n" +
				"de.tha.prog2.blatt5.task3.annotatedClasses.ComplexClass	null	public void de.tha.prog2.blatt5.task3.annotatedClasses.ComplexClass.shouldBePrivate(int)	ENHANCEMENT	The method should have private visibility\n" +
				"de.tha.prog2.blatt5.task3.annotatedClasses.ComplexClass	null	private void de.tha.prog2.blatt5.task3.annotatedClasses.ComplexClass.shouldBePublic(int)	ENHANCEMENT	The method should have public visibility\n" +
				"de.tha.prog2.blatt5.task3.annotatedClasses.ComplexClass$StaticInnerClass	de.tha.prog2.blatt5.task3.annotatedClasses.ComplexClass	null	SEVERE	The static inner class has a bug\n" +
				"de.tha.prog2.blatt5.task3.annotatedClasses.ComplexClass$StaticInnerClass	de.tha.prog2.blatt5.task3.annotatedClasses.ComplexClass	private void de.tha.prog2.blatt5.task3.annotatedClasses.ComplexClass$StaticInnerClass.myPrivateMethod()	SEVERE	The static inner class has a private message with a bug\n" +
				"de.tha.prog2.blatt5.task3.annotatedClasses.ComplexClass$StaticInnerClass$OneLevelDeeper	de.tha.prog2.blatt5.task3.annotatedClasses.ComplexClass$StaticInnerClass	null	CRITICAL	We need to go deeper\n";
		String currentResult = bugListerInstance.toString();
		assertEquals(sortByLine(expectedResult), sortByLine(currentResult));
		System.out.println(sortByLine(expectedResult));	}
}


