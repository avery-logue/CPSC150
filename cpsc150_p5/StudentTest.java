import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StudentTest.
 *
 * @author  William Dzubak
 * @author Avery Logue
 * 
 * @version December 6th, 2017
 */
public class StudentTest
{
    /**
     * Default constructor for test class StudentTest
     */
    public StudentTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    @Test
    public void getNameTest()
    {
        Student test = new Student("William");
        
        String expected = "William";
        
        String actual = test.getName();
        
        String err = "test.getName() returned incorrect output of " + actual + ", expected " + expected;
        
        assertEquals(err, expected, actual);
    }
    
    @Test
    public void getCoursesTest()
    {
        Student test = new Student("William");
        
        test.addCourse("CPSC150", new ArrayList<Double>());
        
        test.addCourse("CPSC125", new ArrayList<Double>());
        
        ArrayList<StudentCourse> expected = new ArrayList<StudentCourse>();
        
        expected.add(new StudentCourse("CPSC150", new ArrayList<Double>()));
        
        expected.add(new StudentCourse("CPSC125", new ArrayList<Double>()));
        
        //String actual = test.getCourses();
        
        //String err = "test.getCourses() returned incorrect output of " + actual + ", expected " + expected;
        
        //assertEquals(err, expected, actual);
    }
    
    @Test
    public void getCourseAverageTest()
    {
        String input = "PHYS151L";
        
        Student test = new Student("Bob");
        
        ArrayList<Double> CPSC150Grades = new ArrayList<Double>();
        
        String name1 = "CPSC150";
        
        CPSC150Grades.add(100.0);
        
        CPSC150Grades.add(76.0);
        
        test.addCourse(name1, CPSC150Grades);
        
        ArrayList<Double> PHYS151LGrades = new ArrayList<Double>();
        
        String name2 = "PHYS151L";
        
        PHYS151LGrades.add(100.0);
        
        PHYS151LGrades.add(85.0);
        
        PHYS151LGrades.add(93.5);
        
        test.addCourse(name2, PHYS151LGrades);
        
        double expected = 93.67;
        
        double actual = test.getCourseAverage(input);
        
        double delta = 0.0001;
        
        String err = "test.getCourseAverage(" + input + ") returned incorrect output of " + actual + ", expected " + expected;
        
        assertEquals(err, expected, actual, delta);
    }
    
    @Test
    public void calcAverageTest()
    {
        Student test = new Student("JuiceIsJustFunWater");
        
        ArrayList<Double> CPSC150Grades = new ArrayList<Double>();
        
        String name1 = "CPSC150";
        CPSC150Grades.add(100.0);
        CPSC150Grades.add(74.0);
        test.addCourse(name1, CPSC150Grades);
        
        ArrayList<Double> PHYS151LGrades = new ArrayList<Double>();
        
        String name2 = "PHYS151L";
        PHYS151LGrades.add(100.0);
        PHYS151LGrades.add(90.0);
        PHYS151LGrades.add(91.0);
        test.addCourse(name2, PHYS151LGrades);
        
        double expected = 90.33;
        double actual = test.calcAverage();
        double delta = 0.0001;
        
        String err = "test.calcAverage() returned incorrect output of " + actual + ", expected " + expected;
        
        assertEquals(err, expected, actual, delta);
    }
    
    @Test
    public void getSummaryTest()
    {
        Student test = new Student("John");
        
        ArrayList<Double> CPSC150Grades = new ArrayList<Double>();
        
        String name1 = "CPSC150";
        CPSC150Grades.add(100.0);
        CPSC150Grades.add(74.0);
        test.addCourse(name1, CPSC150Grades);
        
        ArrayList<Double> PHYS151LGrades = new ArrayList<Double>();
        
        String name2 = "PHYS151L";
        PHYS151LGrades.add(100.0);
        PHYS151LGrades.add(90.0);
        PHYS151LGrades.add(91.0);
        test.addCourse(name2, PHYS151LGrades);
        
        //*studentName* Average: *averageOfAllCourses* Courses: *courseNames*
        String expected = "John Average: 90.33 Courses: CPSC150 PHYS151L";
        
        String actual = test.getSummary();
        
        String err = "test.getSummary() returned incorrect output of " + actual + ", expected " + expected;
        
        assertEquals(err, expected, actual);
    }
    
    @Test
    public void toStringTest()
    {
        Student test = new Student("Bobby");
        
        ArrayList<Double> CPSC150Grades = new ArrayList<Double>();
        
        String name1 = "CPSC150";
        CPSC150Grades.add(100.0);
        CPSC150Grades.add(74.0);
        test.addCourse(name1, CPSC150Grades);
        
        ArrayList<Double> PHYS151LGrades = new ArrayList<Double>();
        
        String name2 = "PHYS151L";
        PHYS151LGrades.add(100.0);
        PHYS151LGrades.add(90.0);
        PHYS151LGrades.add(91.0);
        test.addCourse(name2, PHYS151LGrades);
        
        String expected = "Bobby: [CPSC150 [100.0, 74.0], PHYS151L [100.0, 90.0, 91.0]]";
        
        String actual = test.toString();
        
        String err = "test.toString() returned incorrect output of " + actual + ", expected " + expected;
        
        assertEquals(err, expected, actual);
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
