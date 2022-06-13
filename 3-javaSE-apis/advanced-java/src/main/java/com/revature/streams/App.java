package com.revature.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class App {

	/**
	 * The Stream API was introduced in Java 8
	 * It is used to process a collection of objects.
	 * 
	 * A stream is NOT a collection. It is a sequence of 
	 * object references that support various methods that can
	 * be pipelined to produce a desired result,
	 * without changing the underlying data source.
	 * 
	 * We use Streams to take input from Collections,
	 * Arrays, or IO channels.
	 */
	public static void main(String[] args) {
		
		List<String> bingoNums = Arrays.asList(
				
				"D40", "D46",
				"B12", "B6",
				"G53", "G42", "g15",
				"I12", "I09"
				
				);
		
		// print only the numbers that start with the letter G
		
		bingoNums.forEach(n -> {
			
			if (n.startsWith("G")) {
				System.out.println(n);
			} // we would have to change the underlying data structure to capture
			// g15
			
		});
		
		System.out.println("===========STREAM BELOW===========");
		
		// stream() the list so that I can transform REFERENCES to th
		// the underlyting data structure
		
		// Find all the bingo numbers that begin with the letter g (even if they are lowercase)
		
		bingoNums.stream()
			.map(n -> n.toUpperCase()) // map() performs a function to each element
			.filter(n -> n.startsWith("G")) // only numbers that pass this predicate as true
			.sorted() // since the elements are of type String, we can sort them
			.forEach(System.out::println); // method referencing
		
		
		System.out.println("======ORIGINAL DATA STRUCTURE BELOW =====");
		System.out.println(bingoNums);
		
		// How can I save my first stream to a list?
		List<String> numsThatStartWithGOnly = bingoNums.stream()
				.map(String::toUpperCase) // user Method Referencing
				// What CLASS are you calling what METHOD from?
				.filter(n -> n.startsWith("G"))
				.sorted()
				.collect(Collectors.toList());
		
		System.out.println("====== NEW LIST FROM STREAM =====");
		System.out.println(numsThatStartWithGOnly);
		
		// We're seeking the FIRST value which MAY or may not exist (a bingo num that starts with A)
		Optional<String> aNum = bingoNums.stream()
				// transform everything to uppercase
				.map(String::toUpperCase)
				// filter out all the bingoNums that DON'T start with A
				.filter(n -> n.startsWith("A"))
				.findFirst(); // this is a terminal operation
		
		// IF the value is present, print it, otherwise, print there are no A numbers
//		if (aNum.isPresent()) {
//			
//			// .get() returns the value from the Optional class
//			System.out.println(aNum.get());
//			
//		} else {
//			System.out.println("No A numbers present!!!!");
//		}
		
		// ternary operator form
		System.out.println(aNum.isPresent() ? aNum.get() : "Sorry no value found");
		
	}

}
