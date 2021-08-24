

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class ArrayMethodsTest {
	private Class<?> cls;
	private Method method;

	// EDIT THIS TO MATCH YOUR CLASS
	private String className = "ArrayMethods";
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

	// swapArrayContents
	@Test
	public void testClassHasSwapArrayContentsMethod() {
		// EDIT THESE TO MATCH YOUR METHOD
		methodName = "swapArrayContents";
		argTypes = "int[],int[]";
		returnType = "void";
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
			method = cls.getMethod(methodName, int[].class, int[].class);
			// END EDIT
		} catch (NoSuchMethodException | SecurityException e) {
			fail("Class \"" + className + "\" doesn't have a \"" + methodName + "(" + argTypes
					+ ")\" method. (is the method name spelled right? are its parameters correct?)");
		}
		invokation = className + "." + methodName + "(" + argTypes + ")";
	}

	@Test
	public void testSwapArrayContentsModifiers() {
		testClassHasSwapArrayContentsMethod();

		int mods = method.getModifiers();
		assertTrue("Method \"" + methodName + "\" should be 'public'", Modifier.isPublic(mods));
		assertTrue("Method \"" + methodName + "\" should be 'static'", Modifier.isStatic(mods));
	}

	@Test
	public void testSwapArrayContentsReturnType() {
		testClassHasSwapArrayContentsMethod();

		Class<?> type = method.getReturnType();
		// EDIT THIS TO MATCH YOUR METHODS RETURN TYPE
		assertEquals(String.format("Method \"%s\" should return '%s' but returns '%s' instead", methodName, returnType,
				type.getSimpleName()), void.class, type);
		// END EDIT
	}

	// TESTS HERE
	@Test
	public void testSwapArrayContentsEmpty() {
		testClassHasSwapArrayContentsMethod();

		int[] aOrig = new int[] {};
		int[] bOrig = new int[] {};

		int[] a = Arrays.copyOf(aOrig, aOrig.length);
		int[] b = Arrays.copyOf(bOrig, bOrig.length);

		try {
			method.invoke(null, new Object[] { a, b });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// a == bOrig
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + "," + Arrays.toString(bOrig)
				+ ")" + " creates incorrect \"a\" array of " + Arrays.toString(a), bOrig, a);
		// b == aOrig
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + "," + Arrays.toString(bOrig)
				+ ")" + " creates incorrect \"b\" array of " + Arrays.toString(b), aOrig, b);
	}

	@Test
	public void testSwapArrayContents1() {
		testClassHasSwapArrayContentsMethod();

		int[] aOrig = new int[] { 1, 2, 3 };
		int[] bOrig = new int[] { 4, 5, 6 };

		int[] a = Arrays.copyOf(aOrig, aOrig.length);
		int[] b = Arrays.copyOf(bOrig, bOrig.length);

		try {
			method.invoke(null, new Object[] { a, b });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// a == bOrig
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + "," + Arrays.toString(bOrig)
				+ ")" + " creates incorrect \"a\" array of " + Arrays.toString(a), bOrig, a);
		// b == aOrig
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + "," + Arrays.toString(bOrig)
				+ ")" + " creates incorrect \"b\" array of " + Arrays.toString(b), aOrig, b);
	}

	@Test
	public void testSwapArrayContents2() {
		testClassHasSwapArrayContentsMethod();

		int[] aOrig = new int[] { 1, -1, 0, 4 };
		int[] bOrig = new int[] { -9, 87, 1337, 2 };

		int[] a = Arrays.copyOf(aOrig, aOrig.length);
		int[] b = Arrays.copyOf(bOrig, bOrig.length);

		try {
			method.invoke(null, new Object[] { a, b });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// a == bOrig
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + "," + Arrays.toString(bOrig)
				+ ")" + " creates incorrect \"a\" array of " + Arrays.toString(a), bOrig, a);
		// b == aOrig
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + "," + Arrays.toString(bOrig)
				+ ")" + " creates incorrect \"b\" array of " + Arrays.toString(b), aOrig, b);
	}

	// END TESTS

	// ========================================================================

	// replaceLessThan
	@Test
	public void testClassHasReplaceLessThanMethod() {
		// EDIT THESE TO MATCH YOUR METHOD
		methodName = "replaceLessThan";
		argTypes = "";
		returnType = "void";
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
			method = cls.getMethod(methodName, int[].class, int.class);
			// END EDIT
		} catch (NoSuchMethodException | SecurityException e) {
			fail("Class \"" + className + "\" doesn't have a \"" + methodName + "(" + argTypes
					+ ")\" method. (is the method name spelled right? are its parameters correct?)");
		}
		invokation = className + "." + methodName + "(" + argTypes + ")";
	}

	@Test
	public void testReplaceLessThanModifiers() {
		testClassHasReplaceLessThanMethod();

		int mods = method.getModifiers();
		assertTrue("Method \"" + methodName + "\" should be 'public'", Modifier.isPublic(mods));
		assertTrue("Method \"" + methodName + "\" should be 'static'", Modifier.isStatic(mods));
	}

	@Test
	public void testReplaceLessThanReturnType() {
		testClassHasReplaceLessThanMethod();

		Class<?> type = method.getReturnType();
		// EDIT THIS TO MATCH YOUR METHODS RETURN TYPE
		assertEquals(String.format("Method \"%s\" should return '%s' but returns '%s' instead", methodName, returnType,
				type.getSimpleName()), void.class, type);
		// END EDIT
	}

	// TESTS HERE
	@Test
	public void testReplaceLessThanEmpty() {
		testClassHasReplaceLessThanMethod();

		int[] aOrig = new int[] {};

		int[] a = Arrays.copyOf(aOrig, aOrig.length);
		int n = 0;

		int[] expected = new int[] {};

		try {
			method.invoke(null, new Object[] { a, n });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// a == expected
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + "," + n + ")"
				+ " creates incorrect \"a\" array of " + Arrays.toString(a), expected, a);
	}

	@Test
	public void testReplaceLessThanSingleton1() {
		testClassHasReplaceLessThanMethod();

		int[] aOrig = new int[] { 1 };

		int[] a = Arrays.copyOf(aOrig, aOrig.length);
		int n = 0;

		int[] expected = new int[] { 1 };

		try {
			method.invoke(null, new Object[] { a, n });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// a == expected
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + "," + n + ")"
				+ " creates incorrect \"a\" array of " + Arrays.toString(a), expected, a);
	}

	@Test
	public void testReplaceLessThanSingleton2() {
		testClassHasReplaceLessThanMethod();

		int[] aOrig = new int[] { 2 };

		int[] a = Arrays.copyOf(aOrig, aOrig.length);
		int n = 3;

		int[] expected = new int[] { 3 };

		try {
			method.invoke(null, new Object[] { a, n });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// a == expected
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + "," + n + ")"
				+ " creates incorrect \"a\" array of " + Arrays.toString(a), expected, a);
	}

	@Test
	public void testReplaceLessThan1() {
		testClassHasReplaceLessThanMethod();

		int[] aOrig = new int[] { 1, 1, 2, 3, 5 };

		int[] a = Arrays.copyOf(aOrig, aOrig.length);
		int n = 3;

		int[] expected = new int[] { 3, 3, 3, 3, 5 };

		try {
			method.invoke(null, new Object[] { a, n });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// a == expected
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + "," + n + ")"
				+ " creates incorrect \"a\" array of " + Arrays.toString(a), expected, a);
	}

	@Test
	public void testReplaceLessThan2() {
		testClassHasReplaceLessThanMethod();

		int[] aOrig = new int[] { 97, 101, -200, 1337, 72, 9001, 0, 4, 20 };

		int[] a = Arrays.copyOf(aOrig, aOrig.length);
		int n = -1;

		int[] expected = new int[] { 97, 101, -1, 1337, 72, 9001, 0, 4, 20 };

		try {
			method.invoke(null, new Object[] { a, n });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// a == expected
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + "," + n + ")"
				+ " creates incorrect \"a\" array of " + Arrays.toString(a), expected, a);
	}

	// END TESTS

	// ========================================================================

	// replaceLessThan
	@Test
	public void testClassHasCopyAndReplaceLessThanMethod() {
		// EDIT THESE TO MATCH YOUR METHOD
		methodName = "copyAndReplaceLessThan";
		argTypes = "";
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
			method = cls.getMethod(methodName, int[].class, int.class);
			// END EDIT
		} catch (NoSuchMethodException | SecurityException e) {
			fail("Class \"" + className + "\" doesn't have a \"" + methodName + "(" + argTypes
					+ ")\" method. (is the method name spelled right? are its parameters correct?)");
		}
		invokation = className + "." + methodName + "(" + argTypes + ")";
	}

	@Test
	public void testCopyAndReplaceLessThanModifiers() {
		testClassHasCopyAndReplaceLessThanMethod();

		int mods = method.getModifiers();
		assertTrue("Method \"" + methodName + "\" should be 'public'", Modifier.isPublic(mods));
		assertTrue("Method \"" + methodName + "\" should be 'static'", Modifier.isStatic(mods));
	}

	@Test
	public void testCopyAndReplaceLessThanReturnType() {
		testClassHasCopyAndReplaceLessThanMethod();

		Class<?> type = method.getReturnType();
		// EDIT THIS TO MATCH YOUR METHODS RETURN TYPE
		assertEquals(String.format("Method \"%s\" should return '%s' but returns '%s' instead", methodName, returnType,
				type.getSimpleName()), int[].class, type);
		// END EDIT
	}

	// TESTS HERE
	@Test
	public void testCopyAndReplaceLessThanEmpty() {
		testClassHasCopyAndReplaceLessThanMethod();

		int[] aOrig = new int[] {};

		int[] a = Arrays.copyOf(aOrig, aOrig.length);
		int n = 0;

		int[] expected = new int[] {};
		int[] actual = null;

		try {
			actual = (int[]) method.invoke(null, new Object[] { a, n });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + "," + n + ")"
				+ " creates incorrect \"a\" array of " + Arrays.toString(actual), expected, actual);
		// a == aOrig
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + "," + n + ")"
				+ " modified the \"a\" array", aOrig, a);
	}

	@Test
	public void testCopyAndReplaceLessThanSingleton1() {
		testClassHasCopyAndReplaceLessThanMethod();

		int[] aOrig = new int[] { 1 };

		int[] a = Arrays.copyOf(aOrig, aOrig.length);
		int n = 0;

		int[] expected = new int[] { 1 };
		int[] actual = null;

		try {
			actual = (int[]) method.invoke(null, new Object[] { a, n });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + "," + n + ")"
				+ " creates incorrect \"a\" array of " + Arrays.toString(actual), expected, actual);
		// a == aOrig
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + "," + n + ")"
				+ " modified the \"a\" array", aOrig, a);
	}

	@Test
	public void testCopyAndReplaceLessThanSingleton2() {
		testClassHasCopyAndReplaceLessThanMethod();

		int[] aOrig = new int[] { 2 };

		int[] a = Arrays.copyOf(aOrig, aOrig.length);
		int n = 3;

		int[] expected = new int[] { 3 };
		int[] actual = null;

		try {
			actual = (int[]) method.invoke(null, new Object[] { a, n });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + "," + n + ")"
				+ " creates incorrect \"a\" array of " + Arrays.toString(actual), expected, actual);
		// a == aOrig
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + "," + n + ")"
				+ " modified the \"a\" array", aOrig, a);
	}

	@Test
	public void testCopyAndReplaceLessThan1() {
		testClassHasCopyAndReplaceLessThanMethod();

		int[] aOrig = new int[] { 1, 1, 2, 3, 5 };

		int[] a = Arrays.copyOf(aOrig, aOrig.length);
		int n = 3;

		int[] expected = new int[] { 3, 3, 3, 3, 5 };
		int[] actual = null;

		try {
			actual = (int[]) method.invoke(null, new Object[] { a, n });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + "," + n + ")"
				+ " creates incorrect \"a\" array of " + Arrays.toString(actual), expected, actual);
		// a == aOrig
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + "," + n + ")"
				+ " modified the \"a\" array", aOrig, a);
	}

	@Test
	public void testCopyAndReplaceLessThan2() {
		testClassHasCopyAndReplaceLessThanMethod();

		int[] aOrig = new int[] { 97, 101, -200, 1337, 72, 9001, 0, 4, 20 };

		int[] a = Arrays.copyOf(aOrig, aOrig.length);
		int n = -1;

		int[] expected = new int[] { 97, 101, -1, 1337, 72, 9001, 0, 4, 20 };
		int[] actual = null;

		try {
			actual = (int[]) method.invoke(null, new Object[] { a, n });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + "," + n + ")"
				+ " creates incorrect \"a\" array of " + Arrays.toString(actual), expected, actual);
		// a == aOrig
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + "," + n + ")"
				+ " modified the \"a\" array", aOrig, a);
	}

	// END TESTS

	// ========================================================================

	// reverse
	@Test
	public void testClassHasReverseEachMethod() {
		// EDIT THESE TO MATCH YOUR METHOD
		methodName = "reverse";
		argTypes = "";
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
			method = cls.getMethod(methodName, int[].class);
			// END EDIT
		} catch (NoSuchMethodException | SecurityException e) {
			fail("Class \"" + className + "\" doesn't have a \"" + methodName + "(" + argTypes
					+ ")\" method. (is the method name spelled right? are its parameters correct?)");
		}
		invokation = className + "." + methodName + "(" + argTypes + ")";
	}

	@Test
	public void testReverseModifiers() {
		testClassHasReverseEachMethod();

		int mods = method.getModifiers();
		assertTrue("Method \"" + methodName + "\" should be 'public'", Modifier.isPublic(mods));
		assertTrue("Method \"" + methodName + "\" should be 'static'", Modifier.isStatic(mods));
	}

	@Test
	public void testReverseReturnType() {
		testClassHasReverseEachMethod();

		Class<?> type = method.getReturnType();
		// EDIT THIS TO MATCH YOUR METHODS RETURN TYPE
		assertEquals(String.format("Method \"%s\" should return '%s' but returns '%s' instead", methodName, returnType,
				type.getSimpleName()), int[].class, type);
		// END EDIT
	}

	// TESTS HERE
	@Test
	public void testReverseEmpty() {
		testClassHasReverseEachMethod();

		int[] aOrig = new int[] {};

		int[] a = Arrays.copyOf(aOrig, aOrig.length);

		int[] expected = new int[] {};
		int[] actual = null;

		try {
			actual = (int[]) method.invoke(null, new Object[] { a });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + ")"
				+ " creates incorrect \"a\" array of " + Arrays.toString(actual), expected, actual);
		// a == aOrig
		assertArrayEquals(
				className + "." + methodName + "(" + Arrays.toString(aOrig) + ")" + " modified the \"a\" array", aOrig,
				a);
	}

	@Test
	public void testReverseSingleton() {
		testClassHasReverseEachMethod();

		int[] aOrig = new int[] { 1 };

		int[] a = Arrays.copyOf(aOrig, aOrig.length);

		int[] expected = new int[] { 1 };
		int[] actual = null;

		try {
			actual = (int[]) method.invoke(null, new Object[] { a });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + ")"
				+ " creates incorrect \"a\" array of " + Arrays.toString(actual), expected, actual);
		// a == aOrig
		assertArrayEquals(
				className + "." + methodName + "(" + Arrays.toString(aOrig) + ")" + " modified the \"a\" array", aOrig,
				a);
	}

	@Test
	public void testReverse1() {
		testClassHasReverseEachMethod();

		int[] aOrig = new int[] { 1, 2, 3, 4 };

		int[] a = Arrays.copyOf(aOrig, aOrig.length);

		int[] expected = new int[] { 4, 3, 2, 1 };
		int[] actual = null;

		try {
			actual = (int[]) method.invoke(null, new Object[] { a });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + ")"
				+ " creates incorrect \"a\" array of " + Arrays.toString(actual), expected, actual);
		// a == aOrig
		assertArrayEquals(
				className + "." + methodName + "(" + Arrays.toString(aOrig) + ")" + " modified the \"a\" array", aOrig,
				a);
	}

	@Test
	public void testReverse2() {
		testClassHasReverseEachMethod();

		int[] aOrig = new int[] { 5, 4, 3, 2, 1 };

		int[] a = Arrays.copyOf(aOrig, aOrig.length);

		int[] expected = new int[] { 1, 2, 3, 4, 5 };
		int[] actual = null;

		try {
			actual = (int[]) method.invoke(null, new Object[] { a });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + ")"
				+ " creates incorrect \"a\" array of " + Arrays.toString(actual), expected, actual);
		// a == aOrig
		assertArrayEquals(
				className + "." + methodName + "(" + Arrays.toString(aOrig) + ")" + " modified the \"a\" array", aOrig,
				a);
	}

	@Test
	public void testReverse3() {
		testClassHasReverseEachMethod();

		int[] aOrig = new int[] { 1, -2, 3, -4, 5, -6, 9001 };

		int[] a = Arrays.copyOf(aOrig, aOrig.length);

		int[] expected = new int[] { 9001, -6, 5, -4, 3, -2, 1 };
		int[] actual = null;

		try {
			actual = (int[]) method.invoke(null, new Object[] { a });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + ")"
				+ " creates incorrect \"a\" array of " + Arrays.toString(actual), expected, actual);
		// a == aOrig
		assertArrayEquals(
				className + "." + methodName + "(" + Arrays.toString(aOrig) + ")" + " modified the \"a\" array", aOrig,
				a);
	}

	@Test
	public void testReverse4() {
		testClassHasReverseEachMethod();

		int[] aOrig = new int[] { 1, 2, -200, 89, -1, 0 };

		int[] a = Arrays.copyOf(aOrig, aOrig.length);

		int[] expected = new int[] { 0, -1, 89, -200, 2, 1 };
		int[] actual = null;

		try {
			actual = (int[]) method.invoke(null, new Object[] { a });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
		}

		// actual == expected
		assertArrayEquals(className + "." + methodName + "(" + Arrays.toString(aOrig) + ")"
				+ " creates incorrect \"a\" array of " + Arrays.toString(actual), expected, actual);
		// a == aOrig
		assertArrayEquals(
				className + "." + methodName + "(" + Arrays.toString(aOrig) + ")" + " modified the \"a\" array", aOrig,
				a);
	}

	// END TESTS

}
