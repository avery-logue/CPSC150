import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.*;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CourseTestThin {
    private Class<?> cls;
    private Class<?> ret;
    private Class<?>[] params;
    private Method method;
    private Constructor<?> ctor;

    private static PrintStream console;
    private static ByteArrayOutputStream out;
    private static InputStream in;

    // EDIT THIS TO MATCH YOUR CLASS
    private String className = "Course";
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
        String[] fieldNames = {"name", "days", "nbrMeetingsPerWeek", "startTime", "endTime"};
        Class<?>[] fieldTypes = {String.class, char[].class, int.class, Time.class, Time.class};
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
        params = new Class<?>[]{String.class, Time.class, Time.class, String.class};
        String[] fieldNames = {"name", "days", "nbrMeetingsPerWeek", "startTime", "endTime"};
        Class<?>[] fieldTypes = {String.class, char[].class, int.class, Time.class, Time.class};
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

        String name = "CPSC150";
        String days = "MWF";
        Time startTime = new Time(9,0);
        Time endTime = new Time(9,50);

        String expected = "CPSC150: M 09:00-09:50" + lineend +
                "CPSC150: W 09:00-09:50" + lineend +
                "CPSC150: F 09:00-09:50" + lineend;
        String actual = "";

        Object instance = null;

        try {
            instance = ctor.newInstance(name, startTime, endTime, days);
            actual = (String) method.invoke(instance);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help." + e.toString());
        }

        String err = String.format(
                "%s.%s() returned an incorrect value of %s.\nname: %s, days: %s, startTime: %s, endTime: %s",
                className, methodName, actual, name, days, startTime.toString(), endTime.toString()
        );
        assertEquals(err, expected, actual);
    }

    @Test
    public void testToString2() {
        testClassHasConstructor();
        testClassHasToStringMethod();

        String name = "ENGR213";
        String days = "TR";
        Time startTime = new Time(11,0);
        Time endTime = new Time(12,15);

        String expected = "ENGR213: T 11:00-12:15" + lineend +
                "ENGR213: R 11:00-12:15" + lineend;
        String actual = "";

        Object instance = null;

        try {
            instance = ctor.newInstance(name, startTime, endTime, days);
            actual = (String) method.invoke(instance);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help." + e.toString());
        }

        String err = String.format(
                "%s.%s() returned an incorrect value of %s.\nname: %s, days: %s, startTime: %s, endTime: %s",
                className, methodName, actual, name, days, startTime.toString(), endTime.toString()
        );
        assertEquals(err, expected, actual);
    }

    @Test
    public void testToString3() {
        testClassHasConstructor();
        testClassHasToStringMethod();

        String name = "ENGR213";
        String days = "TR";
        Time startTime = new Time(16,30);
        Time endTime = new Time(17,45);

        String expected = "ENGR213: T 16:30-17:45" + lineend +
                "ENGR213: R 16:30-17:45" + lineend;
        String actual = "";

        Object instance = null;

        try {
            instance = ctor.newInstance(name, startTime, endTime, days);
            actual = (String) method.invoke(instance);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help." + e.toString());
        }

        String err = String.format(
                "%s.%s() returned an incorrect value of %s.\nname: %s, days: %s, startTime: %s, endTime: %s",
                className, methodName, actual, name, days, startTime.toString(), endTime.toString()
        );
        assertEquals(err, expected, actual);
    }
    // END TESTS
}
