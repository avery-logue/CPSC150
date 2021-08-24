import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PersonNameTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PersonNameTest
{
    /**
     * Default constructor for test class PersonNameTest
     */
    public PersonNameTest()
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
    public void numberNamesTest1()
    {
        String input = "Avery F. Logue";
        int expected = 3;
        int actual = PersonName.numberNames(input);
        String err = String.format("PersonName.numberNames(\"%s\") returns an incorrect value of %d, expected %d", input, actual, expected);
        assertEquals(err, expected, actual);
    }
     @Test
    public void numberNamesTest2()
    {
        String input = "William Henry Harrison";
        int expected = 3;
        int actual = PersonName.numberNames(input);
        String err = String.format("PersonName.numberNames(\"%s\") returns an incorrect value of %d, expected %d", input, actual, expected);
        assertEquals(err, expected, actual);
    }
     @Test
    public void numberNamesTest3()
    {
        String input = "JFK";
        int expected = 1;
        int actual = PersonName.numberNames(input);
        String err = String.format("PersonName.numberNames(\"%s\") returns an incorrect value of %d, expected %d", input, actual, expected);
        assertEquals(err, expected, actual);
    }
     @Test
    public void numberNamesTest4()
    {
        String input = "Richard Nixon";
        int expected = 2;
        int actual = PersonName.numberNames(input);
        String err = String.format("PersonName.numberNames(\"%s\") returns an incorrect value of %d, expected %d", input, actual, expected);
        assertEquals(err, expected, actual);
    }
     @Test
    public void numberNamesTest5()
    {
        String input = "";
        int expected = 0;
        int actual = PersonName.numberNames(input);
        String err = String.format("PersonName.numberNames(\"%s\") returns an incorrect value of %d, expected %d", input, actual, expected);
        assertEquals(err, expected, actual);
    }

}
