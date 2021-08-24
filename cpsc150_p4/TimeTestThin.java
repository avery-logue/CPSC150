import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.*;

import static org.junit.Assert.*;

public class TimeTestThin {
    private Class<?> cls;
    private Class<?> ret;
    private Class<?>[] params;
    private Method method;
    private Constructor<?> ctor;

    private static PrintStream console;
    private static ByteArrayOutputStream out;
    private static InputStream in;

    // EDIT THIS TO MATCH YOUR CLASS
    private String className = "Time";
    // END EDIT
    private String methodName = "";
    private String argTypes = "";
    private String invokation = "";
    private String returnType = "";

    private double epsilon = 0.001;

    private String lineend = System.getProperty("line.separator");

    @BeforeClass
    public static void beforeTestsBegin() {
        console = System.out;
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        in = System.in;
    }

    @AfterClass
    public static void afterTestsEnd() {
        System.setOut(console);
        System.setIn(in);
    }

    @Before
    public void beforeEachTest() {
        cls = null;
        returnType = null;
        method = null;
        ret = null;
        params = null;
        methodName = "";
        argTypes = "";
        invokation = "";
        returnType = "";
    }

    @After
    public void afterEachTest() {
        out.reset();
    }

    public static String typeList2String(Class<?>[] p) {
        String o = "";

        if (p.length > 0) {
            o += p[0].toString();
            for (int i = 1; i < p.length; ++i)
                o += "," + p[i].toString();
        }
        return o;
    }

    public Object getPrivateFieldValue(String fName, Object obj) {
        try {
            Field f = cls.getDeclaredField(fName);
            f.setAccessible(true);
            Object o = f.get(obj);
            f.setAccessible(false);
            return o;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String array2String(Object[] arr) {
        String out = "{";
        for (Object o : arr)
            out += o.toString();
        return out.substring(0, out.length() - 2) + "x";
    }

    // Blank Constructor
    @Test
    public void testClassHasBlankConstructor() {
        // EDIT THESE TO MATCH YOUR METHOD
        params = new Class<?>[]{};
        String[] fieldNames = {"hour", "minute"};
        Class<?>[] fieldTypes = {int.class, int.class};
        // END EDIT
        // class exists
        argTypes = typeList2String(params);
        try {
            Package pkg = getClass().getPackage();
            String path = pkg == null ? "" : pkg.getName() + ".";
            cls = Class.forName(path + className);
        } catch (ClassNotFoundException e) {
            fail("File \"" + className + ".class\" doesn't have a \"" + className
                    + "\" class. (is the class name spelled right?)");
        }

        Field[] fields = cls.getDeclaredFields();
        for (Field f : fields) {
            if (!Modifier.isPrivate(f.getModifiers()))
                fail(
                        String.format("Field %s in class %s must be private",
                                f.getName(), className)
                );
        }

        for (int i = 0 ; i < fieldNames.length ; i++) {
            try {
                Field f = cls.getDeclaredField(fieldNames[i]);
                if (!f.getType().equals(fieldTypes[i]))
                    fail(
                            String.format("Field %s in class %s must have type %s",
                                    fieldNames[i], className, fieldTypes[i].getName())
                    );
            } catch (NoSuchFieldException e) {
                fail(
                        String.format("Class %s must have a field named %s",
                                className, fieldNames[i])
                );
            }
        }

        // class has method
        try {
            ctor = cls.getConstructor(params);
        } catch (NoSuchMethodException | SecurityException e) {
            fail("Class \"" + className + "\" doesn't have a \"" + ctor.getName() + "(" + argTypes
                    + ")\" method. (is the method name spelled right? are its parameters correct?)");
        }
        invokation = className + "." + methodName + "(" + argTypes + ")";
    }

    @Test
    public void testBlankConstructorModifiers() {
        testClassHasBlankConstructor();

        int mods = ctor.getModifiers();
        assertTrue("Method \"" + methodName + "\" should be 'public'", Modifier.isPublic(mods));
        assertTrue("Method \"" + methodName + "\" should not be 'static'", !Modifier.isStatic(mods));
    }

    // TESTS HERE
    // END TESTS

    // Constructor
    @Test
    public void testClassHasConstructor() {
        // EDIT THESE TO MATCH YOUR METHOD
        params = new Class<?>[]{int.class, int.class};
        String[] fieldNames = {"hour", "minute"};
        Class<?>[] fieldTypes = {int.class, int.class};
        // END EDIT
        // class exists
        argTypes = typeList2String(params);
        try {
            Package pkg = getClass().getPackage();
            String path = pkg == null ? "" : pkg.getName() + ".";
            cls = Class.forName(path + className);
        } catch (ClassNotFoundException e) {
            fail("File \"" + className + ".class\" doesn't have a \"" + className
                    + "\" class. (is the class name spelled right?)");
        }

        Field[] fields = cls.getDeclaredFields();
        for (Field f : fields) {
            if (!Modifier.isPrivate(f.getModifiers()))
                fail(
                        String.format("Field %s in class %s must be private",
                                f.getName(), className)
                );
        }

        for (int i = 0 ; i < fieldNames.length ; i++) {
            try {
                Field f = cls.getDeclaredField(fieldNames[i]);
                if (!f.getType().equals(fieldTypes[i]))
                    fail(
                            String.format("Field %s in class %s must have type %s",
                                    fieldNames[i], className, fieldTypes[i].getName())
                    );
            } catch (NoSuchFieldException e) {
                fail(
                        String.format("Class %s must have a field named %s",
                                className, fieldNames[i])
                );
            }
        }

        // class has method
        try {
            ctor = cls.getConstructor(params);
        } catch (NoSuchMethodException | SecurityException e) {
            fail("Class \"" + className + "\" doesn't have a \"" + ctor.getName() + "(" + argTypes
                    + ")\" method. (is the method name spelled right? are its parameters correct?)");
        }
        invokation = className + "." + methodName + "(" + argTypes + ")";
    }

    @Test
    public void testConstructorModifiers() {
        testClassHasConstructor();

        int mods = ctor.getModifiers();
        assertTrue("Method \"" + methodName + "\" should be 'public'", Modifier.isPublic(mods));
        assertTrue("Method \"" + methodName + "\" should not be 'static'", !Modifier.isStatic(mods));
    }

    // TESTS HERE
    // END TESTS

    // addMinutes
    @Test
    public void testClassHasAddMinutesMethod() {
        // EDIT THESE TO MATCH YOUR METHOD
        methodName = "addMinutes";
        params = new Class<?>[]{int.class};
        ret = cls;
        // END EDIT
        // class exists
        argTypes = typeList2String(params);
        try {
            Package pkg = getClass().getPackage();
            String path = pkg == null ? "" : pkg.getName() + ".";
            cls = Class.forName(path + className);
        } catch (ClassNotFoundException e) {
            fail("File \"" + className + ".class\" doesn't have a \"" + className
                    + "\" class. (is the class name spelled right?)");
        }

        if (ret == null)
            ret = cls;

        returnType = ret.toString();

        // class has method
        try {
            method = cls.getMethod(methodName, params);
        } catch (NoSuchMethodException | SecurityException e) {
            fail("Class \"" + className + "\" doesn't have a \"" + methodName + "(" + argTypes
                    + ")\" method. (is the method name spelled right? are its parameters correct?)");
        }
        invokation = className + "." + methodName + "(" + argTypes + ")";
    }

    @Test
    public void testAddMinutesModifiers() {
        testClassHasAddMinutesMethod();

        int mods = method.getModifiers();
        assertTrue("Method \"" + methodName + "\" should be 'public'", Modifier.isPublic(mods));
        assertTrue("Method \"" + methodName + "\" should not be 'static'", !Modifier.isStatic(mods));
    }

    @Test
    public void testAddMinutesReturnType() {
        testClassHasAddMinutesMethod();

        Class<?> type = method.getReturnType();
        assertEquals(String.format("Method \"%s\" should return '%s' but returns '%s' instead", methodName, returnType,
                type.getSimpleName()), ret, type);
    }

    // TESTS HERE
    @Test
    public void testAddMinutes1() {
        testClassHasConstructor();
        testClassHasAddMinutesMethod();

        int startH = 10;
        int startM = 0;
        int length = 50;

        int expectedH = 10;
        int expectedM = 50;

        Object instance = null;
        Object actual = null;

        try {
            instance = ctor.newInstance(startH, startM);
            actual = method.invoke(instance, length);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help." + e.toString());
        }

        int actualH = ((Integer) getPrivateFieldValue("hour", actual)).intValue();
        int actualM = ((Integer) getPrivateFieldValue("minute", actual)).intValue();

        String err = String.format(
                "%s.%s(%d) constructed an incorrect %s object.\nBefore: hour: %d minute %d\nAfter: hour: %d minute: %d",
                className, methodName, length, className, startH, startM, actualH, actualM
        );
        assertEquals(err, expectedH, actualH);
        err = String.format(
                "%s.%s(%d) constructed an incorrect %s object.\nBefore: hour: %d minute %d\nAfter: hour: %d minute: %d",
                className, methodName, length, className, startH, startM, actualH, actualM
        );
        assertEquals(err, expectedM, actualM);
    }

    @Test
    public void testAddMinutes2() {
        testClassHasConstructor();
        testClassHasAddMinutesMethod();

        int startH = 10;
        int startM = 0;
        int length = 75;

        int expectedH = 11;
        int expectedM = 15;

        Object instance = null;
        Object actual = null;

        try {
            instance = ctor.newInstance(startH, startM);
            actual = method.invoke(instance, length);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help." + e.toString());
        }

        int actualH = ((Integer) getPrivateFieldValue("hour", actual)).intValue();
        int actualM = ((Integer) getPrivateFieldValue("minute", actual)).intValue();

        String err = String.format(
                "%s.%s(%d) constructed an incorrect %s object.\nBefore: hour: %d minute %d\nAfter: hour: %d minute: %d",
                className, methodName, length, className, startH, startM, actualH, actualM
        );
        assertEquals(err, expectedH, actualH);
        err = String.format(
                "%s.%s(%d) constructed an incorrect %s object.\nBefore: hour: %d minute %d\nAfter: hour: %d minute: %d",
                className, methodName, length, className, startH, startM, actualH, actualM
        );
        assertEquals(err, expectedM, actualM);
    }

    @Test
    public void testAddMinutes3() {
        testClassHasConstructor();
        testClassHasAddMinutesMethod();

        int startH = 17;
        int startM = 30;
        int length = 140;

        int expectedH = 19;
        int expectedM = 50;

        Object instance = null;
        Object actual = null;

        try {
            instance = ctor.newInstance(startH, startM);
            actual = method.invoke(instance, length);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help." + e.toString());
        }

        int actualH = ((Integer) getPrivateFieldValue("hour", actual)).intValue();
        int actualM = ((Integer) getPrivateFieldValue("minute", actual)).intValue();

        String err = String.format(
                "%s.%s(%d) constructed an incorrect %s object.\nBefore: hour: %d minute %d\nAfter: hour: %d minute: %d",
                className, methodName, length, className, startH, startM, actualH, actualM
        );
        assertEquals(err, expectedH, actualH);
        err = String.format(
                "%s.%s(%d) constructed an incorrect %s object.\nBefore: hour: %d minute %d\nAfter: hour: %d minute: %d",
                className, methodName, length, className, startH, startM, actualH, actualM
        );
        assertEquals(err, expectedM, actualM);
    }
    // END TESTS

    // getMinute
    @Test
    public void testClassHasGetMinuteMethod() {
        // EDIT THESE TO MATCH YOUR METHOD
        methodName = "getMinute";
        params = new Class<?>[]{};
        ret = int.class;
        // END EDIT
        // class exists
        argTypes = typeList2String(params);
        try {
            Package pkg = getClass().getPackage();
            String path = pkg == null ? "" : pkg.getName() + ".";
            cls = Class.forName(path + className);
        } catch (ClassNotFoundException e) {
            fail("File \"" + className + ".class\" doesn't have a \"" + className
                    + "\" class. (is the class name spelled right?)");
        }

        if (ret == null)
            ret = cls;

        returnType = ret.toString();

        // class has method
        try {
            method = cls.getMethod(methodName, params);
        } catch (NoSuchMethodException | SecurityException e) {
            fail("Class \"" + className + "\" doesn't have a \"" + methodName + "(" + argTypes
                    + ")\" method. (is the method name spelled right? are its parameters correct?)");
        }
        invokation = className + "." + methodName + "(" + argTypes + ")";
    }

    @Test
    public void testGetMinuteModifiers() {
        testClassHasGetMinuteMethod();

        int mods = method.getModifiers();
        assertTrue("Method \"" + methodName + "\" should be 'public'", Modifier.isPublic(mods));
        assertTrue("Method \"" + methodName + "\" should not be 'static'", !Modifier.isStatic(mods));
    }

    @Test
    public void testGetMinuteReturnType() {
        testClassHasGetMinuteMethod();

        Class<?> type = method.getReturnType();
        assertEquals(String.format("Method \"%s\" should return '%s' but returns '%s' instead", methodName, returnType,
                type.getSimpleName()), ret, type);
    }

    // TESTS HERE
    @Test
    public void testGetMinute1() {
        testClassHasConstructor();
        testClassHasGetMinuteMethod();

        int initHour = 10;
        int initMin = 0;

        Object instance = null;
        int actual = 0;

        try {
            instance = ctor.newInstance(initHour, initMin);
            actual = ((Integer)method.invoke(instance)).intValue();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help." + e.toString());
        }

        String err = String.format(
                "%s.%s() returned an incorrect value of %d, expected %d.",
                className, methodName, actual, initMin
        );
        assertEquals(err, initMin, actual);
    }
    // END TESTS

    // getHour
    @Test
    public void testClassHasGetHourMethod() {
        // EDIT THESE TO MATCH YOUR METHOD
        methodName = "getHour";
        params = new Class<?>[]{};
        ret = int.class;
        // END EDIT
        // class exists
        argTypes = typeList2String(params);
        try {
            Package pkg = getClass().getPackage();
            String path = pkg == null ? "" : pkg.getName() + ".";
            cls = Class.forName(path + className);
        } catch (ClassNotFoundException e) {
            fail("File \"" + className + ".class\" doesn't have a \"" + className
                    + "\" class. (is the class name spelled right?)");
        }

        if (ret == null)
            ret = cls;

        returnType = ret.toString();

        // class has method
        try {
            method = cls.getMethod(methodName, params);
        } catch (NoSuchMethodException | SecurityException e) {
            fail("Class \"" + className + "\" doesn't have a \"" + methodName + "(" + argTypes
                    + ")\" method. (is the method name spelled right? are its parameters correct?)");
        }
        invokation = className + "." + methodName + "(" + argTypes + ")";
    }

    @Test
    public void testGetHourModifiers() {
        testClassHasGetHourMethod();

        int mods = method.getModifiers();
        assertTrue("Method \"" + methodName + "\" should be 'public'", Modifier.isPublic(mods));
        assertTrue("Method \"" + methodName + "\" should not be 'static'", !Modifier.isStatic(mods));
    }

    @Test
    public void testGetHourReturnType() {
        testClassHasGetHourMethod();

        Class<?> type = method.getReturnType();
        assertEquals(String.format("Method \"%s\" should return '%s' but returns '%s' instead", methodName, returnType,
                type.getSimpleName()), ret, type);
    }

    // TESTS HERE
    @Test
    public void testGetHour1() {
        testClassHasConstructor();
        testClassHasGetHourMethod();

        int initHour = 10;
        int initMin = 0;

        Object instance = null;
        int actual = 0;

        try {
            instance = ctor.newInstance(initHour, initMin);
            actual = ((Integer)method.invoke(instance)).intValue();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help." + e.toString());
        }

        String err = String.format(
                "%s.%s() returned an incorrect value of %d, expected %d.",
                className, methodName, actual, initHour
        );
        assertEquals(err, initHour, actual);
    }
    // END TESTS

    // toString
    @Test
    public void testClassHasToStringMethod() {
        // EDIT THESE TO MATCH YOUR METHOD
        methodName = "toString";
        params = new Class<?>[]{};
        ret = String.class;
        // END EDIT
        // class exists
        argTypes = typeList2String(params);
        try {
            Package pkg = getClass().getPackage();
            String path = pkg == null ? "" : pkg.getName() + ".";
            cls = Class.forName(path + className);
        } catch (ClassNotFoundException e) {
            fail("File \"" + className + ".class\" doesn't have a \"" + className
                    + "\" class. (is the class name spelled right?)");
        }

        if (ret == null)
            ret = cls;

        returnType = ret.toString();

        // class has method
        try {
            method = cls.getMethod(methodName, params);
        } catch (NoSuchMethodException | SecurityException e) {
            fail("Class \"" + className + "\" doesn't have a \"" + methodName + "(" + argTypes
                    + ")\" method. (is the method name spelled right? are its parameters correct?)");
        }
        invokation = className + "." + methodName + "(" + argTypes + ")";
    }

    @Test
    public void testToStringModifiers() {
        testClassHasToStringMethod();

        int mods = method.getModifiers();
        assertTrue("Method \"" + methodName + "\" should be 'public'", Modifier.isPublic(mods));
        assertTrue("Method \"" + methodName + "\" should not be 'static'", !Modifier.isStatic(mods));
    }

    @Test
    public void testToStringReturnType() {
        testClassHasToStringMethod();

        Class<?> type = method.getReturnType();
        assertEquals(String.format("Method \"%s\" should return '%s' but returns '%s' instead", methodName, returnType,
                type.getSimpleName()), ret, type);
    }

    // TESTS HERE
    @Test
    public void testToString1() {
        testClassHasConstructor();
        testClassHasToStringMethod();

        int initH = 10;
        int initM = 0;

        Object instance = null;
        String actual = "";
        String expected = "10:00";

        try {
            instance = ctor.newInstance(initH, initM);
            actual = (String) method.invoke(instance);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help." + e.toString());
        }

        String err = String.format(
                "%s.%s() returned an incorrect value of %s when fields are hour: %d minute: %d.",
                className, methodName, actual, initH, initM
        );
        assertEquals(err, expected, actual);
    }

    @Test
    public void testToString2() {
        testClassHasConstructor();
        testClassHasToStringMethod();

        int initH = 23;
        int initM = 55;

        Object instance = null;
        String actual = "";
        String expected = "23:55";

        try {
            instance = ctor.newInstance(initH, initM);
            actual = (String) method.invoke(instance);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help." + e.toString());
        }

        String err = String.format(
                "%s.%s() returned an incorrect value of %s when fields are hour: %d minute: %d.",
                className, methodName, actual, initH, initM
        );
        assertEquals(err, expected, actual);
    }

    @Test
    public void testToString3() {
        testClassHasConstructor();
        testClassHasToStringMethod();

        int initH = 13;
        int initM = 37;

        Object instance = null;
        String actual = "";
        String expected = "13:37";

        try {
            instance = ctor.newInstance(initH, initM);
            actual = (String) method.invoke(instance);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help." + e.toString());
        }

        String err = String.format(
                "%s.%s() returned an incorrect value of %s when fields are hour: %d minute: %d.",
                className, methodName, actual, initH, initM
        );
        assertEquals(err, expected, actual);
    }
    // END TESTS
}
