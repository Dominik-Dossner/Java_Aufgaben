package task2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StaffManagementTest {
	private Object staffManagement;
	Object[] employees;

	@BeforeEach
	public void setup() throws Exception {
		staffManagement = ClassHandler.createInstance(ClassNames.STAFF_MANAGEMENT_CLASS);

		
		Constructor<?> constructor = Class.forName(ClassNames.EMPLOYEE_CLASS).getConstructor(int.class, String.class, String.class, double.class);
		employees = new Object[]{
				constructor.newInstance(0, "Lukas Meier", "IT", 1.0),
				constructor.newInstance(1, "Sophie Schmitt", "IT", 2.41),
				constructor.newInstance(2, "Anna Grau", "IT", 2.0),
				constructor.newInstance(3, "Paul Müller", "IT", 1.40),
				constructor.newInstance(4, "Anna Becker", "HR", 3.0),
				constructor.newInstance(5, "Leon Schneider", "HR", 10.5),
				constructor.newInstance(6, "Emma Fischer", "HR", 15.1),
				constructor.newInstance(7, "Max Wagner", "Marketing", 1.0),
				constructor.newInstance(8, "Mia Weber", "Marketing", 0.4),
				constructor.newInstance(9, "Felix Koch", "Marketing", 0.3),
				constructor.newInstance(10, "Clara Schwarz", "Finance", 2.1)
		};
		
		for (Object e : employees) {
			ClassHandler.callMethod(staffManagement, "addEmployee", e);
		}
	}

	@Test
	public void testClasses() {
		assertTrue(ClassHandler.classExists(ClassNames.STAFF_MANAGEMENT_CLASS));
		assertTrue(ClassHandler.methodExistsWithReturnType(ClassNames.STAFF_MANAGEMENT_CLASS,
				"getEmployeesSortedByName", List.class));
		assertTrue(ClassHandler.methodExistsWithReturnType(ClassNames.STAFF_MANAGEMENT_CLASS,
				"getEmployeesSortedByYearsEmployed", List.class));
		assertTrue(ClassHandler.methodExistsWithReturnType(ClassNames.STAFF_MANAGEMENT_CLASS,
				"getEmployeesFromDepartment", List.class, String.class));
		assertTrue(ClassHandler.methodExistsWithReturnType(ClassNames.STAFF_MANAGEMENT_CLASS,
				"getLongestEmployedEmployeePerDepartement", Map.class));
	}

	@Test
	public void testAddEmployeeThrowsException() throws Exception {
		assertTrue(ClassHandler.classExists(ClassNames.DUPLICATE_EMPLOYEE_EXCEPTION));
		assertTrue(ClassHandler.hasBaseClass(ClassNames.DUPLICATE_EMPLOYEE_EXCEPTION, RuntimeException.class));
		Class<?> clazz = Class.forName(ClassNames.DUPLICATE_EMPLOYEE_EXCEPTION);
		Object staffManagement = ClassHandler.createInstance(ClassNames.STAFF_MANAGEMENT_CLASS);

		Constructor<?> c = Class.forName(ClassNames.EMPLOYEE_CLASS).getConstructor(int.class, String.class,
				String.class, double.class);
		Object employee1 = c.newInstance(1, "Max Mustermann", "Department 1", 1.0);
		Object employee2 = c.newInstance(1, "Erika Musterfrau", "Department 2", 1.0);

		ClassHandler.callMethod(staffManagement, "addEmployee", employee1);

		try {
			ClassHandler.callMethod(staffManagement, "addEmployee", employee2);
		} catch (Exception e) {
			assertEquals(e.getCause().getClass(), clazz);
		}
	}
	
	@Test
	public void testgetEmployeesSortedByName() throws Exception {
		List<?> list = (List<?>) ClassHandler.callMethod(staffManagement, "getEmployeesSortedByName");
		
		assertEquals(11, list.size());
		assertEquals(employees[4], list.get(0));
		assertEquals(employees[2], list.get(1));
		assertEquals(employees[10], list.get(2));
		assertEquals(employees[6], list.get(3));
		assertEquals(employees[9], list.get(4));
		assertEquals(employees[5], list.get(5));
		assertEquals(employees[0], list.get(6));
		assertEquals(employees[7], list.get(7));
		assertEquals(employees[8], list.get(8));
		assertEquals(employees[3], list.get(9));
		assertEquals(employees[1], list.get(10));
	}
	
	@Test
	public void testGetEmployeesSortedByYearsEmployed() throws Exception {
List<?> list = (List<?>) ClassHandler.callMethod(staffManagement, "getEmployeesSortedByYearsEmployed");
		
		assertEquals(11, list.size());
		
		assertEquals(employees[6], list.get(0));
		assertEquals(employees[5], list.get(1));
		assertEquals(employees[4], list.get(2));
		assertEquals(employees[1], list.get(3));
		assertEquals(employees[10], list.get(4));
		assertEquals(employees[2], list.get(5));
		assertEquals(employees[3], list.get(6));
		assertEquals(employees[0], list.get(7));
		assertEquals(employees[7], list.get(8));
		assertEquals(employees[8], list.get(9));
		assertEquals(employees[9], list.get(10));
	}
	
	@Test
	public void testgetEmployeesFromDepartment() throws Exception { 
		List<?> list = (List<?>) ClassHandler.callMethod(staffManagement, "getEmployeesFromDepartment", "HR");
		assertEquals(3, list.size());
		assertTrue(list.containsAll(Arrays.asList(employees[4], employees[5], employees[6])));
		
		
		list = (List<?>) ClassHandler.callMethod(staffManagement, "getEmployeesFromDepartment", "IT");
		assertEquals(4, list.size());
		assertTrue(list.containsAll(Arrays.asList(employees[0], employees[1], employees[2], employees[3])));
		
		list = (List<?>) ClassHandler.callMethod(staffManagement, "getEmployeesFromDepartment", "Marketing");
		assertEquals(3, list.size());
		assertTrue(list.containsAll(Arrays.asList(employees[7], employees[8], employees[9])));		

		list = (List<?>) ClassHandler.callMethod(staffManagement, "getEmployeesFromDepartment", "Finance");

		assertEquals(1, list.size());
		assertTrue(list.containsAll(Arrays.asList(employees[10])));		

	}
	
	@Test
	public void testgetLongestEmployedEmployeePerDepartement() throws Exception {
		Map<?,?> map = (Map<?,?>) ClassHandler.callMethod(staffManagement, "getLongestEmployedEmployeePerDepartement");
		
		assertEquals(employees[1], map.get("IT"));
		assertEquals(employees[6], map.get("HR"));
		assertEquals(employees[7], map.get("Marketing"));
		assertEquals(employees[10], map.get("Finance"));

	}

}
