import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The test class testPersonName9B.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PersonNameTest
{
	/**
	 * Default constructor for test class testPersonName2
	 */
	public PersonNameTest()
	{
	}

	/**
	 * Sets up the test fixture.
	 *
	 * Called before every test case method.
	 */
	protected void setUp()
	{
	}

	/**
	 * Tears down the test fixture.
	 *
	 * Called after every test case method.
	 */
	protected void tearDown()
	{
	}

	public String makeErrMesg(String mesg, String expected, String actual)
	{
		return mesg +" Expected: " +expected + " Actual: " + actual;
	}

	@Test
	public void testQuestion1Constr1(){
		PersonName p = new PersonName();
		String n;
		n = p.getFirstName();
		assertEquals("Fails Initialize First Name",n,"");

		n = p.getMiddleName();
		assertEquals("Fails Initialize Middle Name",n,"");

		n = p.getLastName();
		assertEquals("Fails Initialize Last Name",n,"");

		n = p.getSuffixName();
		assertEquals("Fails Initialize Suffix Name",n,"");

		int numberNames = p.getNumberOfNames();
		assertEquals("Fails Initialize Number of Names",numberNames,0);
	}

	@Test
	public void testQuestion1Constr2(){
		PersonName p = new PersonName();
		String n;
		p.setFirstName("Mary");

		p.setMiddleName("Jo");

		p.setLastName("Turner");

		n = p.getFirstName();
		assertEquals("Fails Initialize First Name",n,"Mary");

		n = p.getMiddleName();
		assertEquals("Fails Initialize Middle Name",n,"Jo");

		n = p.getLastName();
		assertEquals("Fails Initialize Last Name",n,"Turner");

		n = p.getSuffixName();
		assertEquals("Fails Initialize Suffix Name",n,"");

		int numberNames = p.getNumberOfNames();
		assertEquals("Fails Initialize Number of Names",numberNames,3);
	}

	@Test
	public void testQuestion1Constr3(){
		PersonName p = new PersonName();
		String n;
		p.setFirstName("Bob");

		p.setSuffixName("Jr");


		n = p.getFirstName();
		assertEquals("Fails Initialize First Name",n,"Bob");

		n = p.getMiddleName();
		assertEquals("Fails Initialize Middle Name",n,"");

		n = p.getLastName();
		assertEquals("Fails Initialize Last Name",n,"");

		n = p.getSuffixName();
		assertEquals("Fails Initialize Suffix Name",n,"Jr");

		int numberNames = p.getNumberOfNames();
		assertEquals("Fails Initialize Number of Names",numberNames,2);
	}

	@Test
	public void testQuestion1Constr4(){
		PersonName p = new PersonName();
		String n;
		p.setFirstName("Bob");

		p.setSuffixName("Jr");

		p.setFirstName("Tom");


		n = p.getFirstName();
		assertEquals("Fails ReInitialize First Name",n,"Tom");

		n = p.getMiddleName();
		assertEquals("Fails Initialize Middle Name",n,"");

		n = p.getLastName();
		assertEquals("Fails Initialize Last Name",n,"");

		n = p.getSuffixName();
		assertEquals("Fails Initialize Suffix Name",n,"Jr");

		int numberNames = p.getNumberOfNames();
		assertEquals("Fails Initialize Number of Names when same name changed",numberNames,2);
	}

	@Test
	public void testQuestion1Constr5(){
		PersonName p = new PersonName();
		String n;
		p.setFirstName("Mary");

		p.setMiddleName("Jo");

		p.setLastName("Turner");

		p.setSuffixName("DDS");

		n = p.getFirstName();
		assertEquals("Fails Initialize First Name",n,"Mary");

		n = p.getMiddleName();
		assertEquals("Fails Initialize Middle Name",n,"Jo");

		n = p.getLastName();
		assertEquals("Fails Initialize Last Name",n,"Turner");

		n = p.getSuffixName();
		assertEquals("Fails Initialize Suffix Name",n,"DDS");

		int numberNames = p.getNumberOfNames();
		assertEquals("Fails Initialize Number of Names",numberNames,4);
	}
	@Test
	public void testOneName()
	{
		// This test checks to see that the
		// default constructor is properly defined and that the
		// accessor methods work properly
		String name = "Bobby";
		PersonName One = new PersonName(name);
		String value, emesg;
		value = One.getFirstName();
		emesg = makeErrMesg("first name incorrect.", "Bobby", value);
		assertEquals(emesg, value.equals("Bobby"),true);
		value = One.getMiddleName();
		emesg = makeErrMesg("middle name incorrect.", "", value);
		assertEquals(emesg, value.equals(""),true);
		value = One.getLastName();
		emesg = makeErrMesg("last name incorrect.", "", value);
		assertEquals(emesg, value.equals(""),true);
		value = One.getSuffixName();
		emesg = makeErrMesg("suffix name incorrect.", "", value);
		assertEquals(emesg, value.equals(""),true);
		value = One.getInitials();
		emesg = makeErrMesg("initials incorrect.", "B", value);
		assertEquals(emesg, value.equals("B"),true);
		value = One.getEntireName();
		emesg = makeErrMesg("entire name incorrect.", name, value);
		assertTrue(emesg, name.equals(value));
		int numname = One.getNumberOfNames();
		emesg = makeErrMesg("num names incorrect.", "1", Integer.toString(numname));
		assertEquals(emesg,numname,1);
	}

	@Test
	public void testTwoName()
	{
		// This test checks to see that the
		// default constructor is properly defined and that the
		// accessor methods work properly
		String name = "Bobby Smith";
		PersonName One = new PersonName(name);
		String value, emesg;

		value = One.getFirstName();
		emesg = makeErrMesg("first name incorrect.", "Bobby", value);
		assertEquals(emesg, value.equals("Bobby"),true);
		value = One.getMiddleName();
		emesg = makeErrMesg("middle name incorrect.", "", value);
		assertEquals(emesg, value.equals(""),true);
		value = One.getLastName();
		emesg = makeErrMesg("last name incorrect.", "Smith", value);
		assertEquals(emesg, value.equals("Smith"),true);
		value = One.getSuffixName();
		emesg = makeErrMesg("suffix name incorrect.", "", value);
		assertEquals(emesg, value.equals(""),true);
		value = One.getInitials();
		emesg = makeErrMesg("initials incorrect.", "BS", value);
		assertEquals(emesg, value.equals("BS"),true);
		value = One.getEntireName();
		emesg = makeErrMesg("entire name incorrect.", name, value);
		assertTrue(emesg, name.equals(value));
		int numname = One.getNumberOfNames();
		emesg = makeErrMesg("num names incorrect.", "2", Integer.toString(numname));
		assertEquals(emesg,numname,2);
	}

	@Test
	public void testThreeName()
	{
		// This test checks to see that the
		// default constructor is properly defined and that the
		// accessor methods work properly
		String name = "Bobby Paul Smith";
		PersonName One = new PersonName(name);
		String value, emesg;

		value = One.getFirstName();
		emesg = makeErrMesg("first name incorrect.", "Bobby", value);
		assertEquals(emesg, value.equals("Bobby"),true);
		value = One.getMiddleName();
		emesg = makeErrMesg("middle name incorrect.", "Paul", value);
		assertEquals(emesg, value.equals("Paul"),true);
		value = One.getLastName();
		emesg = makeErrMesg("last name incorrect.", "Smith", value);
		assertEquals(emesg, value.equals("Smith"),true);
		value = One.getSuffixName();
		emesg = makeErrMesg("suffix name incorrect.", "", value);
		assertEquals(emesg, value.equals(""),true);
		value = One.getInitials();
		emesg = makeErrMesg("initials incorrect.", "BPS", value);
		assertEquals(emesg, value.equals("BPS"),true);
		value = One.getEntireName();
		emesg = makeErrMesg("entire name incorrect.", name, value);
		assertTrue(emesg, name.equals(value));
		int numname = One.getNumberOfNames();
		emesg = makeErrMesg("num names incorrect.", "3", Integer.toString(numname));
		assertEquals(emesg,numname,3);
	}

	@Test
	public void testFourName()
	{
		// This test checks to see that the
		// default constructor is properly defined and that the
		// accessor methods work properly
		String name = "Bobby Paul Smith Jr.";
		PersonName One = new PersonName(name);
		String value;
		String emesg;

		value = One.getFirstName();
		emesg = makeErrMesg("first name incorrect.", "Bobby", value);
		assertEquals(emesg, value.equals("Bobby"),true);
		value = One.getMiddleName();
		emesg = makeErrMesg("middle name incorrect	.", "Paul", value);
		assertEquals(emesg, value.equals("Paul"),true);
		value = One.getLastName();
		emesg = makeErrMesg("last name incorrect.", "Smith", value);
		assertEquals(emesg, value.equals("Smith"),true);
		value = One.getSuffixName();
		emesg = makeErrMesg("suffix name incorrect.", "Jr.", value);
		assertEquals(emesg, value.equals("Jr."),true);
		value = One.getInitials();
		emesg = makeErrMesg("initials incorrect.", "BPS", value);
		assertEquals(emesg, value.equals("BPS"),true);
		value = One.getEntireName();
		emesg = makeErrMesg("entire name incorrect.", name, value);
		assertTrue(emesg, name.equals(value));
		int numname = One.getNumberOfNames();
		emesg = makeErrMesg("num names incorrect.", "4", Integer.toString(numname));
		assertEquals(emesg,numname,4);
	}
}
