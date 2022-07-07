package com.revature.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.Credentials;
import com.revature.models.User;
import com.revature.service.UserService;
import com.revature.util.JwtTokenManager;

/**
 * Expose an endpoint that a user must initially hit
 * when logging in from the front end to verify whether they are 
 * authenticated or not.
 * 
 * If their username & password indeed exists in the DB, we 
 * will send back a server-generated JWT token that they can use 
 * to continue accessing our server.
 */
@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
@RequestMapping("/login")
public class AuthController {
	
	private UserService userService;
	private JwtTokenManager tokenManager;
	
	@Autowired
	public AuthController(UserService userService, JwtTokenManager tokenManager) {
		super();
		this.userService = userService;
		this.tokenManager = tokenManager;
	}

	// 1. authenticate the user when they sends a POST request to http://localhost:5000/api/login
	@PostMapping
	public User login(@RequestBody Credentials creds, HttpServletResponse response) {
		
		User user = userService.authenticate(creds);
		
		if (user != null) {
			// 2. IF they're in the DB grant them a JWT token so that they can access the data they're allowed to
			String token = tokenManager.issueToken(user); //  xxxxx.yyyyyy.zzzzzzz
			
			// append the token to the response in the header
			response.addHeader("rolodex-token", token);
			response.addHeader("Access-Control-Expose-Headers", "rolodex-token");
			response.setStatus(200); // successful login
			
			// return the user as JSON
			return user;
		} else {
			// 3. otherwise deny
			response.setStatus(401); // 401 is an UNAUTHORIZED status
			return null;
		}
	}	
}