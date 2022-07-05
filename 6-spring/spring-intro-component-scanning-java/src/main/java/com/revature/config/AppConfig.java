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
@ComponentScan("com.revature") // if no package is specified, then Spring will scan the package that this class is in
public class AppConfig {
	
	// all the @Bean method declarations are now converted to @Component class-level annotations
	
}





















