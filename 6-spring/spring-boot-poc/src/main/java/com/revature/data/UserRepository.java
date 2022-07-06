package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;


/**
 * Spring Data JPA is an add-on It provides a framework that works with JPA and
 * provides a complete abstraction over the Data Access Layer. Spring Data JPA
 * brings in the concept of JPA Repositories, a set of Interfaces that defines
 * query methods. The Repository and Entity Bean represent the DAO layer in the
 * application.
 * 
 * What Is the Difference Between Hibernate and Spring Data JPA?
 * 
 * Hibernate is a JPA implementation, while Spring Data JPA is a JPA Data Access
 * Abstraction. Spring Data offers a solution to GenericDao custom
 * implementations. It can also generate JPA queries on your behalf through
 * method name conventions. 
 * 
 * Spring Data JPA is not a JPA provider. It is a
 * library/framework that adds an extra layer of abstraction on the top of our
 * JPA provider (like Hibernate).
 */

@Repository // @Repository is a STEREOTYPE annotation (specification of @Component)
public interface UserRepository extends JpaRepository<User, Integer>{
	
	// Difference between a DAO and Repository? A reposistory is a DAO specific to a type of object
	
	// JpaRepository extends CrudRepository

	// Property Expression
	// TODO: add an abstract method called findByUsernameAndPassword(String username, String password)
	User findUserByUsernameAndPassword(String username, String password);


}



