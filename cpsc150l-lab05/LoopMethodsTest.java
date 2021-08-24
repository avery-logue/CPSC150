import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

public class LoopMethodsTest {
	private Class<?> loop;
	private Method method;

	// EDIT THIS TO MATCH YOUR CLASS
	private String className = "LoopMethods";
	// END EDIT
	private String methodName = "";
	private String argTypes = "";
	private String invokation = "";
	private String returnType = "";

	private double epsilon = 0.001;

	@Before
	public void beforeEachTest() {
		loop = null;
		method = null;
		methodName = "";
		argTypes = "";
		invokation = "";
		returnType = "";
	}

	// sumSeries
	@Test
	public void testClassHasSumSeriesMethod() {
		// EDIT THESE TO MATCH YOUR METHOD
		methodName = "sumSeries";
		argTypes = "int,int";
		returnType = "int";
		// END EDIT
		// class exists
		try {
			Package pkg = getClass().getPackage();
			String path = pkg == null ? "" : pkg.getName() + ".";
			loop = Class.forName(path + className);
		} catch (ClassNotFoundException e) {
			fail("File \"" + className + ".class\" doesn't have a \"" + className
					+ "\" class. (is the class name spelled right?)");
		}

		// class has method
		try {
			// EDIT HERE TO GIVE PARAMETER TYPES
			method = loop.getMethod(methodName, int.class, int.class);
			// END EDIT
		} catch (NoSuchMethodException | SecurityException e) {
			fail("Class \"" + className + "\" doesn't have a \"" + methodName + "(" + argTypes
					+ ")\" method. (is the method name spelled right? are its parameters correct?)");
		}
		invokation = className + "." + methodName + "(" + argTypes + ")";
	}

	@Test
	public void testSumSeriesModifiers() {
		testClassHasSumSeriesMethod();

		int mods = method.getModifiers();
		assertTrue("Method \"" + methodName + "\" should be 'public'", Modifier.isPublic(mods));
		assertTrue("Method \"" + methodName + "\" should be 'static'", Modifier.isStatic(mods));
	}

	@Test
	public void testSumSeriesReturnType() {
		testClassHasSumSeriesMethod();

		Class<?> type = method.getReturnType();
		// EDIT THIS TO MATCH YOUR METHODS RETURN TYPE
		assertEquals(String.format("Method \"%s\" should return '%s' but returns '%s' instead", methodName, returnType,
				type.getSimpleName()), int.class, type);
		// END EDIT
	}

	// TESTS HERE
	@Test
	public void testSum1() {
		testClassHasSumSeriesMethod();

		int start = 5;
		int end = 5;

		int expected = 5;
		int actual = 0;

		try {
			actual = (int) method.invoke(null, start, end);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		assertEquals(
				className + "." + methodName + "(" + start + "," + end + ") returns incorrect value of " + actual + ".",
				actual, expected);
	}

	@Test
	public void testSum2() {
		testClassHasSumSeriesMethod();

		int start = 0;
		int end = 100;

		int expected = 5050;
		int actual = 0;

		try {
			actual = (int) method.invoke(null, start, end);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		assertEquals(
				className + "." + methodName + "(" + start + "," + end + ") returns incorrect value of " + actual + ".",
				actual, expected);
	}

	@Test
	public void testSum3() {
		testClassHasSumSeriesMethod();

		int start = 13;
		int end = 37;

		int expected = 625;
		int actual = 0;

		try {
			actual = (int) method.invoke(null, start, end);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		assertEquals(
				className + "." + methodName + "(" + start + "," + end + ") returns incorrect value of " + actual + ".",
				actual, expected);
	}
	// END TESTS

	// ========================================================================

	// factorial
	@Test
	public void testClassHasFactorialMethod() {
		// EDIT THESE TO MATCH YOUR METHOD
		methodName = "factorial";
		argTypes = "int";
		returnType = "int";
		// END EDIT
		// class exists
		try {
			Package pkg = getClass().getPackage();
			String path = pkg == null ? "" : pkg.getName() + ".";
			loop = Class.forName(path + className);
		} catch (ClassNotFoundException e) {
			fail("File \"" + className + ".class\" doesn't have a \"" + className
					+ "\" class. (is the class name spelled right?)");
		}

		// class has method
		try {
			// EDIT HERE TO GIVE PARAMETER TYPES
			method = loop.getMethod(methodName, int.class);
			// END EDIT
		} catch (NoSuchMethodException | SecurityException e) {
			fail("Class \"" + className + "\" doesn't have a \"" + methodName + "(" + argTypes
					+ ")\" method. (is the method name spelled right? are its parameters correct?)");
		}
		invokation = className + "." + methodName + "(" + argTypes + ")";
	}

	@Test
	public void testFactorialModifiers() {
		testClassHasFactorialMethod();

		int mods = method.getModifiers();
		assertTrue("Method \"" + methodName + "\" should be 'public'", Modifier.isPublic(mods));
		assertTrue("Method \"" + methodName + "\" should be 'static'", Modifier.isStatic(mods));
	}

	@Test
	public void testFactorialReturnType() {
		testClassHasFactorialMethod();

		Class<?> type = method.getReturnType();
		// EDIT THIS TO MATCH YOUR METHODS RETURN TYPE
		assertEquals(String.format("Method \"%s\" should return '%s' but returns '%s' instead", methodName, returnType,
				type.getSimpleName()), int.class, type);
		// END EDIT
	}

	// TESTS HERE
	@Test
	public void testFactorial1() {
		testClassHasFactorialMethod();

		int input = 0;

		int expected = 1;
		int actual = 0;

		try {
			actual = (int) method.invoke(null, input);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		assertEquals(className + "." + methodName + "(" + input + ") returns incorrect value of " + actual + ".",
				actual, expected);
	}

	@Test
	public void testFactorial2() {
		testClassHasFactorialMethod();

		int input = 6;

		int expected = 720;
		int actual = 0;

		try {
			actual = (int) method.invoke(null, input);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		assertEquals(className + "." + methodName + "(" + input + ") returns incorrect value of " + actual + ".",
				actual, expected);
	}

	@Test
	public void testFactorial3() {
		testClassHasFactorialMethod();

		int input = 10;

		int expected = 3628800;
		int actual = 0;

		try {
			actual = (int) method.invoke(null, input);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		assertEquals(className + "." + methodName + "(" + input + ") returns incorrect value of " + actual + ".",
				actual, expected);
	}

	// END TESTS

}
