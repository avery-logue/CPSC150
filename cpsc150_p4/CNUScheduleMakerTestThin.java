import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.*;
import java.util.Scanner;

import static org.junit.Assert.*;

public class CNUScheduleMakerTestThin {
    private Class<?> cls;
    private Class<?> ret;
    private Class<?>[] params;
    private Method method;
    private Constructor<?> ctor;

    private static PrintStream console;
    private static ByteArrayOutputStream out;
    private static InputStream in;

    // EDIT THIS TO MATCH YOUR CLASS
    private String className = "CNUScheduleMaker";
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
        ctor = null;
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

    public void setPrivateFieldValue(String fName, Object obj, Object val) {
        try {
            Field f = cls.getDeclaredField(fName);
            f.setAccessible(true);
            f.set(obj, val);
            f.setAccessible(false);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static String array2String(Object[] arr) {
        String out = "{";
        for (Object o : arr)
            out += o.toString();
        return out.substring(0, out.length() - 2) + "x";
    }

    // Constructor
    @Test
    public void testClassHasConstructor() {
        // EDIT THESE TO MATCH YOUR METHOD
        params = new Class<?>[]{Scanner.class};
        String[] fieldNames = {"kbd", "courses"};
        Class<?>[] fieldTypes = {Scanner.class, Course[].class};
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

        for (int i = 0; i < fieldNames.length; i++) {
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
    @Test
    public void testConstructor1() {
        testClassHasConstructor();

        Object actual = null;
        Scanner input = new Scanner("");

        try {
            actual = (Object) ctor.newInstance(new Object[]{input});
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help.");
        }

        Scanner actualKbd = (Scanner) getPrivateFieldValue("kbd", actual);
        Course[] actualCourses = (Course[]) getPrivateFieldValue("courses", actual);

        String err = String.format(
                "%s.%s(%s) constructed a %s object with a Scanner that differs from the parameter",
                className, ctor.getName(), "Scanner", className
        );
        assertEquals(err, input, actualKbd);

        err = String.format(
                "%s.%s(%s) constructed a %s object with a nonnull courses array",
                className, ctor.getName(), "Scanner", className
        );
        assertNull(err, actualCourses);
    }
    // END TESTS

    // getDays
    @Test
    public void testClassHasGetDaysMethod() {
        // EDIT THESE TO MATCH YOUR METHOD
        methodName = "getDays";
        params = new Class<?>[]{String.class};
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
    public void testGetDaysModifiers() {
        testClassHasGetDaysMethod();

        int mods = method.getModifiers();
        assertTrue("Method \"" + methodName + "\" should be 'public'", Modifier.isPublic(mods));
        assertTrue("Method \"" + methodName + "\" should not be 'static'", !Modifier.isStatic(mods));
    }

    @Test
    public void testGetDaysReturnType() {
        testClassHasGetDaysMethod();

        Class<?> type = method.getReturnType();
        assertEquals(String.format("Method \"%s\" should return '%s' but returns '%s' instead", methodName, returnType,
                type.getSimpleName()), ret, type);
    }

    // TESTS HERE
    @Test
    public void testGetDays1() {
        testClassHasConstructor();
        testClassHasGetDaysMethod();

        String input = "MWF";
        Scanner inputKbd = new Scanner(input);
        String inputName = "CPSC150";

        String expected = "MWF";

        Object instance = null;
        String actual = "";

        try {
            instance = ctor.newInstance(inputKbd);
            actual = (String) method.invoke(instance, inputName);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help." + e.toString());
        }

        String err = String.format(
                "%s.%s(String) returned an incorrect value of %s.\ninput: %s",
                className, methodName, actual, input
        );
        assertEquals(err, expected, actual);
    }

    @Test
    public void testGetDays2() {
        testClassHasConstructor();
        testClassHasGetDaysMethod();

        String input = "ME MW";
        Scanner inputKbd = new Scanner(input);
        String inputName = "CPSC150";

        String expected = "MW";

        Object instance = null;
        String actual = "";

        try {
            instance = ctor.newInstance(inputKbd);
            actual = (String) method.invoke(instance, inputName);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help." + e.toString());
        }

        String err = String.format(
                "%s.%s(String) returned an incorrect value of %s.\ninput: %s",
                className, methodName, actual, input
        );
        assertEquals(err, expected, actual);
    }

    @Test
    public void testGetDays3() {
        testClassHasConstructor();
        testClassHasGetDaysMethod();

        String input = "R";
        Scanner inputKbd = new Scanner(input);
        String inputName = "CPSC150L";

        String expected = "R";

        Object instance = null;
        String actual = "";

        try {
            instance = ctor.newInstance(inputKbd);
            actual = (String) method.invoke(instance, inputName);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help." + e.toString());
        }

        String err = String.format(
                "%s.%s(String) returned an incorrect value of %s.\ninput: %s",
                className, methodName, actual, input
        );
        assertEquals(err, expected, actual);
    }

    @Test
    public void testGetDays4() {
        testClassHasConstructor();
        testClassHasGetDaysMethod();

        String input = "TR";
        Scanner inputKbd = new Scanner(input);
        String inputName = "ENGR213";

        String expected = "TR";

        Object instance = null;
        String actual = "";

        try {
            instance = ctor.newInstance(inputKbd);
            actual = (String) method.invoke(instance, inputName);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help." + e.toString());
        }

        String err = String.format(
                "%s.%s(String) returned an incorrect value of %s.\ninput: %s",
                className, methodName, actual, input
        );
        assertEquals(err, expected, actual);
    }
    // END TESTS

    // getStart
    @Test
    public void testClassHasGetStartMethod() {
        // EDIT THESE TO MATCH YOUR METHOD
        methodName = "getStart";
        params = new Class<?>[]{String.class};
        ret = Time.class;
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
    public void testGetStartModifiers() {
        testClassHasGetStartMethod();

        int mods = method.getModifiers();
        assertTrue("Method \"" + methodName + "\" should be 'public'", Modifier.isPublic(mods));
        assertTrue("Method \"" + methodName + "\" should not be 'static'", !Modifier.isStatic(mods));
    }

    @Test
    public void testGetStartReturnType() {
        testClassHasGetStartMethod();

        Class<?> type = method.getReturnType();
        assertEquals(String.format("Method \"%s\" should return '%s' but returns '%s' instead", methodName, returnType,
                type.getSimpleName()), ret, type);
    }

    // TESTS HERE
    // getStart
    @Test
    public void testGetStart1() {
        testClassHasConstructor();
        testClassHasGetStartMethod();

        String input = "0800";
        Scanner inputKbd = new Scanner(input);
        String inputName = "CPSC150";

        Time expected = new Time(8, 0);

        Object instance = null;
        Time actual = null;

        try {
            instance = ctor.newInstance(inputKbd);
            actual = (Time) method.invoke(instance, inputName);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help." + e.toString());
        }

        String err = String.format(
                "%s.%s(String) returned an incorrect value of %s.\ninput: %s",
                className, methodName, actual.toString(), input
        );
        assertEquals(err, expected.getHour(), actual.getHour());
        assertEquals(err, expected.getMinute(), actual.getMinute());
    }

    @Test
    public void testGetStart2() {
        testClassHasConstructor();
        testClassHasGetStartMethod();

        String input = "16:30";
        Scanner inputKbd = new Scanner(input);
        String inputName = "ENGR213";

        Time expected = new Time(16, 30);

        Object instance = null;
        Time actual = null;

        try {
            instance = ctor.newInstance(inputKbd);
            actual = (Time) method.invoke(instance, inputName);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help." + e.toString());
        }

        String err = String.format(
                "%s.%s(String) returned an incorrect value of %s.\ninput: %s",
                className, methodName, actual.toString(), input
        );
        assertEquals(err, expected.getHour(), actual.getHour());
        assertEquals(err, expected.getMinute(), actual.getMinute());
    }
    // END TESTS

    // getEnd
    @Test
    public void testClassHasGetEndMethod() {
        // EDIT THESE TO MATCH YOUR METHOD
        methodName = "getEnd";
        params = new Class<?>[]{String.class, Time.class};
        ret = Time.class;
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
    public void testGetEndModifiers() {
        testClassHasGetEndMethod();

        int mods = method.getModifiers();
        assertTrue("Method \"" + methodName + "\" should be 'public'", Modifier.isPublic(mods));
        assertTrue("Method \"" + methodName + "\" should not be 'static'", !Modifier.isStatic(mods));
    }

    @Test
    public void testGetEndReturnType() {
        testClassHasGetEndMethod();

        Class<?> type = method.getReturnType();
        assertEquals(String.format("Method \"%s\" should return '%s' but returns '%s' instead", methodName, returnType,
                type.getSimpleName()), ret, type);
    }

    // TESTS HERE
    @Test
    public void testGetEnd1() {
        testClassHasConstructor();
        testClassHasGetEndMethod();

        String input = "30";
        Time inStart = new Time(8, 0);
        Scanner inputKbd = new Scanner(input);
        String inputName = "CPSC150";

        Time expected = new Time(8, 30);

        Object instance = null;
        Time actual = null;

        try {
            instance = ctor.newInstance(inputKbd);
            actual = (Time) method.invoke(instance, inputName, inStart);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help." + e.toString());
        }

        String err = String.format(
                "%s.%s(String, Time) returned an incorrect value of %s.\ninput: %s start: %s",
                className, methodName, actual.toString(), input, inStart.toString()
        );
        assertEquals(err, expected.getHour(), actual.getHour());
        assertEquals(err, expected.getMinute(), actual.getMinute());
    }

    @Test
    public void testGetEnd2() {
        testClassHasConstructor();
        testClassHasGetEndMethod();

        String input = "50";
        Time inStart = new Time(9, 0);
        Scanner inputKbd = new Scanner(input);
        String inputName = "CPSC150";

        Time expected = new Time(9, 50);

        Object instance = null;
        Time actual = null;

        try {
            instance = ctor.newInstance(inputKbd);
            actual = (Time) method.invoke(instance, inputName, inStart);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help." + e.toString());
        }

        String err = String.format(
                "%s.%s(String, Time) returned an incorrect value of %s.\ninput: %s start: %s",
                className, methodName, actual.toString(), input, inStart.toString()
        );
        assertEquals(err, expected.getHour(), actual.getHour());
        assertEquals(err, expected.getMinute(), actual.getMinute());
    }
    // END TESTS
    // getInfo
    @Test
    public void testClassHasGetInfoMethod() {
        // EDIT THESE TO MATCH YOUR METHOD
        methodName = "getInfo";
        params = new Class<?>[]{};
        ret = void.class;
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
    public void testGetInfoModifiers() {
        testClassHasGetInfoMethod();

        int mods = method.getModifiers();
        assertTrue("Method \"" + methodName + "\" should be 'public'", Modifier.isPublic(mods));
        assertTrue("Method \"" + methodName + "\" should not be 'static'", !Modifier.isStatic(mods));
    }

    @Test
    public void testGetInfoReturnType() {
        testClassHasGetInfoMethod();

        Class<?> type = method.getReturnType();
        assertEquals(String.format("Method \"%s\" should return '%s' but returns '%s' instead", methodName, returnType,
                type.getSimpleName()), ret, type);
    }

    // TESTS HERE
    @Test
    public void testGetInfo1() {
        testClassHasConstructor();
        testClassHasGetInfoMethod();

        String input = "1 CPSC150 MWF 0900 50";
        Scanner inputKbd = new Scanner(input);

        Course[] expected = {
                new Course("CPSC150", new Time(9, 0), new Time(9, 50), "MWF")
        };

        Object instance = null;

        try {
            instance = ctor.newInstance(inputKbd);
            method.invoke(instance);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help." + e.toString());
        }

        Course[] actual = (Course[]) getPrivateFieldValue("courses", instance);

        String err = String.format(
                "%s.%s() filled out the courses array incorrectly, length was %d.\ninput: %s\n",
                className, methodName, actual.length, input
        );
        assertEquals(err, expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            err = String.format(
                    "%s.%s() filled out the courses array incorrectly, course %d's toString produced\n%s\ninput: %s\n",
                    className, methodName, i, actual[i].toString(), input
            );
            assertEquals(err, expected[i].toString(), actual[i].toString());
        }
    }

    @Test
    public void testGetInfo2() {
        testClassHasConstructor();
        testClassHasGetInfoMethod();

        String input = "2 CPSC150 MWF 0900 50 ENGR213 TG TR 16:30 75";
        Scanner inputKbd = new Scanner(input);

        Course[] expected = {
                new Course("CPSC150", new Time(9, 0), new Time(9, 50), "MWF"),
                new Course("ENGR213", new Time(16, 30), new Time(17, 45), "TR")
        };

        Object instance = null;

        try {
            instance = ctor.newInstance(inputKbd);
            method.invoke(instance);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help." + e.toString());
        }

        Course[] actual = (Course[]) getPrivateFieldValue("courses", instance);

        String err = String.format(
                "%s.%s() filled out the courses array incorrectly, length was %d.\ninput: %s\n",
                className, methodName, actual.length, input
        );
        assertEquals(err, expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            err = String.format(
                    "%s.%s() filled out the courses array incorrectly, course %d's toString produced\n%s\ninput: %s\n",
                    className, methodName, i, actual[i].toString(), input
            );
            assertEquals(err, expected[i].toString(), actual[i].toString());
        }
    }
    // END TESTS

    // printSchedule
    @Test
    public void testClassHasPrintScheduleMethod() {
        // EDIT THESE TO MATCH YOUR METHOD
        methodName = "printSchedule";
        params = new Class<?>[]{};
        ret = void.class;
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
    public void testPrintScheduleModifiers() {
        testClassHasPrintScheduleMethod();

        int mods = method.getModifiers();
        assertTrue("Method \"" + methodName + "\" should be 'public'", Modifier.isPublic(mods));
        assertTrue("Method \"" + methodName + "\" should not be 'static'", !Modifier.isStatic(mods));
    }

    @Test
    public void testPrintScheduleReturnType() {
        testClassHasPrintScheduleMethod();

        Class<?> type = method.getReturnType();
        assertEquals(String.format("Method \"%s\" should return '%s' but returns '%s' instead", methodName, returnType,
                type.getSimpleName()), ret, type);
    }

    // TESTS HERE
    @Test
    public void testPrintSchedule1() {
        testClassHasConstructor();
        testClassHasPrintScheduleMethod();

        String input = "1 CPSC150 MWF 0900 50";
        Scanner inputKbd = new Scanner(input);

        Course[] setArray = {
                new Course("CPSC150", new Time(9, 0), new Time(9, 50), "MWF")
        };

        String expected = "CPSC150: M 09:00-09:50" + lineend +
                "CPSC150: W 09:00-09:50" + lineend +
                "CPSC150: F 09:00-09:50" + lineend;


        Object instance = null;

        try {
            instance = ctor.newInstance(inputKbd);
            setPrivateFieldValue("courses", instance, setArray);
            method.invoke(instance);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help." + e.toString());
        }

        String actual = out.toString();
        Scanner expScan = new Scanner(expected);
        Scanner actScan = new Scanner(actual);

        String err;
        int line;
        for (line = 0; expScan.hasNextLine() && actScan.hasNextLine(); line++) {
            String expLine = expScan.nextLine();
            String actLine = actScan.nextLine();
            err = String.format(
                    "%s.%s() printed out the courses array incorrectly. Line %d disagrees.\n" +
                            "Your output: %s\nCorrect output: %s\ninput: %s\n",
                    className, methodName, line, actLine, expLine, input
            );
            assertEquals(err, expLine, actLine);
        }

        if (expScan.hasNextLine()) {
            int line2 = 0;
            while (expScan.hasNextLine())
                expScan.nextLine();
            err = String.format("%s.%s() printed out too few lines. Only printed %d lines, needed %d.\ninput: %s",
                    className, methodName, line, line + line2, input);
            fail(err);
        } else if (actScan.hasNextLine()) {
            int line2 = 0;
            while (actScan.hasNextLine())
                actScan.nextLine();
            err = String.format("%s.%s() printed out too many lines. Printed %d lines, needed %d.\ninput: %s",
                    className, methodName, line + line2, line, input);
            fail(err);
        }

    }

    @Test
    public void testPrintSchedule2() {
        testClassHasConstructor();
        testClassHasPrintScheduleMethod();

        String input = "2 CPSC150 MWF 0900 50 ENGR213 TG TR 16:30 75";
        Scanner inputKbd = new Scanner(input);

        Course[] setArray = {
                new Course("CPSC150", new Time(9, 0), new Time(9, 50), "MWF"),
                new Course("ENGR213", new Time(16, 30), new Time(17, 45), "TR")
        };

        String expected = "CPSC150: M 09:00-09:50" + lineend +
                "CPSC150: W 09:00-09:50" + lineend +
                "CPSC150: F 09:00-09:50" + lineend +
                "ENGR213: T 16:30-17:45" + lineend +
                "ENGR213: R 16:30-17:45" + lineend;


        Object instance = null;

        try {
            instance = ctor.newInstance(inputKbd);
            setPrivateFieldValue("courses", instance, setArray);
            method.invoke(instance);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            fail("Method \"" + invokation + "\" failed to execute. Ask your instructor for help." + e.toString());
        }

        String actual = out.toString();
        Scanner expScan = new Scanner(expected);
        Scanner actScan = new Scanner(actual);

        String err;
        int line;
        for (line = 0; expScan.hasNextLine() && actScan.hasNextLine(); line++) {
            String expLine = expScan.nextLine();
            String actLine = actScan.nextLine();
            err = String.format(
                    "%s.%s() printed out the courses array incorrectly. Line %d disagrees.\n" +
                            "Your output: %s\nCorrect output: %s\ninput: %s\n",
                    className, methodName, line, actLine, expLine, input
            );
            assertEquals(err, expLine, actLine);
        }

        if (expScan.hasNextLine()) {
            int line2 = 0;
            while (expScan.hasNextLine())
                expScan.nextLine();
            err = String.format("%s.%s() printed out too few lines. Only printed %d lines, needed %d.\ninput: %s",
                    className, methodName, line, line + line2, input);
            fail(err);
        } else if (actScan.hasNextLine()) {
            int line2 = 0;
            while (actScan.hasNextLine())
                actScan.nextLine();
            err = String.format("%s.%s() printed out too many lines. Printed %d lines, needed %d.\ninput: %s",
                    className, methodName, line + line2, line, input);
            fail(err);
        }
    }
    // END TESTS
}
