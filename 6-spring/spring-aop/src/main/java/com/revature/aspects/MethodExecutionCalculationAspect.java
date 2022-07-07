package com.revature.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * Cross Cutting Concern
 * 
 * A concern is a term that refers to a part of the system divided by functionality.
 *
 * A CROSS-CUTTING concern is a concern that is applicable throughout the entire application,
 * and it affects the entire application.
 * 
 * Examples:
 * - logging
 * - security
 * - data transfer
 */
@Aspect
@Configuration
public class MethodExecutionCalculationAspect {
	
	// Goal: Intercept the service layer's method and calculate HOW LONG
	// it takes to execute it in milliseconds
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Around("execution (* com.revature.service.*.*(..))")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// count from the beginning of the execution
		// capture the start time of the method
		long start = System.currentTimeMillis();
		
		// allow the method to continue
		joinPoint.proceed(); // this gives the method permission to continue
		
		// capture the time after it ended
		long end = System.currentTimeMillis();
		
		// count how long the execution took in milliseconds and log that
		long timeTaken = end - start;
		log.info("The time taken for {} to execute is {} milliseconds", joinPoint, timeTaken);
	}

	// WHAT is Advice @After @Before @Around
	

}






















