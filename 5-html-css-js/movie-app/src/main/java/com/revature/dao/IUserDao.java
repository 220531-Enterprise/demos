package com.revature.dao;

import java.util.List;

import com.revature.models.User;

public interface IUserDao {
	
	int insert(User u);
	
	User selectById(int id);
	
	List<User> selectAll();
}
