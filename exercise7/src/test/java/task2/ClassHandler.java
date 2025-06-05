package task2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClassHandler {

	public static boolean classExists(String className)  {
		try {
			Class.forName(className);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public static boolean methodExists(String className, String methodName, Object... params) { 
		try {
			Class<?> clazz = Class.forName(className);
			Class<?>[] paramTypes = (Class<?>[])Arrays.asList(params).stream().map(i -> i.getClass()).toArray();
			Method m = clazz.getMethod(methodName, paramTypes);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean methodExistsWithReturnType(String className, String methodName, Class<?> returnType, Class<?>... paramTypes) { 
		try {
			Class<?> clazz = Class.forName(className);
			Method m = clazz.getMethod(methodName, paramTypes);
			return m.getReturnType().equals(returnType);
		} catch (Exception e) {
			return false;
		}
	}
	
	public static Object callMethod(Object object, String methodName, Object... params) throws Exception {
		Class<?> clazz = object.getClass();
		Class<?>[] paramTypes = (Class<?>[])Arrays.asList(params)
				.stream()
				.map(i -> i.getClass())
				.collect(Collectors.toList())
				.toArray(new Class<?>[0]);
		Method m = clazz.getMethod(methodName, paramTypes);	
		return m.invoke(object, params);
	}
	
	public static Object createInstance(String className, Object... params) throws Exception {
		Class<?> clazz = Class.forName(className);
		List<?> paramTypes = Arrays.asList(params).stream()
							.map(i -> i.getClass())
							.collect(Collectors.toList());
		Constructor<?> c = clazz.getConstructor(paramTypes.toArray(new Class<?>[0]));
		return c.newInstance(params);
	}

	public static boolean hasBaseClass(String className, Class<?> baseClass) {
		try {
			Class<?> clazz = Class.forName(className);
			return clazz.getSuperclass().equals(baseClass);
		} catch (Exception e) {
			return false;
		}
	}
}
