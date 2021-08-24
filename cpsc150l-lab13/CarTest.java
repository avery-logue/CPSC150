import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

/**
 * Test class for the Car class.
 *
 * @author Roberto A. Flores
 * @version 1.0
 */
public class CarTest {
	/**
	 * Minimum number of passengers on a car.
	 * Usually, it indicates 4 passengers.
	 */
	private static final int MIN_CAPACITY = 4;
	/**
	 * Maximum number of passengers on a car.
	 * Usually, it indicates 8 passengers.
	 */
	private static final int MAX_CAPACITY = 8;
	/**
	 * Minimum age to drive a car.
	 * Usually, it is 16 years old.
	 */
	private static final int MIN_DRIVING_AGE = 16;
	private Person[] person;

	/**
	 * This method receives 2 arrays of Person objects, named expected and result,
	 * and checks that both arrays hold the exact persons -- where a person is
	 * considered equal to another if they have the same name and age.
	 * Index location is not significant. This means that a person in expected
	 * can be found in a different index location in result.
	 * @param expected Expected array of persons.
	 * @param result Actual result to verify.
	 */
	private void assertPassengersEquals(Person[] expected, Person[] result) {
		assertEquals( expected.length, result.length );
		// checking that expected passengers exist
		for (int i = 0; i < expected.length; i++) {
			if (expected[ i ] != null) {
				boolean found = false;
				for (int j = 0; j < result.length && !found; j++) {
					if (result[ j ] != null &&
						result[ j ].getAge()    ==    expected[ i ].getAge() &&
						result[ j ].getName().equals( expected[ i ].getName() )) {
						found = true;
					}
				}
				assertTrue( found );
			}
		}
		// checking that both have same number of empty spaces
		int emptyExpected = 0;
		for (int i = 0; i < expected.length; i++) {
			if (expected[ i ] == null) {
				emptyExpected++;
			}
		}
		int emptyResult   = 0;
		for (int i = 0; i < result.length; i++) {
			if (result[ i ] == null) {
				emptyResult++;
			}
		}
		assertEquals( emptyExpected, emptyResult );
	}
	/**
	 * This method initializes any variables needed in
	 * each and all tests. In particular, it initializes
	 * an array of Person objects used in tests.
	 */
	@Before
	public void setUp() {
		person = new Person[] {
			new Person("Anton",   10),
			new Person("Costa",   11),
			new Person("Dali",    12),
			new Person("Dave",    13),
			new Person("Ed",      14),
			new Person("Lynn",    15),
			new Person("Ming",    16),
			new Person("Peter",   17),
			new Person("Raouf",   18),
			new Person("Roberto", 19),
			new Person("Toni",    20)
		};
	}

	/**
	 * Tests the initial capacity of a default car.
	 */
	@Test
	public void testNewDefaultCarCapacityOcuppancyDriverPassengers() {
		Car car = new Car();

		assertEquals( MIN_CAPACITY, car.getCapacity() );
		assertEquals( 0, car.getOccupancy() );
		assertEquals( null, car.getDriver() );

		Person[] result   = car.getPassengers();
		Person[] expected = new Person[ MIN_CAPACITY ];
		assertPassengersEquals( expected, result );
	}

	/**
	 * Tests the initial capacity of cars.
	 * Cars should be created with capacities in the range
	 * MIN_CAPACITY and MAX_CAPACITY only.
	 */
	@Test
	public void testNewCarCapacityOcuppancyDriverPassengers() {
		Car car;
		Person[] result;
		Person[] expected;

		car = new Car( MIN_CAPACITY - 1 );
		assertEquals ( MIN_CAPACITY, car.getCapacity() );
		assertEquals ( 0, car.getOccupancy() );
		assertEquals ( null, car.getDriver() );

		result   = car.getPassengers();
		expected = new Person[ MIN_CAPACITY ];
		assertPassengersEquals( expected, result );

		car = new Car( MIN_CAPACITY );
		assertEquals ( MIN_CAPACITY, car.getCapacity() );
		assertEquals ( 0, car.getOccupancy() );
		assertEquals ( null, car.getDriver() );

		result   = car.getPassengers();
		expected = new Person[ MIN_CAPACITY ];
		assertPassengersEquals( expected, result );

		car = new Car( MAX_CAPACITY );
		assertEquals ( MAX_CAPACITY, car.getCapacity() );
		assertEquals ( 0, car.getOccupancy() );
		assertEquals ( null, car.getDriver() );

		result   = car.getPassengers();
		expected = new Person[ MAX_CAPACITY ];
		assertPassengersEquals( expected, result );

		car = new Car( MAX_CAPACITY + 1 );
		assertEquals ( MAX_CAPACITY, car.getCapacity() );
		assertEquals ( 0, car.getOccupancy() );
		assertEquals ( null, car.getDriver() );

		result   = car.getPassengers();
		expected = new Person[ MAX_CAPACITY ];
		assertPassengersEquals( expected, result );
	}

	/**
	 * Tests adding passengers into default and custom capacity cars.
	 * Test 1) adding a "null" passenger [fails]
	 */
	@Test
	public void testAddPassenger01() {
		Car car;
		/* Testing cars with default capacity */
		// (1) adding a "null" passenger [fails]
		car = new Car();
		assertFalse ( car.addPassenger( null ));

		/* Testing cars with a given capacity */
		// (1) adding a "null" passenger [fails]
		car = new Car( 5 );
		assertFalse ( car.addPassenger( null ));
	}

	/**
	 * Tests adding passengers into default and custom capacity cars.
	 * Test 2) adding one passenger when empty
	 */
	@Test
	public void testAddPassenger02() {
		Car car;
		/* Testing cars with default capacity */
		// (2) adding one passenger when empty
		car = new Car();
		assertTrue  ( car.addPassenger( person[1] ));

		/* Testing cars with a given capacity */
		// (2) adding one passenger when empty
		car = new Car( 6 );
		assertTrue  ( car.addPassenger( person[1] ));
	}

	/**
	 * Tests adding passengers into default and custom capacity cars.
	 * Test 3) adding a duplicated passenger [fails]
	 */
	@Test
	public void testAddPassenger03() {
		Car car;
		/* Testing cars with default capacity */
		// (3) adding a duplicated passenger [fails]
		car = new Car();
		assertTrue  ( car.addPassenger( person[1] ));
		assertFalse ( car.addPassenger( person[1] ));

		/* Testing cars with a given capacity */
		// (3) adding a duplicated passenger [fails]
		car = new Car( 7 );
		assertTrue  ( car.addPassenger( person[1] ));
		assertFalse ( car.addPassenger( person[1] ));
	}

	/**
	 * Tests adding passengers into default and custom capacity cars.
	 * Test 5) adding passengers beyond capacity [fails]
	 */
	@Test
	public void testAddPassenger05() {
		Car car;
		/* Testing cars with default capacity */
		// (5) adding passengers beyond capacity
		//  a) adding passengers to a 4-person car
		car = new Car();
		assertTrue ( car.addPassenger( person[1] ));
		assertTrue ( car.addPassenger( person[2] ));
		assertTrue ( car.addPassenger( person[3] ));
		assertTrue ( car.addPassenger( person[4] ));
		assertFalse( car.addPassenger( person[5] ));

		/* Testing cars with a given capacity */
		// (5) adding passengers beyond capacity
		//  a) adding passengers to an 8-person car
		car = new Car( 8 );
		assertTrue ( car.addPassenger( person[1] ));
		assertTrue ( car.addPassenger( person[2] ));
		assertTrue ( car.addPassenger( person[3] ));
		assertTrue ( car.addPassenger( person[4] ));
		assertTrue ( car.addPassenger( person[5] ));
		assertTrue ( car.addPassenger( person[6] ));
		assertTrue ( car.addPassenger( person[7] ));
		assertTrue ( car.addPassenger( person[8] ));
		assertFalse( car.addPassenger( person[9] ));
	}

	/**
	 * Tests that passengers can be retrieved.
	 * Test 1) no passengers when adding a "null" passenger
	 */
	@Test
	public void testGetPassengers01() {
		// (1) no passengers when adding a "null" passenger
		//  a) adding passenger
		Car car = new Car();
		assertFalse ( car.addPassenger( null ));
		//  b) checking that there are no passengers
		Person[] result   = car.getPassengers();
		Person[] expected = new Person[ MIN_CAPACITY ];
		assertPassengersEquals( expected, result );
	}

	/**
	 * Tests that passengers can be retrieved.
	 * Test 2) one passenger when adding one passenger when empty
	 */
	@Test
	public void testGetPassengers02() {
		// (2) one passenger when adding one passenger when empty
		//  a) adding passenger
		Car car = new Car( 5 );
		assertTrue  ( car.addPassenger( person[1] ));
		//  b) checking that we have one passenger...
		Person[] result   = car.getPassengers();
		Person[] expected = new Person[] { person[1], null, null, null, null };
		assertPassengersEquals( expected, result );
	}

	/**
	 * Tests that passengers can be retrieved.
	 * Test 3) one passenger when adding a duplicated passenger
	 */
	@Test
	public void testGetPassengers03() {
		// (3) one passenger when adding a duplicated passenger
		//  a) adding passenger
		Car car = new Car( 6 );
		assertTrue  ( car.addPassenger( person[1] ));
		//  b) we shouldn't be able to add it twice
		assertFalse ( car.addPassenger( person[1] ));
		//  c) checking that we have one passenger...
		//     ...and that it is the same we added
		Person[] result   = car.getPassengers();
		Person[] expected = new Person[] { person[1], null, null, null, null, null };
		assertPassengersEquals( expected, result );
	}

	/**
	 * Tests that passengers can be retrieved.
	 * Tests 4) gets passengers added up to capacity
	 */
	@Test
	public void testGetPassengers04() {
		// (4) gets passengers added up to capacity
		//  a) adding 7 passengers to a 7-person car
		Car car = new Car( 7 );
		for (int i = 1; i < 8; i++) {
			assertTrue( car.addPassenger( person[ i ] ));
		}
		//  b) checking that we have 7 passengers...
		//     ...and that they are the ones we added
		Person[] result = car.getPassengers();
		Person[] expected = new Person[] {
				person[1], person[2], person[3], person[4],
				person[5], person[6], person[7]
		};
		assertPassengersEquals( expected, result );
	}

	/**
	 * Tests that passengers can be retrieved.
	 * Test 5) gets passengers added beyond capacity
	 */
	@Test
	public void testGetPassengers05() {
		// (5) gets passengers added beyond capacity
		//  a) adding passengers to an 8-person car
		Car car = new Car( 8 );
		for (int i = 1; i < 9; i++) {
			assertTrue( car.addPassenger( person[ i ] ));
		}
		assertFalse( car.addPassenger( person[9] ));
		//  b) checking that we have 8 passengers...
		//     ...and that they are the ones we added
		Person[] result = car.getPassengers();
		Person[] expected = new Person[] {
				person[1], person[2], person[3], person[4],
				person[5], person[6], person[7], person[8]
		};
		assertPassengersEquals( expected, result );
	}

	/**
	 * Tests that passengers can be retrieved.
	 * Test 6) deletes list of retrieved passengers
	 *      without affecting the list in the car.
	 */
	@Test
	public void testGetPassengers06() {
		// (6) deletes list of retrieved passengers
		//     without affecting the list in the car.
		//  a) adding 6 passengers to a 7-person car
		Car car = new Car( 7 );
		for (int i = 6; i > 0; i--) {
			assertTrue ( car.addPassenger( person[ i ] ));
		}
		//  b) checking that we have 6 passengers...
		//     ...and that they are the ones we added
		Person[] result = car.getPassengers();
		Person[] expected = new Person[] {
				person[6], person[5], person[4],
				person[3], person[2], person[1], null
		};
		assertPassengersEquals( expected, result );
		// c) since deleting the list shouldn't modify the
		//    passengers in the car, we verify that nothing
		//    has changed.
		for (int i = 0; i < result.length; i++) {
			result[ i ] = null;
		}
		result = car.getPassengers();
		assertPassengersEquals( expected, result );
	}

	/**
	 * Tests that passengers can be removed from a car.
	 * Test 1) removing a "null" passenger when none exist [fails]
	 */
	@Test
	public void testRemovePassenger01() {
		// (1) removing a "null" passenger when none exist
		Car car = new Car();
		assertFalse( car.removePassenger( null ));
	}

	/**
	 * Tests that passengers can be removed from a car.
	 * Test 2) removing a "null" passenger when one exists [fails]
	 */
	@Test
	public void testRemovePassenger02() {
		// (2) removing a "null" passenger when one exists
		Car car = new Car();
		assertTrue  ( car.addPassenger   ( person[0] ));
		assertFalse ( car.removePassenger( null ));
	}

	/**
	 * Tests that passengers can be removed from a car.
	 * Test 3) removing a non-existing passenger when empty [fails]
	 */
	@Test
	public void testRemovePassenger03() {
		// (3) removing a non-existing passenger when empty
		Car car = new Car();
		assertFalse( car.removePassenger( person[0] ));
	}

	/**
	 * Tests that passengers can be removed from a car.
	 * Test 4) removing a non-existing passenger when not empty [fails]
	 */
	@Test
	public void testRemovePassenger04() {
		// (4) removing a non-existing passenger when not empty
		//  a) adding passengers
		Car car = new Car();
		assertTrue  ( car.addPassenger   ( person[0] ));
		assertTrue  ( car.addPassenger   ( person[1] ));
		assertTrue  ( car.addPassenger   ( person[2] ));
		//  b) removing a non-passenger person
		assertFalse ( car.removePassenger( person[9] ));
	}

	/**
	 * Tests that passengers can be removed from a car.
	 * Test 5) removing the only passenger
	 */
	@Test
	public void testRemovePassenger05() {
		// (5) removing the only passenger
		Car car = new Car();
		assertTrue  ( car.addPassenger   ( person[0] ));
		assertTrue  ( car.removePassenger( person[0] ));
	}

	/**
	 * Tests that passengers can be removed from a car.
	 * Test 6) removing all passengers
	 */
	@Test
	public void testRemovePassenger06() {
		// (6) removing all passengers
		//  a) adding passengers
		Car car = new Car( 8 );
		assertTrue  ( car.addPassenger   ( person[1] ));
		assertTrue  ( car.addPassenger   ( person[2] ));
		assertTrue  ( car.addPassenger   ( person[3] ));
		assertTrue  ( car.addPassenger   ( person[4] ));
		assertTrue  ( car.addPassenger   ( person[5] ));
		assertTrue  ( car.addPassenger   ( person[6] ));
		assertTrue  ( car.addPassenger   ( person[7] ));
		assertTrue  ( car.addPassenger   ( person[8] ));
		//  b) removing all passengers
		assertTrue  ( car.removePassenger( person[1] ));
		assertTrue  ( car.removePassenger( person[2] ));
		assertTrue  ( car.removePassenger( person[3] ));
		assertTrue  ( car.removePassenger( person[4] ));
		assertTrue  ( car.removePassenger( person[5] ));
		assertTrue  ( car.removePassenger( person[6] ));
		assertTrue  ( car.removePassenger( person[7] ));
		assertTrue  ( car.removePassenger( person[8] ));
	}

	/**
	 * Tests that passengers can be removed from a car.
	 * Test 7) removing half, adding to full, removing all
	 */
	public void testRemovePassenger07() {
		// (7) removing half, adding to full, removing all
		//  a) adding passengers
		Car car = new Car( 6 );
		assertTrue  ( car.addPassenger   ( person[1] ));
		assertTrue  ( car.addPassenger   ( person[2] ));
		assertTrue  ( car.addPassenger   ( person[3] ));
		assertTrue  ( car.addPassenger   ( person[4] ));
		assertTrue  ( car.addPassenger   ( person[5] ));
		assertTrue  ( car.addPassenger   ( person[6] ));
		//  b) removing half of the passengers
		assertTrue  ( car.removePassenger( person[1] ));
		assertTrue  ( car.removePassenger( person[3] ));
		assertTrue  ( car.removePassenger( person[5] ));
		//  c) adding to full
		assertTrue  ( car.addPassenger   ( person[7] ));
		assertTrue  ( car.addPassenger   ( person[8] ));
		assertTrue  ( car.addPassenger   ( person[9] ));
		//  d) removing all
		assertTrue  ( car.removePassenger( person[2] ));
		assertTrue  ( car.removePassenger( person[4] ));
		assertTrue  ( car.removePassenger( person[6] ));
		assertTrue  ( car.removePassenger( person[7] ));
		assertTrue  ( car.removePassenger( person[8] ));
		assertTrue  ( car.removePassenger( person[9] ));
	}

	/**
	 * Tests that passengers can be counted.
	 * Test 1) no passengers when adding a "null" passenger
	 */
	public void testGetOccupancy01() {
		// (1) no passengers when adding a "null" passenger
		//  a) adding passenger
		Car car = new Car();
		assertFalse ( car.addPassenger( null ));
		//  b) checking that there are no passengers
		assertEquals( 0, car.getOccupancy() );
	}

	/**
	 * Tests that passengers can be counted.
	 * Test 2) one passenger when adding one passenger when empty
	 */
	public void testGetOccupancy02() {
		// (2) one passenger when adding one passenger when empty
		//  a) adding passenger
		Car car = new Car( 5 );
		assertTrue  ( car.addPassenger( person[1] ));
		//  b) checking that we have one passenger
		assertEquals( 1, car.getOccupancy() );
	}

	/**
	 * Tests that passengers can be counted.
	 * Test 3) one passenger when adding a duplicated passenger
	 */
	public void testGetOccupancy03() {
		// (3) one passenger when adding a duplicated passenger
		//  a) adding passenger
		Car car = new Car( 6 );
		assertTrue  ( car.addPassenger( person[1] ));
		assertEquals( 1, car.getOccupancy() );
		//  b) we shouldn't be able to add it twice
		assertFalse ( car.addPassenger( person[1] ));
		//  c) checking that we have one passenger
		assertEquals( 1, car.getOccupancy() );
	}

	/**
	 * Tests that passengers can be counted.
	 * Test 4) checking occupancy while adding passengers up to capacity
	 */
	public void testGetOccupancy04() {
        // (4) checking occupancy while adding passengers up to capacity
		Car car = new Car( 7 );
		assertEquals( 0, car.getOccupancy() );
		for (int i = 1; i < 8; i++) {
			assertTrue  (    car.addPassenger( person[ i ] ));
			assertEquals( i, car.getOccupancy() );
		}
	}

	/**
	 * Tests that passengers can be counted.
	 * Test 5) checking occupancy after adding passengers beyond capacity
	 */
	public void testGetOccupancy05() {
		// (5) checking occupancy after adding passengers beyond capacity
		//  a) adding passengers
		Car car = new Car( 8 );
		for (int i = 1; i < 9; i++) {
			assertTrue ( car.addPassenger( person[ i ] ));
		}
		assertFalse( car.addPassenger( person[9] ));
		//  b) checking that we have 8 passengers
		assertEquals( 8, car.getOccupancy() );
	}

	/**
	 * Tests that passengers can be counted.
	 * Test 6) checking occupancy while removing all passengers
	 */
	public void testGetOccupancy06() {
		// (6) checking occupancy while removing all passengers
		//  a) adding passengers
		Car car = new Car( 7 );
		for (int i = 1; i < 8; i++) {
			assertTrue ( car.addPassenger( person[ i ] ));
		}
		//  b) removing passengers
		for (int i = 7; i > 0; i--) {
			assertEquals( i, car.getOccupancy() );
			assertTrue  (    car.removePassenger( person[ i ] ));
		}
		assertEquals( 0, car.getOccupancy() );
	}

	/**
	 * Tests that passengers can be counted.
	 * Test 7) checking occupancy after removing more than existing passengers
	 */
	public void testGetOccupancy07() {
		// (7) checking occupancy after removing more than existing passengers
		//  a) adding passengers
		Car car = new Car( 7 );
		for (int i = 1; i < 8; i++) {
			assertTrue ( car.addPassenger( person[ i ] ));
		}
		//  b) removing passengers
		for (int i = 1; i < 8; i++) {
			assertTrue ( car.removePassenger( person[ i ] ));
		}
		assertFalse( car.removePassenger( person[8] ));
		//  c) checking capacity
		assertEquals( 0, car.getOccupancy() );
	}

	/**
	 * Tests whether the car is full.
	 * Tests are made when adding and removing passengers
	 */
	public void testHasRoom() {
		for (int i = MIN_CAPACITY; i <= MAX_CAPACITY; i++) {
			// (1) when adding passengers
			//  a) creating new car with "i" seats
			Car car = new Car( i );
			assertEquals( i, car.getCapacity() );
			//  b) adding passengers until there is no more space.
			int count = 0;
			while (car.hasRoom()) {
				assertTrue( car.addPassenger( person[ count ]));
				count++;
			}
			//  c) checking that we added to capacity
			assertEquals( i, car.getOccupancy() );

			// (2) when removing passengers
			//  a) before removing
			assertFalse( car.hasRoom() );
			Person[] result = car.getPassengers();
			for (i = 0; i < result.length; i++) {
				// b) while removing
				assertTrue( car.removePassenger( result[ i ] ));
				assertTrue( car.hasRoom());
			}
		}
	}

	/**
	 * Tests whether a driver can be assigned.
	 * Test 1) adding an "null" driver [fails]
	 */
	public void testSetDriver01() {
		// (1) adding an "null" driver
		Car car = new Car();
		assertFalse ( car.setDriver( null ));
		assertEquals( null, car.getDriver() );
	}

	/**
	 * Tests whether a driver can be assigned.
	 * Test 2) adding an under-age driver when not full [fails]
	 */
	public void testSetDriver02() {
		// (2) adding an under-age driver when not full
		Car car = new Car();
		assertFalse ( car.setDriver( person[0] ));
		assertEquals( null, car.getDriver() );
	}

	/**
	 * Tests whether a driver can be assigned.
	 * Test 3) adding a legal-age driver when not full and a driver exists
	 */
	public void testSetDriver03() {
		// (3) adding a legal-age driver when not full and a driver exists
		//     (the existing driver remains a passenger)
		Car car = new Car();
		//  a) new driver
		assertTrue  (   car.setDriver( person[6] ));
		Person driver;
		driver = car.getDriver();
		assertEquals( person[6].getAge(),  driver.getAge() );
		assertEquals( person[6].getName(), driver.getName() );
		//  b) replacing driver
		assertTrue  ( car.setDriver( person[7] ));
		driver = car.getDriver();
		assertEquals( person[7].getAge(),  driver.getAge() );
		assertEquals( person[7].getName(), driver.getName() );
		//  c) checking that both are passengers
		assertEquals( 2, car.getOccupancy() );
		Person[] result   = car.getPassengers();
		Person[] expected = new Person[] { person[6], person[7], null, null };
		assertPassengersEquals( expected, result );
	}

	/**
	 * Tests whether a driver can be assigned.
	 * Test 4) adding a legal-age driver when full and a driver exists [fails]
	 */
	public void testSetDriver04() {
		// (4) adding a legal-age driver when full and a driver exists
		//  a) adding passengers
		Car car = new Car();
		assertTrue  ( car.addPassenger( person[4] ));
		assertTrue  ( car.addPassenger( person[5] ));
		assertTrue  ( car.addPassenger( person[6] ));
		assertTrue  ( car.addPassenger( person[7] ));
		//  b) assigning driver
		assertTrue  (   car.setDriver( person[6] ));
		Person driver;
		driver = car.getDriver();
		assertEquals( person[6].getAge(),  driver.getAge() );
		assertEquals( person[6].getName(), driver.getName() );
		//  c) assigning a new driver when full [fails]
		assertFalse (    car.setDriver( person[8] ));
		//  d) checking that nothing changed
		driver = car.getDriver();
		assertEquals( person[6].getAge(),  driver.getAge() );
		assertEquals( person[6].getName(), driver.getName() );
		assertEquals( 4, car.getOccupancy());
		Person[] result   = car.getPassengers();
		Person[] expected = new Person[] { person[4], person[5], person[6], person[7] };
		assertPassengersEquals( expected, result );
	}

	/**
	 * Tests whether a driver can be assigned.
	 * Test 5) selecting an under-age passenger as driver [fails]
	 */
	public void testSetDriver05() {
		// (5) selecting an under-age passenger as driver
		//  a) adding passengers
		Car car = new Car();
		assertTrue  ( car.addPassenger( person[3] ));
		assertTrue  ( car.addPassenger( person[4] ));
		assertTrue  ( car.addPassenger( person[5] ));
		//  b) selecting an under-age driver
		assertFalse (       car.setDriver( person[3] ));
		//  c) checking that nothing changed
		assertEquals( null, car.getDriver() );
		assertEquals( 3, car.getOccupancy());
		Person[] result   = car.getPassengers();
		Person[] expected = new Person[] { person[3], person[4], person[5], null };
		assertPassengersEquals( expected, result );
	}

	/**
	 * Tests whether a driver can be assigned.
	 * Test 6) selecting a legal-age passenger as driver when full and a
	 *      driver exists
	 */
	public void testSetDriver06() {
		// (6) selecting an under-age passenger as driver when full and
		//     a driver exists
		Car car = new Car();
		assertTrue  ( car.addPassenger( person[3] ));
		assertTrue  ( car.addPassenger( person[4] ));
		assertTrue  ( car.addPassenger( person[5] ));
		assertTrue  ( car.addPassenger( person[6] ));

		Person driver;
		assertTrue  ( car.setDriver( person[6] ));
		driver = car.getDriver();
		assertEquals( person[6].getAge(),  driver.getAge() );
		assertEquals( person[6].getName(), driver.getName() );

		assertFalse ( car.setDriver( person[5] ));
		driver = car.getDriver();
		assertEquals( person[6].getAge(),  driver.getAge() );
		assertEquals( person[6].getName(), driver.getName() );
	}

	/**
	 * Tests whether a driver can be assigned.
	 * Test 7) removing driver
	 */
	public void testSetDriver07() {
		// (7) removing the driver
		//  a) adding passengers
		Car car = new Car( 7 );
		assertTrue  ( car.addPassenger   ( person[4] ));
		assertTrue  ( car.addPassenger   ( person[5] ));
		assertTrue  ( car.addPassenger   ( person[6] ));
		assertTrue  ( car.addPassenger   ( person[7] ));
		//  b) selecting a driver
		assertTrue  ( car.setDriver( person[6] ));
		//  c) removing the driver
		assertTrue  ( car.removePassenger( person[6] ));
		//  d) checking that the passenger is not the driver anymore
		assertEquals( null, car.getDriver());
	}

	/**
	 * Testing whether a passenger is in the car.
	 * Test 1) a "null" passenger
	 */
	public void testHasPassenger01() {
		// (1) a "null" passenger
		Car car = new Car();
		assertFalse( car.hasPassenger( null ));
	}

	/**
	 * Testing whether a passenger is in the car.
	 * Test 2) a non-existing passenger when empty
	 */
	public void testHasPassenger02() {
		// (2) a non-existing passenger when empty
		Car car = new Car();
		assertFalse( car.hasPassenger( person[0] ));
	}

	/**
	 * Testing whether a passenger is in the car.
	 * Test 3) a non-existing passenger when full
	 */
	public void testHasPassenger03() {
		// (3) a non-existing passenger when full
		Car car = new Car();
		//  a) adding passengers
		assertTrue ( car.addPassenger( person[0] ));
		assertTrue ( car.addPassenger( person[1] ));
		assertTrue ( car.addPassenger( person[2] ));
		assertTrue ( car.addPassenger( person[3] ));
		//  b) locating passenger
		assertFalse( car.hasPassenger( person[4] ));
	}

	/**
	 * Testing whether a passenger is in the car.
	 * Test 4) an existing passenger
	 */
	public void testHasPassenger04() {
		// (4) an existing passenger
		Car car = new Car();
		//  a) adding passengers
		assertTrue ( car.addPassenger( person[0] ));
		assertTrue ( car.addPassenger( person[1] ));
		assertTrue ( car.addPassenger( person[2] ));
		assertTrue ( car.addPassenger( person[3] ));
		//  b) locating passenger
		assertTrue ( car.hasPassenger( person[3] ));
	}

	/**
	 * Testing whether a person is of driving age.
	 * Test 1) a "null" person [fails]
	 */
	public void testCanDrive01() {
		Car car = new Car();
		// (1) a "null" person doesn't drive
		assertFalse( car.canDrive( null ));
	}

	/**
	 * Testing whether a person is of driving age.
	 * Test 2) an under-age person [fails]
	 */
	public void testCanDrive02() {
		Car car = new Car();
		// (2) an under-age person shouldn't drive
		assertTrue ( person[0].getAge() < MIN_DRIVING_AGE );
		assertFalse( car.canDrive( person[0] ));
	}

	/**
	 * Testing whether a person is of driving age.
	 * Test 3) a legal-age person
	 */
	public void testCanDrive03() {
		Car car = new Car();
		// (3) a legal-age person does drive
		assertTrue ( person[6].getAge() >= MIN_DRIVING_AGE );
		assertTrue ( car.canDrive( person[6] ));
	}
}
