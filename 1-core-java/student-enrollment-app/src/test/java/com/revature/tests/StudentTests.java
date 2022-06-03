package com.revature.tests;

import static org.junit.Assert.assertEquals;
/**
 * Static imports allows us to import static members and methods without declaring the class 
 */
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.models.Student;

/**
 * Test Suite
 * 
 * A group of Unit Tests designed to test individual methods (units) 
 * of one class.
 * 
 * TDD:Test Driven Development - I write tests as I code
 * The most popular framework is JUnit
 */
public class StudentTests {
	
	/**
	 * A stub is an object that holds predefined data and uses it 
	 * to answer calls during tests. It is used when you can't 
	 * or don't want to involve objects that would answer with 
	 * real data or have undesirable side effects.
	 * 
	 * Why are these static? So I can repeatedly use
	 */
	static Student dummyStudent;
	
	// JUNIT Annotations
	// ANNOTATIONS indicate tests and tell us when to run test methods
	
	@BeforeClass // @BeforeClass runs this method before 
	public static void setUpBeforeClass() {
		
		System.out.println("Setting up the test suite....");
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		
		System.out.println("Tearing down the test suite....");
	}
	
	@Before // run before every test
	public void setUp() {
		
		System.out.println("Setting up the unit test...");
		Student.GLOBAL_ID = 1000; // so that the global static member resets with every test
	}
	
	@After
	public void tearDown() {
		
		// to garbage collect any student objects creatd in separate tests;
		dummyStudent = null;
		
	}
	
	@Test 
	public void sanityTest() {
		
		// test that 2 + 3 does indeed equal 5
		int x = 2;
		int y = 3;
		
		int expectedSum = 5;
		int actualSum = (x + y);
		
		// ASSERTIONs are utility methods that assert conditions (true false)
		assertEquals(expectedSum, actualSum); // returns true or false
		
	}
	
	// Happy Path: everything works as expected
	
	@Test
	public void testSetStudentId() {
		
		// we set our stub (dummyStudent) equal to a new student
		dummyStudent = new Student("John", "Doe", 4);
		
		// the id SHOULD be 41001
		
		// establish the ACTUAL id and the
		String actualId = dummyStudent.getStudentId();
		
		// establish EXPECTED id
		String expectedId = "41001";
		
		// assert that the expected EQAULS the actual
		assertEquals(expectedId, actualId);
		
	}
	
	@Test
	public void testStudentEquality() {
		
		// create 2 students
		dummyStudent = new Student("Marry", "Smith", 2);
		
		Student secondStudent = new Student("Marry", "Smith", 2);
		
		// set the secondStuden't ID the whatever the first student'
		// ID is
		secondStudent.setStudentId(dummyStudent.getStudentId());
		
		// assert  that they .eqaul() eachother dummyStudent.equals(secondStudent);
		assertTrue(dummyStudent.equals(secondStudent)); // dummyStudent.equals(seondStudent);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
