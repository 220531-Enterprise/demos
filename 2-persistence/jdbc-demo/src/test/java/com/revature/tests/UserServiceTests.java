package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.dao.UserDaoImpl;
import com.revature.exceptions.RegisterUserFailedException;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.service.UserService;

public class UserServiceTests {

	// declare a variable that points to the types of objects you want to use
	private UserService userv;
	
	// we will need to inject this into the UserService object
	private UserDaoImpl mockDao;
	
	// create a dummy user stub
	private User dummyUser;
	
	
	@Before // runs before every single test suite
	public void setup() {
		
		// create a MOCK of the dao
		mockDao = mock(UserDaoImpl.class); // Mockito's mock() method builds a replica object of the
										   // class we're mocking, with EMPTY method implementations
		
		// inject that mock into the userservice when instantiated
		userv = new UserService(mockDao);
		
	}
	
	@After //after every unit
	public void teardown() {
		// we set them to null so that we can reprogram the stub's behavior for every test
		userv = null;
		mockDao = null;
		dummyUser = null;
		
	}
	
	
	/**
	 * Happy Path Scenario for a successful login
	 * 
	 * Test that if we pass the right
	 * username & password, it successfully
	 * returns the User that the DAO 
	 * returns from the findByUsername() method
	 */
	@Test
	public void testSuccesfulLogin() {
		
		// 1. setup the dummyUser stub
		dummyUser = new User(12, "hawkeye", "arrows", Role.Customer, null);
		
		// establish the params
		String username = "hawkeye";
		String password = "arrows";
		
		
		// PROGRAM the fakeDao to return the dummyUser when the
		// findByUsername() method is called by the Service layer
		
		/**
		 * We're programming our DAO imposter to return the appropriate
		 * User object when the username "hawkeye is passed through
		 */
		when(mockDao.findByUsername("hawkeye")).thenReturn(dummyUser);
		
		
		// capture the actual user that's returned by service layer's 
		// login method
		User actualReturnedUser = userv.login(username, password);
		User expectedUser = dummyUser;
		
		// use an assertion to see if it's the same as what we expect to be 
		// returned
		assertEquals(expectedUser, actualReturnedUser);
		// expected, actual
		
	}
	
	// create a test called testFailedLogin();
	/**
	 * What do I return if its an unsuccessful login?
	 * 
	 * null!
	 */
	@Test
	public void testUnsuccessfulLogin() {
		
		// 1. establish the dummy User
		dummyUser = new User(12, "hawkeye", "arrows", Role.Customer, null);
		
		// establish the params
		String username = "hawkeye";
		String password = "balloons";
		
		
		// PROGRAM the fakeDao to return the dummyUser when the
		// findByUsername() method is called by the Service layer
		
		/**
		 * We're programming our DAO imposter to return the appropriate
		 * User object when the username "hawkeye is passed through
		 */
		when(mockDao.findByUsername("hawkeye")).thenReturn(dummyUser);
		
		// call the login method and pass through the username and password
		User actualReturnedUser = userv.login(username, password); // the password is wrong
		
		// our logic says that the login() method will return null if password is incorrect
		
		assertNull(actualReturnedUser);
		
	}
	
	/**
	 * Testing that when we register a User that has an id > 0
	 * we throw a RegisterUserFailedException
	 */
	@Test(expected=RegisterUserFailedException.class)
	public void testRegisterUser_idGreaterThanZero_throwsException() {
		
		// Set our stub to an imaginary User that exists in the DB and has an ID> 0
		dummyUser = new User(2, "wanda", "vision", Role.Admin, null);
		
		/**
		 * We're setting up the fake behavior of the dao
		 * which the service will call on within the register method
		 */
		when(mockDao.findByUsername("wanda")).thenReturn(dummyUser);
		
		userv.register(dummyUser); //this should throw an exception
		
	}
	
	/**
	 * Happy Path Scenario for the register() method
	 * We return a User with its ID set to the primary key that
	 * was generated from the DB
	 */
	@Test
	public void testRegisterUser_returnNewPkAsId() {
		
		// step 1 build a valid user to register
		dummyUser = new User(0, "spongebob", "pineapple", Role.Admin, null);
		
		
		// step 2. randomly generate a number which we
		// pretend is the SERIAL id from the DB
		Random r = new Random();
		int expectedId = r.nextInt(100); // this randomly generates a number between 0 - 100
		
		// step 3. program the dao's behavior to findByUsername
		// have it return an empty user (id == 0)
		when(mockDao.findByUsername("spongebob")).thenReturn(new User());
		
		
		// step 4. program the behavior of the dao's
		// insert() method to return the PK we design
		// in Step 2
		when(mockDao.insert(dummyUser)).thenReturn(expectedId);
		
		// step 5.check that the registered user's acutal 
		// ID is equal to the PK that we program the DB 
		// to return
		
		User registeredUser = userv.register(dummyUser);
		
		/**
		 * Right here, behind the scenes the register 
		 * method is applying the expectedId as the 
		 * ID of the dummyUser
		 */
		
		int actualId = registeredUser.getId();
		
		assertEquals(expectedId, actualId);
		
	}
	
	
	
	
	
}
