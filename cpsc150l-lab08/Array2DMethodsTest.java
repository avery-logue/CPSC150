import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class Array2DMethodsTest {
	private Class<?> cls;
	private Method method;

	// EDIT THIS TO MATCH YOUR CLASS
	private String className = "Array2DMethods";
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

	// sumRows
	@Test
	public void testClassHasSumRowsMethod() {
		// EDIT THESE TO MATCH YOUR METHOD
		methodName = "sumRows";
		argTypes = "int[][]";
		returnType = "int[]";
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
			method = cls.getMethod(methodName, int[][].class);
			// END EDIT
		} catch (NoSuchMethodException | SecurityException e) {
			fail("Class \"" + className + "\" doesn't have a \"" + methodName + "(" + argTypes
					+ ")\" method. (is the method name spelled right? are its parameters correct?)");
		}
		invokation = className + "." + methodName + "(" + argTypes + ")";
	}

	@Test
	public void testSumRowsModifiers() {
		testClassHasSumRowsMethod();

		int mods = method.getModifiers();
		assertTrue("Method \"" + methodName + "\" should be 'public'", Modifier.isPublic(mods));
		assertTrue("Method \"" + methodName + "\" should be 'static'", Modifier.isStatic(mods));
	}

	@Test
	public void testSumRowsReturnType() {
		testClassHasSumRowsMethod();

		Class<?> type = method.getReturnType();
		// EDIT THIS TO MATCH YOUR METHODS RETURN TYPE
		assertEquals(String.format("Method \"%s\" should return '%s' but returns '%s' instead", methodName, returnType,
				type.getSimpleName()), int[].class, type);
		// END EDIT
	}

	// TESTS HERE
	@Test
	public void testSumRowsNull() {
		testClassHasSumRowsMethod();

		int[][] a = null;

		int[] expected = {};
		int[] actual = null;

		try {
			actual = (int[]) method.invoke(null, new Object[] { a });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertArrayEquals(className + "." + methodName + "(" + "null" + ")" + " returns incorrect output of "
				+ Arrays.toString(actual), expected, actual);
	}

	@Test
	public void testSumRowsNoRows() {
		testClassHasSumRowsMethod();

		int[][] aOrig = new int[][] {};
		int[][] a = new int[][] {};

		int[] expected = new int[0];
		int[] actual = null;

		try {
			actual = (int[]) method.invoke(null, new Object[] { a });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + ")"
				+ " returns incorrect output of " + Arrays.toString(actual), expected, actual);
		// a == aOrig
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + ")" + " modified \"a\" array.",
				aOrig, a);
	}

	@Test
	public void testSumRowsEmptyRow() {
		testClassHasSumRowsMethod();

		int[][] aOrig = new int[][] { {} };
		int[][] a = new int[][] { {} };

		int[] expected = { 0 };
		int[] actual = null;

		try {
			actual = (int[]) method.invoke(null, new Object[] { a });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + ")"
				+ " returns incorrect output of " + Arrays.toString(actual), expected, actual);
		// a == aOrig
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + ")" + " modified \"a\" array.",
				aOrig, a);
	}

	@Test
	public void testSumRowsSingleton() {
		testClassHasSumRowsMethod();

		int[][] aOrig = new int[][] { { 1 } };
		int[][] a = new int[][] { { 1 } };

		int[] expected = { 1 };
		int[] actual = null;

		try {
			actual = (int[]) method.invoke(null, new Object[] { a });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + ")"
				+ " returns incorrect output of " + Arrays.toString(actual), expected, actual);
		// a == aOrig
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + ")" + " modified \"a\" array.",
				aOrig, a);
	}

	@Test
	public void testSumRows1() {
		testClassHasSumRowsMethod();

		int[][] aOrig = new int[][] { { 1, 2, 3, 4, 5 }, { 2, 3, 4, -9000, 6 }, { 81, 91, 101, -202, 0 } };
		int[][] a = new int[][] { { 1, 2, 3, 4, 5 }, { 2, 3, 4, -9000, 6 }, { 81, 91, 101, -202, 0 } };

		int[] expected = { 15, -8985, 71 };
		int[] actual = null;

		try {
			actual = (int[]) method.invoke(null, new Object[] { a });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + ")"
				+ " returns incorrect output of " + Arrays.toString(actual), expected, actual);
		// a == aOrig
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + ")" + " modified \"a\" array.",
				aOrig, a);
	}

	@Test
	public void testSumRows2() {
		testClassHasSumRowsMethod();

		int[][] aOrig = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { -11, 12, -13 }, { 8999, 1, 1 } };
		int[][] a = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { -11, 12, -13 }, { 8999, 1, 1 } };

		int[] expected = { 6, 15, -12, 9001 };
		int[] actual = null;

		try {
			actual = (int[]) method.invoke(null, new Object[] { a });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + ")"
				+ " returns incorrect output of " + Arrays.toString(actual), expected, actual);
		// a == aOrig
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + ")" + " modified \"a\" array.",
				aOrig, a);
	}

	// END TESTS

	// ========================================================================

	// getRow
	@Test
	public void testClassHasGetRowMethod() {
		// EDIT THESE TO MATCH YOUR METHOD
		methodName = "getRow";
		argTypes = "int[][],int";
		returnType = "int[]";
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
			method = cls.getMethod(methodName, int[][].class, int.class);
			// END EDIT
		} catch (NoSuchMethodException | SecurityException e) {
			fail("Class \"" + className + "\" doesn't have a \"" + methodName + "(" + argTypes
					+ ")\" method. (is the method name spelled right? are its parameters correct?)");
		}
		invokation = className + "." + methodName + "(" + argTypes + ")";
	}

	@Test
	public void testGetRowModifiers() {
		testClassHasGetRowMethod();

		int mods = method.getModifiers();
		assertTrue("Method \"" + methodName + "\" should be 'public'", Modifier.isPublic(mods));
		assertTrue("Method \"" + methodName + "\" should be 'static'", Modifier.isStatic(mods));
	}

	@Test
	public void testGetRowType() {
		testClassHasGetRowMethod();

		Class<?> type = method.getReturnType();
		// EDIT THIS TO MATCH YOUR METHODS RETURN TYPE
		assertEquals(String.format("Method \"%s\" should return '%s' but returns '%s' instead", methodName, returnType,
				type.getSimpleName()), int[].class, type);
		// END EDIT
	}

	// TESTS HERE
	@Test
	public void testGetRowNull() {
		testClassHasGetRowMethod();

		int[][] a = null;
		int n = 0;

		int[] expected = null;
		int[] actual = null;

		try {
			actual = (int[]) method.invoke(null, new Object[] { a, n });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertArrayEquals(className + "." + methodName + "(" + "null" + "," + n + ")" + " returns incorrect output of "
				+ Arrays.toString(actual), expected, actual);
	}

	@Test
	public void testGetRowNoRows() {
		testClassHasGetRowMethod();

		int[][] aOrig = new int[][] {};
		int[][] a = new int[][] {};
		int n = 0;

		int[] expected = null;
		int[] actual = null;

		try {
			actual = (int[]) method.invoke(null, new Object[] { a, n });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + "," + n + ")"
				+ " returns incorrect output of " + Arrays.toString(actual), expected, actual);
		// a == aOrig
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + ")" + " modified \"a\" array.",
				aOrig, a);
	}

	@Test
	public void testGetRow1() {
		testClassHasGetRowMethod();

		int[][] aOrig = new int[][] { {} };
		int[][] a = new int[][] { {} };
		int n = 0;

		int[] expected = {};
		int[] actual = null;

		try {
			actual = (int[]) method.invoke(null, new Object[] { a, n });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + "," + n + ")"
				+ " returns incorrect output of " + Arrays.toString(actual), expected, actual);
		// a == aOrig
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + ")" + " modified \"a\" array.",
				aOrig, a);
	}

	@Test
	public void testGetRow2() {
		testClassHasGetRowMethod();

		int[][] aOrig = new int[][] { {} };
		int[][] a = new int[][] { {} };
		int n = 1;

		int[] expected = null;
		int[] actual = null;

		try {
			actual = (int[]) method.invoke(null, new Object[] { a, n });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + "," + n + ")"
				+ " returns incorrect output of " + Arrays.toString(actual), expected, actual);
		// a == aOrig
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + ")" + " modified \"a\" array.",
				aOrig, a);
	}

	@Test
	public void testGetRow3() {
		testClassHasGetRowMethod();

		int[][] aOrig = new int[][] { {}, { 1 }, { 1, 2 } };
		int[][] a = new int[][] { {}, { 1 }, { 1, 2 } };
		int n = 1;

		int[] expected = { 1 };
		int[] actual = null;

		try {
			actual = (int[]) method.invoke(null, new Object[] { a, n });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + "," + n + ")"
				+ " returns incorrect output of " + Arrays.toString(actual), expected, actual);
		// a == aOrig
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + ")" + " modified \"a\" array.",
				aOrig, a);
	}

	@Test
	public void testGetRow4() {
		testClassHasGetRowMethod();

		int[][] aOrig = new int[][] { {}, { 1 }, { 2, 5 } };
		int[][] a = new int[][] { {}, { 1 }, { 2, 5 } };
		int n = 2;

		int[] expected = { 2, 5 };
		int[] actual = null;

		try {
			actual = (int[]) method.invoke(null, new Object[] { a, n });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + "," + n + ")"
				+ " returns incorrect output of " + Arrays.toString(actual), expected, actual);
		// a == aOrig
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + ")" + " modified \"a\" array.",
				aOrig, a);
	}

	@Test
	public void testGetRow5() {
		testClassHasGetRowMethod();

		int[][] aOrig = new int[][] { { 0 }, { 1 }, { 2, 5 }, { 16 } };
		int[][] a = new int[][] { { 0 }, { 1 }, { 2, 5 }, { 16 } };
		int n = 4;

		int[] expected = null;
		int[] actual = null;

		try {
			actual = (int[]) method.invoke(null, new Object[] { a, n });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + "," + n + ")"
				+ " returns incorrect output of " + Arrays.toString(actual), expected, actual);
		// a == aOrig
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + ")" + " modified \"a\" array.",
				aOrig, a);
	}

	// END TESTS

	// ========================================================================

	// average
	@Test
	public void testClassHasAverageMethod() {
		// EDIT THESE TO MATCH YOUR METHOD
		methodName = "average";
		argTypes = "double";
		returnType = "int[][]";
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
			method = cls.getMethod(methodName, int[][].class);
			// END EDIT
		} catch (NoSuchMethodException | SecurityException e) {
			fail("Class \"" + className + "\" doesn't have a \"" + methodName + "(" + argTypes
					+ ")\" method. (is the method name spelled right? are its parameters correct?)");
		}
		invokation = className + "." + methodName + "(" + argTypes + ")";
	}

	@Test
	public void testAverageModifiers() {
		testClassHasAverageMethod();

		int mods = method.getModifiers();
		assertTrue("Method \"" + methodName + "\" should be 'public'", Modifier.isPublic(mods));
		assertTrue("Method \"" + methodName + "\" should be 'static'", Modifier.isStatic(mods));
	}

	@Test
	public void testAveargeReturnType() {
		testClassHasAverageMethod();

		Class<?> type = method.getReturnType();
		// EDIT THIS TO MATCH YOUR METHODS RETURN TYPE
		assertEquals(String.format("Method \"%s\" should return '%s' but returns '%s' instead", methodName, returnType,
				type.getSimpleName()), double.class, type);
		// END EDIT
	}

	// TESTS HERE
	@Test
	public void testAverageNull() {
		testClassHasAverageMethod();
		int[][] a = null;

		double expected = 0.0;
		double actual = 0.0;

		try {
			actual = (double) method.invoke(null, new Object[] { a });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertEquals(className + "." + methodName + "(" + "null" + ")"
				+ " returns incorrect output of " + actual, expected, actual, epsilon);
	}

	@Test
	public void testAverageNoRows() {
		testClassHasAverageMethod();

		int[][] aOrig = new int[][] {};

		int[][] a = new int[][] {};

		double expected = 0.0;
		double actual = 0.0;

		try {
			actual = (double) method.invoke(null, new Object[] { a });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + ")"
				+ " returns incorrect output of " + actual, expected, actual, epsilon);
		// a == aOrig
		assertArrayEquals(
				className + "." + methodName + "(" + Arrays.toString(aOrig) + ")" + " modified the \"a\" array", aOrig,
				a);
	}

	@Test
	public void testAverageSingleton() {
		testClassHasAverageMethod();

		int[][] aOrig = new int[][] {{1}};

		int[][] a = new int[][] {{1}};

		double expected = 1.0;
		double actual = 0.0;

		try {
			actual = (double) method.invoke(null, new Object[] { a });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + ")"
				+ " returns incorrect output of " + actual, expected, actual, epsilon);
		// a == aOrig
		assertArrayEquals(
				className + "." + methodName + "(" + Arrays.toString(aOrig) + ")" + " modified the \"a\" array", aOrig,
				a);
	}

	@Test
	public void testAverage1() {
		testClassHasAverageMethod();

		int[][] aOrig = new int[][] {{1,0,2},{3, 2, 1}};

		int[][] a = new int[][] {{1,0,2},{3, 2, 1}};

		double expected = 1.5;
		double actual = 0.0;

		try {
			actual = (double) method.invoke(null, new Object[] { a });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + ")"
				+ " returns incorrect output of " + actual, expected, actual, epsilon);
		// a == aOrig
		assertArrayEquals(
				className + "." + methodName + "(" + Arrays.toString(aOrig) + ")" + " modified the \"a\" array", aOrig,
				a);
	}

	@Test
	public void testAverage2() {
		testClassHasAverageMethod();

		int[][] aOrig = new int[][] {{1,1},{2,2},{3,3},{4,5}};

		int[][] a = new int[][] {{1,1},{2,2},{3,3},{4,5}};

		double expected = 2.625;
		double actual = 0.0;

		try {
			actual = (double) method.invoke(null, new Object[] { a });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + ")"
				+ " returns incorrect output of " + actual, expected, actual, epsilon);
		// a == aOrig
		assertArrayEquals(
				className + "." + methodName + "(" + Arrays.toString(aOrig) + ")" + " modified the \"a\" array", aOrig,
				a);
	}

	// END TESTS

	// ========================================================================
}
