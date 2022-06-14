package com.revature;

public class ThreadCreation {
	
	/*
	 * =================================================================
	 * ====== THERE ARE THREE MAIN WAYS TO CREATE THREADS ================
	 * =================================================================
	 * 
	 * 		(1) Implement Runnable interface and pass it to a new Thread object's constructor
	 * 
	 * 		(2) Extend Thread class, and create an object of that class. 
	 * 
	 * 		(3) Execute tasks asynchronously with an ExecutorService (it's similar to a thread pool)
	 * 
	 * ================== Both are equal! ====================
	 */
	
	public static void main(String[] args) {
		
		
		System.out.println("Main thread starting.....");
		
		// A thread is a separate path of execution
		Thread myThread = new Thread(new MyTask()); // we pass an instance of a runnbale object
		
		myThread.start();
		
		// CHALLENGE 
		
		// (1) create a thread and fulfill its run() implementation with anonymous class
		Thread anonThread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Runnin from the anon class");
				
			}
		});
		
		// (2)create a thread and fullfill its run() implementation with a lambda
		// the empty () mean no params (because run() doesn't have params
		Thread lambdaThread = new Thread(() -> System.out.println("Runnin from the lambda thread"));
		
		lambdaThread.setPriority(Thread.MAX_PRIORITY);
		
		anonThread.start(); // the start() method INVOKES the run() method
		lambdaThread.start();
		
		System.out.println("Main thread exiting");
		
		/**
		 * Thread Life Cycle
		 * 
		 * - New phase - when it's created
		 * - Runnable phase - when the run() method has been implemented
		 * - Active (Running) phase - when its start() method has been invoked
		 * - Non-Runnable (blocked) phase - when it's interfered with by another thread - deadlock 
		 * - Terminated thread - the thread is done with its task - YOU CANNOT REVIVE A DEAD THREAD
		 */
		
		Thread customThread = new MyCustomThread();
		
		customThread.start();

	}

}

// Runnable is a FUNCTIONAL INTERFACE
class MyTask implements Runnable { // (1)

	@Override
	public void run() {
		System.out.println("The task is runnin!!");
		
	}
}

class MyCustomThread extends Thread {
	
	public void run() {
		System.out.println("My custom thread is running!");
	}
}








