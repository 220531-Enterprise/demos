package com.revature.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.Credentials;
import com.revature.models.User;
import com.revature.services.UserService;

/**
 * This class will provide login functionality
 */

@RestController
@RequestMapping("/login")
public class AuthController {

	private UserService userService;
	
	@Autowired
	public AuthController(UserService userService) {
		this.userService = userService;
	}
	
	// method to process login
	@PostMapping   /// SHOUTOUT TO CAMERON FOR THIS FIX - PUT @REQUESTBODY IN THE ARGS
	public ResponseEntity<User> login(@Valid @RequestBody Credentials creds) {
		
		User user = userService.processLogin(creds.getUsername(), creds.getPassword());
		
		if (user == null) {
			// this just returns a status with nothing else
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED); // 401
		} else {
			return ResponseEntity.ok(user); // return status 200 with user obj in the body of the response
		}
		
	}
	
	
}






