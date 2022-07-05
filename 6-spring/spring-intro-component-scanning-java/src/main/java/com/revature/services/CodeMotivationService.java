package com.revature.services;

import org.springframework.beans.factory.annotation.Qualifier;
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
@Qualifier("codeHypeService")
public class CodeMotivationService implements MotivationService{

	@Override
	public String getMotivation() {
		return "Don't quit! Google Stackoverflow and code the rest of you life like a boss.\r\n" + 
				"";
	}

}
