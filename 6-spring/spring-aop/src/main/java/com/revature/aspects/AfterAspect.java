package com.revature.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAspect {
	
	private Logger log = LoggerFactory.getLogger(this.getClass()); 

	@After("execution (* com.revature.service.*.*(..))")
	public void after(JoinPoint joinPoint) {
		
		log.info("After execution of {}", joinPoint);
		
	}
	
	// log the return of some method after it's executed
	@AfterReturning(
			value ="execution (* com.revature.service.*.*(..))",
			returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		
		log.info("{} returned value {}", joinPoint, result);
	}
	
	
	// intercept exceptions
	@AfterThrowing(
			value ="execution (* com.revature.service.*.*(..))",
			throwing="exception")
	public void afterThrowing(JoinPoint joinPoint, Object exception) {
		log.info("{} throws exception {}", joinPoint, exception);
	}
	
	
}