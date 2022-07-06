package com.revature.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.revature.util.RegexUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table(name="app_users")
@Data @AllArgsConstructor @NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false, unique=true)
	private String username;
	
	@Pattern(regexp=RegexUtil.PASSWORD_REGEX)
	@Column(nullable=false)
	private String password;
	
	@Pattern(regexp=RegexUtil.EMAIL_REGEX)
	@Column(nullable=false, unique=true)
	private String email;

	@Column(name="register_datetime", updatable=false, columnDefinition="timestamp default CURRENT_TIMESTAMP")
	private LocalDateTime registerDateTime;
	
	@Enumerated(EnumType.STRING)
	private UserRole role;

}
