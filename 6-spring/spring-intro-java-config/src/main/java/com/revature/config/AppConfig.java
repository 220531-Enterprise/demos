package com.revature.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.revature.models.Coach;
import com.revature.models.FootballCoach;
import com.revature.models.TrackCoach;
import com.revature.services.MotivationService;

/**
 * @Configuration indicates that a class declares one or more @Bean methods and
 *                may be processed by the Spring container to generate bean
 *                definitions and service requests for those beans at runtime.
 * 
 * @PropertySource defines where a properties file might exists that defines
 *                 some values
 * 
 * @ComponentScan With Spring we use the @ComponentScan annotation along with
 *                the @Configuration annotation to specify the packages that we
 *                want to be scanned.
 */
@Configuration
@PropertySource("classpath:app.properties")
@ComponentScan("com.revature")
public class AppConfig {
	
	// @Value allows us to interpolate a value from an app.properties file
	@Value("${coach.email}")
	private String email;

	/**
	 * @Bean is an annotation tells that a method produces a bean to be managed by
	 *       the Spring container. It is a method-level annotation. During Java
	 *       configuration ( @Configuration ), the method is executed and its return
	 *       value is registered as a bean within a BeanFactory
	 */
	@Bean
	@Scope("prototype")
	public Coach myCoach() {
		return new TrackCoach(myMotivationService()); // pass through another bean method that generates the dependency
	}
	
	@Bean
	public MotivationService myMotivationService() {
		return new MotivationService();
	}
	
	@Bean(initMethod="customInit", destroyMethod="customDestroy")
	public FootballCoach myFootballCoach() {
		
		FootballCoach coach = new FootballCoach();
		coach.setTeamName("The Jets");
		coach.setEmail(email);
		coach.setMotivationService(myMotivationService());
		return coach;
	}
	
}





















