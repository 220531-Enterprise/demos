package com.revature.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect // an Aspect is a modularization of a concern that cuts across multiple classes
@Configuration //this tells Spring to configure this aspect as part of the global ApplicationContext
public class BeforeAspect {
	
	// logger
	private Logger log = LoggerFactory.getLogger(this.getClass()); 
	
	// build some advice declares WHEN we want to do SOMETHING 
	@Before("execution (* com.revature.data.*.*(..))") // define a PointCut this is SpEL Spring Expression Language
	public void before(JoinPoint joinPoint) {
		
		// this code will fire BEFORE the invocation of any method in the data layer
		log.info("Checking for user access.....");
		
		log.info("Intercepted method call of {}", joinPoint);
	}
	
	
	/**
	 * - JoinPoint: is the opportunity to intercept (almost always a method)
	 * - PointCut: the specific pattern of methods that we're intercepting
	 * - Aspect: the combo of advice + a point cut
	 * - Advice: the implementation of what to do at the pointcut, and when @Before, @After, @Around
	 * 
	 * Restaurant Analogy:
	 * 
	 * The menu is the JoinPoint(all the foods that you CAN order)
	 * Your order is the PointCut (the specific food you order a.k.a the pattern defined in Spring Expression Language)
	 */
	
	
	
	

}
