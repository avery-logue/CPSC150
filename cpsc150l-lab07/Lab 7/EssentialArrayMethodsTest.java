import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

public class EssentialArrayMethodsTest {
	private Class<?> cls;
	private Method method;

	// EDIT THIS TO MATCH YOUR CLASS
	private String className = "EssentialArrayMethods";
	// END EDIT
	private String methodName = "";
	private String argTypes = "";
	private String invokation = "";
	private String returnType = "";

	private double epsilon = 0.001;

	@Before
	public void beforeEachTest() {
		cls = null;
		method = null;
		methodName = "";
		argTypes = "";
		invokation = "";
		returnType = "";
	}

	// toStringFor
	@Test
	public void testClassHasToStringForMethod() {
		// EDIT THESE TO MATCH YOUR METHOD
		methodName = "toStringFor";
		argTypes = "";
		returnType = "String";
		// END EDIT
		// class exists
		try {
			Package pkg = getClass().getPackage();
			String path = pkg == null ? "" : pkg.getName() + ".";
			cls = Class.forName(path + className);
		} catch (ClassNotFoundException e) {
			fail("File \"" + className + ".class\" doesn't have a \"" + className
					+ "\" class. (is the class name spelled right?)");
		}

		// class has method
		try {
			// EDIT HERE TO GIVE PARAMETER TYPES
			method = cls.getMethod(methodName);
			// END EDIT
		} catch (NoSuchMethodException | SecurityException e) {
			fail("Class \"" + className + "\" doesn't have a \"" + methodName + "(" + argTypes
					+ ")\" method. (is the method name spelled right? are its parameters correct?)");
		}
		invokation = className + "." + methodName + "(" + argTypes + ")";
	}

	@Test
	public void testToStringForModifiers() {
		testClassHasToStringForMethod();

		int mods = method.getModifiers();
		assertTrue("Method \"" + methodName + "\" should be 'public'", Modifier.isPublic(mods));
		assertTrue("Method \"" + methodName + "\" should be 'static'", Modifier.isStatic(mods));
	}

	@Test
	public void testToStringForReturnType() {
		testClassHasToStringForMethod();

		Class<?> type = method.getReturnType();
		// EDIT THIS TO MATCH YOUR METHODS RETURN TYPE
		assertEquals(String.format("Method \"%s\" should return '%s' but returns '%s' instead", methodName, returnType,
				type.getSimpleName()), String.class, type);
		// END EDIT
	}

	// TESTS HERE
	@Test
	public void testToStringFor() {
		testClassHasToStringForMethod();

		String expected = "3 45 17 2 -1 44 9 23 67 2 -6 -23 -100 12 5 1212";
		String actual = "";

		try {
			actual = (String) method.invoke(null);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		assertEquals(className + "." + methodName + "(" + ") returns incorrect value of " + actual + ".", expected,
				actual);
	}

	// END TESTS

	// ========================================================================

	// toStringWhile
	@Test
	public void testClassHasToStringWhileMethod() {
		// EDIT THESE TO MATCH YOUR METHOD
		methodName = "toStringWhile";
		argTypes = "";
		returnType = "String";
		// END EDIT
		// class exists
		try {
			Package pkg = getClass().getPackage();
			String path = pkg == null ? "" : pkg.getName() + ".";
			cls = Class.forName(path + className);
		} catch (ClassNotFoundException e) {
			fail("File \"" + className + ".class\" doesn't have a \"" + className
					+ "\" class. (is the class name spelled right?)");
		}

		// class has method
		try {
			// EDIT HERE TO GIVE PARAMETER TYPES
			method = cls.getMethod(methodName);
			// END EDIT
		} catch (NoSuchMethodException | SecurityException e) {
			fail("Class \"" + className + "\" doesn't have a \"" + methodName + "(" + argTypes
					+ ")\" method. (is the method name spelled right? are its parameters correct?)");
		}
		invokation = className + "." + methodName + "(" + argTypes + ")";
	}

	@Test
	public void testToStringWhileModifiers() {
		testClassHasToStringWhileMethod();

		int mods = method.getModifiers();
		assertTrue("Method \"" + methodName + "\" should be 'public'", Modifier.isPublic(mods));
		assertTrue("Method \"" + methodName + "\" should be 'static'", Modifier.isStatic(mods));
	}

	@Test
	public void testToStringWhileReturnType() {
		testClassHasToStringWhileMethod();

		Class<?> type = method.getReturnType();
		// EDIT THIS TO MATCH YOUR METHODS RETURN TYPE
		assertEquals(String.format("Method \"%s\" should return '%s' but returns '%s' instead", methodName, returnType,
				type.getSimpleName()), String.class, type);
		// END EDIT
	}

	// TESTS HERE
	@Test
	public void testToStringWhile() {
		testClassHasToStringWhileMethod();

		String expected = "3 45 17 2 -1 44 9 23 67 2 -6 -23 -100 12 5 1212";
		String actual = "";

		try {
			actual = (String) method.invoke(null);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		assertEquals(className + "." + methodName + "(" + ") returns incorrect value of " + actual + ".", expected,
				actual);
	}

	// END TESTS

	// ========================================================================

	// toStringForEach
	@Test
	public void testClassHasToStringForEachMethod() {
		// EDIT THESE TO MATCH YOUR METHOD
		methodName = "toStringForEach";
		argTypes = "";
		returnType = "String";
		// END EDIT
		// class exists
		try {
			Package pkg = getClass().getPackage();
			String path = pkg == null ? "" : pkg.getName() + ".";
			cls = Class.forName(path + className);
		} catch (ClassNotFoundException e) {
			fail("File \"" + className + ".class\" doesn't have a \"" + className
					+ "\" class. (is the class name spelled right?)");
		}

		// class has method
		try {
			// EDIT HERE TO GIVE PARAMETER TYPES
			method = cls.getMethod(methodName);
			// END EDIT
		} catch (NoSuchMethodException | SecurityException e) {
			fail("Class \"" + className + "\" doesn't have a \"" + methodName + "(" + argTypes
					+ ")\" method. (is the method name spelled right? are its parameters correct?)");
		}
		invokation = className + "." + methodName + "(" + argTypes + ")";
	}

	@Test
	public void testToStringForEachModifiers() {
		testClassHasToStringForEachMethod();

		int mods = method.getModifiers();
		assertTrue("Method \"" + methodName + "\" should be 'public'", Modifier.isPublic(mods));
		assertTrue("Method \"" + methodName + "\" should be 'static'", Modifier.isStatic(mods));
	}

	@Test
	public void testToStringForEachReturnType() {
		testClassHasToStringForEachMethod();

		Class<?> type = method.getReturnType();
		// EDIT THIS TO MATCH YOUR METHODS RETURN TYPE
		assertEquals(String.format("Method \"%s\" should return '%s' but returns '%s' instead", methodName, returnType,
				type.getSimpleName()), String.class, type);
		// END EDIT
	}

	// TESTS HERE
	@Test
	public void testToStringForEach() {
		testClassHasToStringForEachMethod();

		String expected = "3 45 17 2 -1 44 9 23 67 2 -6 -23 -100 12 5 1212";
		String actual = "";

		try {
			actual = (String) method.invoke(null);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		assertEquals(className + "." + methodName + "(" + ") returns incorrect value of " + actual + ".", expected,
				actual);
	}

	// END TESTS

	// ========================================================================

	// reverseWhile
	@Test
	public void testClassHasReverseWhileMethod() {
		// EDIT THESE TO MATCH YOUR METHOD
		methodName = "reverseWhile";
		argTypes = "";
		returnType = "String";
		// END EDIT
		// class exists
		try {
			Package pkg = getClass().getPackage();
			String path = pkg == null ? "" : pkg.getName() + ".";
			cls = Class.forName(path + className);
		} catch (ClassNotFoundException e) {
			fail("File \"" + className + ".class\" doesn't have a \"" + className
					+ "\" class. (is the class name spelled right?)");
		}

		// class has method
		try {
			// EDIT HERE TO GIVE PARAMETER TYPES
			method = cls.getMethod(methodName);
			// END EDIT
		} catch (NoSuchMethodException | SecurityException e) {
			fail("Class \"" + className + "\" doesn't have a \"" + methodName + "(" + argTypes
					+ ")\" method. (is the method name spelled right? are its parameters correct?)");
		}
		invokation = className + "." + methodName + "(" + argTypes + ")";
	}

	@Test
	public void testReverseWhileModifiers() {
		testClassHasReverseWhileMethod();

		int mods = method.getModifiers();
		assertTrue("Method \"" + methodName + "\" should be 'public'", Modifier.isPublic(mods));
		assertTrue("Method \"" + methodName + "\" should be 'static'", Modifier.isStatic(mods));
	}

	@Test
	public void testReverseWhileReturnType() {
		testClassHasReverseWhileMethod();

		Class<?> type = method.getReturnType();
		// EDIT THIS TO MATCH YOUR METHODS RETURN TYPE
		assertEquals(String.format("Method \"%s\" should return '%s' but returns '%s' instead", methodName, returnType,
				type.getSimpleName()), String.class, type);
		// END EDIT
	}

	// TESTS HERE
	@Test
	public void testReverseWhile() {
		testClassHasReverseWhileMethod();

		String expected = "1212 5 12 -100 -23 -6 2 67 23 9 44 -1 2 17 45 3";
		String actual = "";

		try {
			actual = (String) method.invoke(null);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		assertEquals(className + "." + methodName + "(" + ") returns incorrect value of " + actual + ".", expected,
				actual);
	}

	// END TESTS

	// ========================================================================

	// oddIndicesFor
	@Test
	public void testClassHasOddIndicesForMethod() {
		// EDIT THESE TO MATCH YOUR METHOD
		methodName = "oddIndicesFor";
		argTypes = "";
		returnType = "String";
		// END EDIT
		// class exists
		try {
			Package pkg = getClass().getPackage();
			String path = pkg == null ? "" : pkg.getName() + ".";
			cls = Class.forName(path + className);
		} catch (ClassNotFoundException e) {
			fail("File \"" + className + ".class\" doesn't have a \"" + className
					+ "\" class. (is the class name spelled right?)");
		}

		// class has method
		try {
			// EDIT HERE TO GIVE PARAMETER TYPES
			method = cls.getMethod(methodName);
			// END EDIT
		} catch (NoSuchMethodException | SecurityException e) {
			fail("Class \"" + className + "\" doesn't have a \"" + methodName + "(" + argTypes
					+ ")\" method. (is the method name spelled right? are its parameters correct?)");
		}
		invokation = className + "." + methodName + "(" + argTypes + ")";
	}

	@Test
	public void testOddIndicesForModifiers() {
		testClassHasOddIndicesForMethod();

		int mods = method.getModifiers();
		assertTrue("Method \"" + methodName + "\" should be 'public'", Modifier.isPublic(mods));
		assertTrue("Method \"" + methodName + "\" should be 'static'", Modifier.isStatic(mods));
	}

	@Test
	public void testOddIndicesForReturnType() {
		testClassHasOddIndicesForMethod();

		Class<?> type = method.getReturnType();
		// EDIT THIS TO MATCH YOUR METHODS RETURN TYPE
		assertEquals(String.format("Method \"%s\" should return '%s' but returns '%s' instead", methodName, returnType,
				type.getSimpleName()), String.class, type);
		// END EDIT
	}

	// TESTS HERE
	@Test
	public void testOddIndicesFor() {
		testClassHasOddIndicesForMethod();

		String expected = "45 2 44 23 2 -23 12 1212";
		String actual = "";

		try {
			actual = (String) method.invoke(null);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		assertEquals(className + "." + methodName + "(" + ") returns incorrect value of " + actual + ".", expected,
				actual);
	}

	// END TESTS

	// averageForEach
	@Test
	public void testClassHasAverageForEachMethod() {
		// EDIT THESE TO MATCH YOUR METHOD
		methodName = "averageForEach";
		argTypes = "";
		returnType = "double";
		// END EDIT
		// class exists
		try {
			Package pkg = getClass().getPackage();
			String path = pkg == null ? "" : pkg.getName() + ".";
			cls = Class.forName(path + className);
		} catch (ClassNotFoundException e) {
			fail("File \"" + className + ".class\" doesn't have a \"" + className
					+ "\" class. (is the class name spelled right?)");
		}

		// class has method
		try {
			// EDIT HERE TO GIVE PARAMETER TYPES
			method = cls.getMethod(methodName);
			// END EDIT
		} catch (NoSuchMethodException | SecurityException e) {
			fail("Class \"" + className + "\" doesn't have a \"" + methodName + "(" + argTypes
					+ ")\" method. (is the method name spelled right? are its parameters correct?)");
		}
		invokation = className + "." + methodName + "(" + argTypes + ")";
	}

	@Test
	public void testAverageForEachModifiers() {
		testClassHasAverageForEachMethod();

		int mods = method.getModifiers();
		assertTrue("Method \"" + methodName + "\" should be 'public'", Modifier.isPublic(mods));
		assertTrue("Method \"" + methodName + "\" should be 'static'", Modifier.isStatic(mods));
	}

	@Test
	public void testAverageForEachReturnType() {
		testClassHasAverageForEachMethod();

		Class<?> type = method.getReturnType();
		// EDIT THIS TO MATCH YOUR METHODS RETURN TYPE
		assertEquals(String.format("Method \"%s\" should return '%s' but returns '%s' instead", methodName, returnType,
				type.getSimpleName()), double.class, type);
		// END EDIT
	}

	// TESTS HERE
	@Test
	public void testAverageForEach() {
		testClassHasAverageForEachMethod();

		double expected = 81.9375;
		double actual = 0;

		try {
			actual = (double) method.invoke(null);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		assertEquals(className + "." + methodName + "(" + ") returns incorrect value of " + actual + ".",
				expected, actual, epsilon);
	}

	// END TESTS

}
