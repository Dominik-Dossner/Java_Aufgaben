package task2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;

import org.junit.jupiter.api.Test;

public class EmployeeTest {
	@Test
	public void testEmployeeAttributes() throws Exception {
		assertTrue(ClassHandler.classExists(ClassNames.EMPLOYEE_CLASS));
		assertTrue(ClassHandler.methodExistsWithReturnType(ClassNames.EMPLOYEE_CLASS, "getName", String.class));
		assertTrue(ClassHandler.methodExistsWithReturnType(ClassNames.EMPLOYEE_CLASS, "getDepartment", String.class));
		assertTrue(ClassHandler.methodExistsWithReturnType(ClassNames.EMPLOYEE_CLASS, "getYearsEmployed", double.class));
		assertTrue(ClassHandler.methodExistsWithReturnType(ClassNames.EMPLOYEE_CLASS, "getEmployeeID", int.class));
		@SuppressWarnings("unused")
		Constructor<?> constructor = Class.forName(ClassNames.EMPLOYEE_CLASS).getConstructor(int.class, String.class, String.class, double.class);
		
	}
}
