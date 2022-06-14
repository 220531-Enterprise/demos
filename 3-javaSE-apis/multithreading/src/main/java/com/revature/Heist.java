package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Heist {
	
	public static final int MAX_PASSWORD = 9999;
	
	public static void main(String[] args) {
		
		// the action begins here for the game 
		
		// 1. randomly generate a number between 0 - 9999
		Random random = new Random();
		int password = random.nextInt(MAX_PASSWORD); // This will change every time we run the program
		
		// 2. instantiate a vault 
		Vault vault = new Vault(password);
		
		// 3. Instantiate 3 threads: 1 cop thread, 2 hacker threads
		DescendingHackerThread descHacker = new DescendingHackerThread(vault);
		AscendingHackerThread ascHacker = new AscendingHackerThread(vault);
		PolicemanThread policemanThread = new PolicemanThread();
		
		// add each thread to a list of threads
		List<Thread> threads = new ArrayList<Thread>();
		threads.add(descHacker);
		threads.add(ascHacker);
		threads.add(policemanThread);
		
		// then call the forEach() method on the list, and start() each one
//		threads.forEach(t -> t.start());
		threads.forEach(Thread::start);

	}
	
	// DRY - Don't Repeat Yourself
	private static abstract class HackerThread extends Thread {
		
		// every Hacker gets a Vault that they're attacking
		protected Vault vault;
		
		public HackerThread(Vault vault) {
			this.vault = vault;
			// setName() comes from the Thread class
			this.setName(this.getClass().getSimpleName()); // Simple name will return either Desc or Asc HackerThread
			this.setPriority(Thread.MAX_PRIORITY);
		}
		
		@Override // overriding the start() method for this thread
		public void start() {
			
			System.out.println("Starting thread: " + this.getName());
			super.start(); // make sure you maintain whatever 
			// functionality is in the start() method of the Thread class
		}
		
		
	}
	
	private static class DescendingHackerThread extends HackerThread {

		public DescendingHackerThread(Vault vault) {
			super(vault);
		}
		
		@Override
		public void run() {
			
			// goal: iterate from the MAX_PASSWORD to 0 and call the vault object's isCorrectPassword()
			// check if it's corrrect on every iteration
			for (int guess = MAX_PASSWORD; guess >= 0; guess--) {
				
				if (vault.isCorrectPassword(guess)) {
					System.out.println(this.getName() + " guessed the password! The password was " + guess);
					System.exit(0); // terminate the program 
				}
				// if line 61 is FALSE, we break down here and continue the loop until we find the correct #
			}
		}
	}
	
	private static class AscendingHackerThread extends HackerThread {

		public AscendingHackerThread(Vault vault) {
			super(vault);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public void run() {
			
			// CHALLENGE: make the AscendingHackerThread iterate from 0 to MAX_PASSWORD
			for (int guess = 0; guess <= MAX_PASSWORD; guess++) {
				
				if (vault.isCorrectPassword(guess)) {
					System.out.println(this.getName() + " guessed the password! The password was " + guess);
					System.exit(0); // terminate the program 
				}
				// if the if-condition is FALSE, we break down here and continue the loop until we find the correct #
			}
			
		}
	}
	
	// the only purpose of this thread is to count down from 10 (in 10 seconds)
	private static class PolicemanThread extends Thread {
		
		@Override
		public void run() {
			
			// this is the thread's job when it's in the running phase
			for (int i=7; i >= 0; i--) { // change i's start calue to increase seconds time
				
				try {
					Thread.sleep(1000); // put it to sleep for 1 second on each iteration
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
				
				// print out how many seconds left on each iteration
				System.out.println(i + " seconds left!");
			}
			
			// after the for loop ends (time is out) print out a message and quit the program
			System.out.println("Game over for you, Hackers!");
			System.exit(0); // terminate the program
		}
	}
	
	
	
	// YES classes can be static -- so that I can instantiate it WITHIN the class I'm declaring it in
	private static class Vault { // private so we can ONLY instantiate this calss inside of the Heist class
		
		private int password;
		
		public Vault(int password) {
			
			this.password = password;
			
		}
		
		// 1 method called isCorrectPassword
		// @param int guess
		public boolean isCorrectPassword(int guess) {
			
			// we're putting the thread to sleep that calls this
			// method to extend the amount of time that passes in the game
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}

			return guess == this.password;

		}
		
		
	}

}
