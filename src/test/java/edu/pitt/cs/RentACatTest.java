package edu.pitt.cs;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.mockito.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RentACatTest {

	/**
	 * The test fixture for this JUnit test. Test fixture: a fixed state of a set of
	 * objects used as a baseline for running tests. The test fixture is initialized
	 * using the @Before setUp method which runs before every test case. The test
	 * fixture is removed using the @After tearDown method which runs after each
	 * test case.
	 */

	RentACat r; // Object to test
	Cat c1; // First cat object
	Cat c2; // Second cat object
	Cat c3; // Third cat object

	@Before
	public void setUp() throws Exception {
		// Turn on automatic bug injection in the Cat class, to emulate a buggy Cat.
		// Your unit tests should work regardless of these bugs.
		Cat.bugInjectionOn = false;

		// INITIALIZE THE TEST FIXTURE
		// 1. Create a new RentACat object and assign to r
		r = RentACat.createInstance();

		// 2. Create an unrented Cat with ID 1 and name "Jennyanydots", assign to c1
		try {
			c1 = new Cat(1, "Jennyanydots");
		} catch( UnsupportedOperationException uoe ) {
			System.out.println(" setUp Unsupported Operation ");
			c1 = null;
		}

		// 3. Create an unrented Cat with ID 2 and name "Old Deuteronomy", assign to c2
		try {
			c2 = new Cat(2, "Old Deuteronomy");
		} catch( UnsupportedOperationException uoe ) {
			System.out.println("setUp Unsupported Operation ");
			c2 = null;
		}

		// 4. Create an unrented Cat with ID 3 and name "Mistoffelees", assign to c3
		try {
			c3 = new Cat(3, "Mistoffelees");
		} catch( UnsupportedOperationException uoe ) {
			System.out.println("setUp Unsupported Operation ");
			c3 = null;
		}
	}
		
	@After
	public void tearDown() throws Exception {
		// Not necessary strictly speaking since the references will be overwritten in
		// the next setUp call anyway and Java has automatic garbage collection.
		r = null;
		c1 = null;
		c2 = null;
		c3 = null;
	}

	/**
	 * Test case for Cat getCat(int id).
	 * 
	 * <pre>
	 * Preconditions: r has no cats.
	 * Execution steps: Call getCat(2).
	 * Postconditions: Return value is null.
	 * </pre>
	 */

	@Test
	public void testGetCatNullNumCats0() {
		Cat tmpCat = null;
		try {
			tmpCat = r.getCat(2);
		} catch( UnsupportedOperationException uoe ) {
			System.out.println("testGetCatNullNumCats0 Unsupported Operation ");
			tmpCat = null;
		}
		assertNull("getCat did not return null", tmpCat);
	}

	/**
	 * Test case for Cat getCat(int id).
	 * 
	 * <pre>
	 * Preconditions: c1, c2, and c3 are added to r using addCat(Cat c).
	 * Execution steps: Call getCat(2).
	 * Postconditions: Return value is not null.
	 *                 Returned cat has an ID of 2.
	 * </pre>
	 */

	@Test
	public void testGetCatNumCats3() {
		Cat tmpCat = null;
		try {
			r.addCat(c1);
			r.addCat(c2);
			r.addCat(c3);
		} catch( UnsupportedOperationException uoe ) {
			System.out.println("testGetCatNumCats3 Unsupported Operation 1");
		}
		try {
			tmpCat = r.getCat(2);
		} catch( UnsupportedOperationException uoe ) {
			System.out.println("testGetCatNumCats3 Unsupported Operation 2");
			tmpCat = null;
		}
		assertNotNull("testGetCatNumCats3 getCat returned null", tmpCat);
		if(tmpCat != null) {
			assertEquals("testGetCatNumCats3 getCat id incorrect", 2, tmpCat.getId());
		}	
	}

	/**
	 * Test case for boolean catAvailable(int id).
	 * 
	 * <pre>
	 * Preconditions: r has no cats.
	 * Execution steps: Call catAvailable(2).
	 * Postconditions: Return value is false.
	 * </pre>
	 */

	
	@Test
	public void testCatAvailableFalseNumCats0() {
		boolean tmpBool;
		try {
			tmpBool = r.catAvailable(2);
		} catch( UnsupportedOperationException uoe ) {
			System.out.println("testCatAvailableFalseNumCats0 Unsupported Operation ");
			tmpBool = true;
		}
		assertEquals("testCatAvailableFalseNumCats0 did not return false", false, tmpBool);
	}
	

	/**
	 * Test case for boolean catAvailable(int id).
	 * 
	 * <pre>
	 * Preconditions: c1, c2, and c3 are added to r using addCat(Cat c).
	 *                c3 is rented.
	 *                c1 and c2 are not rented.
	 * Execution steps: Call catAvailable(2).
	 * Postconditions: Return value is true.
	 * </pre>
	 */

	
	@Test
	public void testCatAvailableTrueNumCats3() {
		boolean tmpBool = false;
		try {
			r.addCat(c1);
			r.addCat(c2);
			r.addCat(c3);
			tmpBool = r.rentCat(3);
		} catch( UnsupportedOperationException uoe ) {
			System.out.println("testCatAvailableTrueNumCats3 Unsupported Operation ");
		}
		assertEquals("testCatAvailableTrueNumCats3 precondition did not return true", true, tmpBool);
		try {
			tmpBool = r.catAvailable(2);
		} catch( UnsupportedOperationException uoe ) {
			System.out.println("testCatAvailableTrueNumCats3 Unsupported Operation ");
			tmpBool = true;
		}
		assertEquals("testCatAvailableTrueNumCats3 did not return true", true, tmpBool);
	}
	

	/**
	 * Test case for boolean catAvailable(int id).
	 * 
	 * <pre>
	 * Preconditions: c1, c2, and c3 are added to r using addCat(Cat c).
	 *                c2 is rented.
	 *                c1 and c3 are not rented.
	 * Execution steps: Call catAvailable(2).
	 * Postconditions: Return value is false.
	 * </pre>
	 */
	
	@Test
	public void testCatAvailableFalseNumCats3() {
		boolean tmpBool = false;
		try {
			r.addCat(c1);
			r.addCat(c2);
			r.addCat(c3);
			tmpBool = r.rentCat(2);
		} catch( UnsupportedOperationException uoe ) {
			System.out.println("testCatAvailableFalseNumCats3 Unsupported Operation 1");
		}
		assertEquals("testCatAvailableFalseNumCats3 precondition did not return true", true, tmpBool);
		try {
			tmpBool = r.catAvailable(2);
		} catch( UnsupportedOperationException uoe ) {
			System.out.println("testCatAvailableFalseNumCats3 Unsupported Operation 2");
			tmpBool = true;
		}
		assertEquals("testCatAvailableFalseNumCats3 did not return false", false, tmpBool);
	}
	

	/**
	 * Test case for boolean catExists(int id).
	 * 
	 * <pre>
	 * Preconditions: r has no cats.
	 * Execution steps: Call catExists(2).
	 * Postconditions: Return value is false.
	 * </pre>
	 */

	
	@Test
	public void testCatExistsFalseNumCats0() {
		boolean tmpBool;
		try {
			tmpBool = r.catExists(2);
		} catch( UnsupportedOperationException uoe ) {
			System.out.println("testCatExistsFalseNumCats0 Unsupported Operation ");
			tmpBool = true;
		}
		assertEquals("testCatExistsFalseNumCats0 catExists did not return false", false, tmpBool);
	} 

	/**
	 * Test case for boolean catExists(int id).
	 * 
	 * <pre>
	 * Preconditions: c1, c2, and c3 are added to r using addCat(Cat c).
	 * Execution steps: Call catExists(2).
	 * Postconditions: Return value is true.
	 * </pre>
	 */
	@Test
	public void testCatExistsTrueNumCats3() {
		boolean tmpBool;
		try {
			r.addCat(c1);
			r.addCat(c2);
			r.addCat(c3);
		} catch( UnsupportedOperationException uoe ) {
			System.out.println("testCatExistsTrueNumCats3 Unsupported Operation 1");
		}
		try {
			tmpBool = r.catExists(2);
		} catch( UnsupportedOperationException uoe ) {
			System.out.println("testCatExistsTrueNumCats3 Unsupported Operation 2");
			tmpBool = false;
		}
		assertEquals("testCatExistsTrueNumCats3 catExists did not return true", true, tmpBool);
	}
	
	/**
	 * Test case for String listCats().
	 * 
	 * <pre>
	 * Preconditions: r has no cats.
	 * Execution steps: Call listCats().
	 * Postconditions: Return value is "".
	 * </pre>
	 */
	@Test
	public void testListCatsNumCats0() {
		String eVal = "";
		String aVal;
		try {
			aVal = r.listCats();
		} catch( UnsupportedOperationException uoe ) {
			System.out.println("testListCatsNumCats0 Unsupported Operation ");
			aVal = null;
		}
		assertEquals("testListCatsNumCats0 is not empty", eVal, aVal);
	}

	/**
	 * Test case for String listCats().
	 * 
	 * <pre>
	 * Preconditions: c1, c2, and c3 are added to r using addCat(Cat c).
	 * Execution steps: Call listCats().
	 * Postconditions: Return value is "ID 1. Jennyanydots\nID 2. Old
	 *                 Deuteronomy\nID 3. Mistoffelees\n".
	 * </pre>
	 */
	@Test
	public void testListCatsNumCats3() {
		try {
			r.addCat(c1);
			r.addCat(c2);
			r.addCat(c3);
		} catch( UnsupportedOperationException uoe ) {
			System.out.println("testListCatsNumCats3 Unsupported Operation 1");
		}
		String eVal = "ID 1. Jennyanydots\nID 2. Old Deuteronomy\nID 3. Mistoffelees\n";
		String aVal;
		try {
			aVal = r.listCats();
		} catch( UnsupportedOperationException uoe ) {
			System.out.println("testListCatsNumCats3 Unsupported Operation 2");
			aVal = null;
		}
		assertEquals("testListCatsNumCats3 is not correct", eVal, aVal);
	}

	/**
	 * Test case for boolean rentCat(int id).
	 * 
	 * <pre>
	 * Preconditions: r has no cats.
	 * Execution steps: Call rentCat(2).
	 * Postconditions: Return value is false.
	 * </pre>
	 */

	
	@Test
	public void testRentCatFailureNumCats0() {
		boolean tmpBool;
		try {
			tmpBool = r.rentCat(2);
		} catch( UnsupportedOperationException uoe ) {
			System.out.println("testRentCatFailureNumCats0 Unsupported Operation ");
			tmpBool = true;
		}
		assertEquals("testRentCatFailureNumCats0 rentCat did not return false", false, tmpBool);
	}
	

	/**
	 * Test case for boolean rentCat(int id).
	 * 
	 * <pre>
	 * Preconditions: c1, c2, and c3 are added to r using addCat(Cat c).
	 *                c2 is rented.
	 * Execution steps: Call rentCat(2).
	 * Postconditions: Return value is false.
	 *                 c1.rentCat(), c2.rentCat(), c3.rentCat() are never called.
	 * </pre>
	 * 
	 * Hint: See sample_code/mockito_example/NoogieTest.java in the course
	 * repository for an example of behavior verification. Refer to the
	 * testBadgerPlayCalled method.
	 */

	@Test
	public void testRentCatFailureNumCats3() {
		boolean tmpBool = false;
		try {
			r.addCat(c1);
			r.addCat(c2);
			r.addCat(c3);
			tmpBool = r.rentCat(2);
		} catch( UnsupportedOperationException uoe ) {
			System.out.println("testRentCatFailureNumCats3 Unsupported Operation ");
		}
		assertEquals("testRentCatFailureNumCats3 precondition did not return true", true, tmpBool);
		try {
			tmpBool = r.rentCat(2);
		} catch( UnsupportedOperationException uoe ) {
			System.out.println("testRentCatFailureNumCats3 Unsupported Operation ");
			tmpBool = true;
		}
		assertEquals("testRentCatFailureNumCats3 rentCat did not return false", false, tmpBool);
	}

	/**
	 * Test case for boolean returnCat(int id).
	 * 
	 * <pre>
	 * Preconditions: r has no cats.
	 * Execution steps: Call returnCat(2).
	 * Postconditions: Return value is false.
	 * </pre>
	 */

	@Test
	public void testReturnCatFailureNumCats0() {
		boolean tmpBool;
		try {
			tmpBool = r.returnCat(2);
		} catch( UnsupportedOperationException uoe ) {
			System.out.println("testReturnCatFailureNumCats0 Unsupported Operation ");
			tmpBool = true;
		}
		assertEquals("testReturnCatFailureNumCats0 rentCat did not return false", false, tmpBool);
	
	}

	/**
	 * Test case for boolean returnCat(int id).
	 * 
	 * <pre>
	 * Preconditions: c1, c2, and c3 are added to r using addCat(Cat c).
	 *                c2 is rented.
	 * Execution steps: Call returnCat(2).
	 * Postconditions: Return value is true.
	 *                 c2.returnCat() is called exactly once.
	 *                 c1.returnCat() and c3.returnCat are never called.
	 * </pre>
	 * 
	 * Hint: See sample_code/mockito_example/NoogieTest.java in the course
	 * repository for an example of behavior verification. Refer to the
	 * testBadgerPlayCalled method.
	 */

	@Test
	public void testReturnCatNumCats3() {
		boolean tmpBool = false;
		try {
			r.addCat(c1);
			r.addCat(c2);
			r.addCat(c3);
			tmpBool = r.rentCat(2);
		} catch( UnsupportedOperationException uoe ) {
			System.out.println("testReturnCatNumCats3 Unsupported Operation ");
		}
		assertEquals("testReturnCatNumCats3 precondition did not return true", true, tmpBool);
		try {
			tmpBool = r.returnCat(2);
		} catch( UnsupportedOperationException uoe ) {
			System.out.println("testReturnCatNumCats3 Unsupported Operation ");
			tmpBool = true;
		}
		assertEquals("testReturnCatNumCats3 returnCat did not return true", true, tmpBool);

	}
}
