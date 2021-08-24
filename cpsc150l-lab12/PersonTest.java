import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonTest
{
    /**
     * Default constructor for test class PersonTest
     */
    public PersonTest()
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

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    @Test 
    public void ageTest1(){
     Person pres1 = new Person("George Washington", 30);
     boolean expected = true;
     boolean actual = pres1.canDrive(30);
     String err = "pres1.canDrive(30) returned an incorrect output of " + actual + " expected " + expected;
     assertEquals(err, expected, actual);
    }
    @Test 
    public void ageTest2(){
     Person pres8 = new Person("Martin Van Buren", 16);
     boolean expected = true;
     boolean actual = pres8.canDrive(16);
     String err = "Person.canDrive(16) returned an incorrect output of " + actual + " expected " + expected;
     assertEquals(err, expected, actual);
    }
    @Test 
    public void ageTest3(){
     Person morty = new Person("Morty Sanchez", 14);
     boolean expected = false;
     boolean actual = morty.canDrive(14);
     String err = "morty.canDrive(14) returned an incorrect output of " + actual + " expected " + expected;
     assertEquals(err, expected, actual);
    }
}
