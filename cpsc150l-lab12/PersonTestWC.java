import java.lang.reflect.*;

/**
 * The test class testPersonName2.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PersonTestWC extends junit.framework.TestCase
{
	/**
	 * Default constructor for test class testPersonName2
	 */
	public PersonTestWC()
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

	public void testReflection()
	{
		// This test ensures you use a PersonName object
		boolean flag = false;
		Class<?> iClass  = Person.class;
		for (Field field : iClass.getDeclaredFields()) {
			if (field.getType().equals(PersonName.class))
				flag = true;
		}

		assertTrue("Use a PersonName object", flag);
	}

	public void testOneName()
	{
		// This test checks to see that the
		// default constructor is properly defined and that the
		// accessor methods work properly
		Person One = new Person();
		String value;
		value = One.getName();
		value=value.trim();
		while (value.indexOf("  ")>=0)
		{
			value=value.replace("  "," ");
		}
		assertEquals("Person() failed: name not initialized to \"no name\"",value.equals("no name"),true);
		int agevalue = One.getAge();
		assertEquals("Person() failed: age not initialized to 0",agevalue,0);
	}


	public void testTwoName()
	{
		// This test checks to see that the
		// default constructor is properly defined and that the
		// accessor methods work properly

		Person One = new Person("Bobby Smith",12);
		String value;
		value = One.getName();
		value=value.trim();
		while (value.indexOf("  ")>=0)
		{
			value=value.replace("  "," ");
		}
		assertEquals("Test for Name of Constructor fails:"+value+":",value,"Bobby Smith");
		int agevalue = One.getAge();
		assertEquals("Test for age of Constructor fails",agevalue,12);
	}

	public void testThreeName()
	{
		// This test checks to see that the
		// default constructor is properly defined and that the
		// accessor methods work properly

		Person One = new Person("Bobby Smith",20);
		String value;
		value = One.getName();
		value=value.trim();
		while (value.indexOf("  ")>=0)
		{
			value=value.replace("  "," ");
		}

		assertEquals("Test for Name of Constructor2 fails"+value+":",value.equals("Bobby Smith"),true);
		int agevalue = One.getAge();
		assertEquals("Test for age of Constructor fails",agevalue,20);
		One.setName("Tom Jones");
		value = One.getName();
		value=value.trim();
		while (value.indexOf("  ")>=0)
		{
			value=value.replace("  "," ");
		}

		assertEquals("Test for Name setter fails",value.equals("Tom Jones"),true);
		One.setAge(32);
		agevalue = One.getAge();
		assertEquals("Test for Age setter fails",agevalue,32);
	}

	public void testCanDrive()
	{
		// This test checks to see that the
		// default constructor is properly defined and that the
		// accessor methods work properly
		boolean value;
		{
			Person One = new Person("Bobby Smith",20);
			value = One.canDrive();
			assertEquals("Test non-static canDrive fails: above driving age",value,true);
		}
		{
			Person One = new Person("Bobby Smith",12);
			value = One.canDrive();
			assertEquals("Test non-static canDrive fails: under driving age",value,false);
		}
		value = Person.canDrive(20);
		assertEquals("Test static canDrive fails: above driving age",value,true);

		value = Person.canDrive(12);
		assertEquals("Test static canDrive fails: under driving age",value,false);

		value = Person.canDrive(16);
		assertEquals("Test static canDrive fails: Boundary case (at driving age)",value,true);
	}
}
