package com.revature.errorhandling;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * The purpose of this class is to model info about an HTTP error.
 */

@Data // toString, hashCode, equals, getters/setters... (if you don't have Lombok, right click -> source -> generate getters/setters
public class ApiError {
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	
	private int status; // represent the error code # 400, 401, 500, etc...
	private String error; // represents the general error
	private String message; // represents the message
	private String debugMessage; // represents the trace message about the error
	
	// List of SubErrors;
	List<ApiSubError> subErrors = new ArrayList<>();

	public ApiError() {
		super(); // calls the constructor of the parent class (Object)
		this.timestamp = LocalDateTime.now(); // captures the time at which this object was instantiated
	}
	
	public ApiError(HttpStatus status) {
		this(); // this() invokes another constructor that takes in the same arguments
		this.status = status.value(); // 4xx, 5xx code, etc...
		this.error = status.getReasonPhrase();
	}
	
	public ApiError(HttpStatus status, Throwable ex) {
		
		this(status); // this will call the above constructor so we can piggy-back off of its functionality
		this.message = "No message available";
		this.debugMessage = ex.getLocalizedMessage();
	}
	
	public ApiError(HttpStatus status, Throwable ex, String message) {
		this(status, ex); // call the constructor above ^
		this.message = message;
	}
	
	public void addSubError(ApiSubError err) {
		this.subErrors.add(err);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
