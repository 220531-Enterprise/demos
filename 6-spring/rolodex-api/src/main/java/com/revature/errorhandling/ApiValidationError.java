package com.revature.errorhandling;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false) // prevent an infinite loop 
public class ApiValidationError extends ApiSubError {

	private String object; // the Type of the object (the name of the class of the obj the user was trying to insert)
	private String field; // the field name that failed validation
	private Object rejectedValue; // the value that didn't pass validation
	private String reason; // a message explaining why the object couldn't pass validation
	
	// 3 constructors below using constructor chaining (this() )
	public ApiValidationError(String object, String reason) {
		this.object = object;
		this.reason = reason;
	}
	
	public ApiValidationError(String object, String field, String reason) {
		this(object, reason); // calling the above constructor
		this.field = field;
	}
	
	public ApiValidationError(String object, String field, String reason, Object rejectedValue) {
		this(object, field, reason); // calling the above constructor
		this.rejectedValue = rejectedValue;
	}
	
}
