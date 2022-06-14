package com.revature;

/**
 * Producer Consumer Problem:
 * 
 * When 2 threads are accessing the same Queue (a data structure that 
 * has an order in which objects are added and removed from it - FIFO)
 * the producer is some thread that must add (set) a value and the
 * Consumer is a thread that must consume (or get) that value.
 *
 *  We need to program the data structure AND the behavior of the COnsumer & Producer threads
 *  so that the COnsumer dones't over-consume and the producer doesn't over or under produce.
 *  
 * BlockingQueue is an example of a built in class that has the following functionality:
 */

public class ProducerConsumer {

	public static void main(String[] args) {
		
		Holder data = new Holder();
		int numOfValuesToGenerate = 10;
		
		// create 2 threads
		Thread producerThread = new Thread(new Producer(data, numOfValuesToGenerate));
		Thread consumerThread = new Thread(new Consumer(data, numOfValuesToGenerate));
		
		System.out.println("Starting threads.....");
		
		
		producerThread.start();
		consumerThread.start();
		
		// from the main thread, WAIT for the producerThread and the Consumer thread to finish their business
		
		try {
			producerThread.join(); // calling.join() from the main method will cause the Main thread to wait until they				
			consumerThread.join(); // finish
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		// this line won't print UNTIL the threads that the main thread has joined with complete, themselves
		System.out.println("End of the main method");
		
		// what does wait() do? (comes from the Object.java class)
		// what does notifyAll() do?
		// what does the synchronized keyword do?
		// what does join() do? (comes from Thread class)
		
	}
	
	
}

class Holder {
	
	int contents = 0;
	boolean avail = false; // this will represent whether this data structure CAN be assigned a new value
	
	// The Consumer thread will call this method on the Holder object
	// any thread that accesses a synchronized  method obtains a lock
	// when entering the method.  Only one thread at a time can access a method that's marked as synchronize
	synchronized int getVal() { // returns the value of the contens
		// when the consumer is DONE  rreading the value, we signal to the producer 
		
		try {
			Thread.sleep(5); // this is an extra second to allow the producer to complete before we get another value
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		while (avail == false) {
			
			try {
				wait(); // it freezes the thread that's trying to access this object
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		avail = false;
		notifyAll();
		return contents;
		
	}
	
	// the Producer Thread will call this method
	synchronized void setVal(int val) { // assign the value of the contents 
		
		try {
			Thread.sleep(5); // this is an extra second to allow the consumer to complete before we set another value
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		// when we set a value...we signal to the other thread (the consumer) to read the value
		while (avail == true) {
			
			try {
				wait(); // wait() freezes the thread until another thread calls notifyAll() method (or notify)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		contents = val;
		avail = true; // tioggling this property of the object (rememebr, BOTH threads are accessing the same object)
		notifyAll(); // notifyAll() will unfreeze another thread
		
	}
	
}


class Producer implements Runnable {
	
	public Holder data;
	int max;
	
	public Producer(Holder data, int max) {
		
		this.data = data;
		this.max = max;
		
	}

	@Override
	public void run() {
		// loop from 0 to the max 
		for (int i=0; i<=max; i++) {
			this.data.setVal(i); // whatever the value of i is, we're gonna set the contents of the holder = to it
			System.out.println("Producer put " + i);
		}
	}
}

class Consumer implements Runnable {
	
	public Holder data;
	int max;
	
	public Consumer(Holder data, int max) {
		
		this.data = data;
		this.max = max;
		
	}

	@Override
	public void run() {
		// loop from 0 to the max 
		for (int i=0; i<=max; i++) {
			int currentData = this.data.getVal();
			System.out.println("Consumer got " + currentData);
		}
	}
}







