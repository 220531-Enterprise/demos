package com.revature;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.config.AppConfig;
import com.revature.models.Coach;
import com.revature.models.FootballCoach;

public class SpringDriver {
	
	public static void main(String[] args) {
		
		System.out.println("Creating bean container!");
		
		// Let's use Spring ApplicationContext to define the construction of this bean
//		BaseballCoach coach = new BaseballCoach(new MotivationService());
		
		try (AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class)) {
			
			// IoC means Inversion of Control Container
			System.out.println("Bean container created (IoC container)!");
			
			// Retrieve a bean from the container with the name "myCoach"
			Coach coach = container.getBean("codeCoach", Coach.class); // we're returning an instance of a class
																	 // that implements the Coach interface
			
			// Call some methods on the bean to ensure it's configured properly
			System.out.println(coach.getDailyWorkout());
			System.out.println(coach.getMotivation()); // this means that Spring IoC container properly wired the dependency
			
			// ----------------------------------------------------------
			
			// Attempt to get an assistant coach
			Coach assistantCoach = container.getBean("myCoach", Coach.class);
			System.out.println("Is the assistant coach the same obj as the OG coach? : " + (assistantCoach == coach));
			System.out.println("Does the assistant coach share the same MotivationService obj as the OG coach? " + (assistantCoach.getMotivationService() == coach.getMotivationService()));
			
			// ----------------------------------------------------------
			
            FootballCoach footballCoach = container.getBean("footballCoach", FootballCoach.class);
            System.out.println(footballCoach.getDailyWorkout());
            System.out.println(footballCoach.getMotivation());
            System.out.println(footballCoach.getTeamName());
            System.out.println(footballCoach.getEmail());
			
			// -----------------------------------------------------------
			
			System.out.println("\nThese are all the beans in the container\n");
			
			String[] beans = container.getBeanDefinitionNames();
			Arrays.sort(beans);
			for (String bean : beans) {
				System.out.println(bean);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
