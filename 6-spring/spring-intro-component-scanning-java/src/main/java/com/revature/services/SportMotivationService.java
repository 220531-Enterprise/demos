package com.revature.services;

import org.springframework.stereotype.Service;

/**
 * @Service is a Stereotype Annotation. It is a specialization of @Component. We
 *          mark beans with @Service to indicate that they're holding the
 *          business logic. @Repository and @Controller also exist as stereotype
 *          annotations
 *
 * https://www.baeldung.com/spring-bean-annotations
 */
@Service
public class SportMotivationService implements MotivationService {

	@Override
	public String getMotivation() {
		return "Don't quit. Suffer now and live the rest of your life a champion";
	}

}
