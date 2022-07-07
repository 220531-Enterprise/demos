package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;


/**
 * @RestController is a convenience annotation for creating Restful controllers.
 *                 It is a specialization of @Component and is autodetected
 *                 through classpath scanning. It adds the @Controller
 *                 and @ResponseBody annotations. It converts the response to
 *                 JSON or XML.
 */
@RestController
@RequestMapping("/users") // I cana ccess the followeing methods at http://loclahost:5000/users
public class UserController {
	
	//DB -> DAO (Repo layer) -> Service layer -> Controller
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	// add functionality to response to GET request, POST, PUT, DELETE

	
	// return all Users from the DB in JSON if a GET request hits http://loclahost:5000/users
	
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers(); // returns in a JSON list
	}
	
	// http://loclahost:5000/users/3
	/**
	 * ResponseEntity is meant to represent the entire HTTP response. You can
	 * control anything that goes into it: status code, headers, and body.
	 * 
	 * https://stackoverflow.com/questions/26549379/when-use-responseentityt-and-restcontroller-for-spring-restful-applications#:~:text=266,headers%2C%20and%20body.
	 */
	@GetMapping("/{id}") // Http://localhost:5000/users/32
	public ResponseEntity<User> findUserById(@PathVariable("id") int id) {
		
		Optional<User> user = userService.getById(id);
		
		if (!user.isPresent()) {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		} else {
			// If successfully set the status code to 200 and return 
			// the user object in body of HTTP Response
			return ResponseEntity.ok(user.get());
		}
	}
	
	
	// register a USER /users
	@PostMapping
	public User registerNewUser(@Valid @RequestBody User newUser) {
		return userService.processRegister(newUser);
	}
	
	@PutMapping  // (full replacement of the record with the updated version)
	public User updateUser(@Valid @RequestBody User updatedUser) {	
		return userService.updateUser(updatedUser);	
	}
	
}
