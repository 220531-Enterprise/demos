package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.dao.UserDaoImpl;
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
	
	// 11:25pm ET solution
	
	
	
	
	
	
	
	
	
	
}
