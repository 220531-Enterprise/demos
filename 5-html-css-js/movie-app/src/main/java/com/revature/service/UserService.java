package com.revature.service;

import java.util.List;
import java.util.Optional;

import com.revature.dao.IUserDao;
import com.revature.models.User;

public class UserService {

	private IUserDao udao;

	public UserService(IUserDao udao) {
		this.udao = udao;
	}

	public User confirmLogin(String username, String password) {

		Optional<User> possibleUser = udao.selectAll().stream()
				.filter(e -> (e.getUsername().equals(username) && e.getPassword().equals(password)))
				.findFirst();

		return (possibleUser.isPresent() ? possibleUser.get() : new User());

	}

	public List<User> getAll() {
		return udao.selectAll();
	}

	public int register(User u) {
		return udao.insert(u);
	}
	
	public User getById(int id) {
		return udao.selectById(id);
	}

}
