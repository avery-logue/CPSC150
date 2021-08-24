import java.util.Scanner;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class P5Test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class P5Test
{
    /**
     * Default constructor for test class P5Test
     */
    public P5Test()
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
    public void readStudentTest()
    {
        Scanner input = new Scanner("Bo bby CPSC150 100 74 -1 PHYS151L 100 90 91 -1 done");
        
        Student expected = new Student("Bobby");
        
        ArrayList<Double> c1grades = new ArrayList<Double>();
        c1grades.add(100.0);
        c1grades.add(74.0);
        expected.addCourse("CPSC150", c1grades);
        
        //ArrayList<StudentCourse> courses = new ArrayList<StudentCourse>();
        
        ArrayList<Double> c2grades = new ArrayList<Double>();
        c2grades.add(100.0);
        c2grades.add(90.0);
        c2grades.add(91.0);
        expected.addCourse("PHYS151L", c2grades);
        
        Student actual = P5.readStudent(input);
        
        String err = "P5.readStudent(" + input + ") returned incorrect value of " + actual + ", expected " + expected;
        
        assertEquals(err, expected, actual);
    }
    
    @Test
    public void calcAverageTest()
    {
        ArrayList<Student> input = new ArrayList<Student>();
        
        Student s1 = new Student("Jambo");
        ArrayList<Double> s1grades = new ArrayList<Double>();
        s1grades.add(100.0);
        s1grades.add(74.0);
        ArrayList<StudentCourse> courses1 = new ArrayList<StudentCourse>();
        s1.addCourse("CPSC150", s1grades);
        
        Student s2 = new Student("Jimbles");
        ArrayList<Double> s2grades = new ArrayList<Double>();
        s2grades.add(96.0);
        s2grades.add(94.0);
        ArrayList<StudentCourse> courses2 = new ArrayList<StudentCourse>();
        s2.addCourse("CPSC150", s2grades);
        
        input.add(s1);
        
        input.add(s2);
        
        double actual = P5.calcAverage(input);
        
        double expected = 91.0;
        
        double delta = 0.0001;
        
        String err = "P5.calcAverage(" + input + ") returned incorrect value of " + actual + ", expected " + expected;
        
        assertEquals(err, expected, actual, delta);
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
