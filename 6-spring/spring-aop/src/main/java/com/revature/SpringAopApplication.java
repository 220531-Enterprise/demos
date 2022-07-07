package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.service.Service1;
import com.revature.service.Service2;

@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner{
	
	// add a logger as a property - SLF4J is a Logging Facade
	// Spring Boot uses Apache Commons logger as its default logger
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Service1 service1;
	
	@Autowired
	private Service2 service2;
	

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	/**
	 * Since we have implemented the CommandLineRunner interface,
	 * we'll run the following logic inside of this method INSTEAD OF launching
	 * some embedded Tomcat server and running the app there.
	 */
	@Override
	public void run(String... args) throws Exception {
		
		// ... allows for an unspecified amount of String arguments to be passed thru
		// var args is the name of ...
		log.info(service1.calculateSomething());
		log.info(service2.calculateSomething());
		
		/**
		 * 1. Service1's method is called
		 * 
		 * 2. The aspect does its thing (logs info)
		 * 
		 * 3. Dao1 method fires
		 * 
		 * 4. Service2 method is called
		 * 
		 * 5. The aspect fires BEFORE the dao's method can fire
		 * 
		 * 6. Dao2 mehtod fires
		 */
		
		
		/**
		 * Goal is to intercept the methods on the service layer when they make a 
		 * call to the DAO
		 */
		
		
	}

}





