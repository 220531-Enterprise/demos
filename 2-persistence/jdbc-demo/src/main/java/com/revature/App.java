package com.revature;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.revature.dao.UserDaoImpl;
import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class App {
	
	private static Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {
		
		logger.info("Starting application......");
		
//		ConnectionUtil.getConnection();
		
		User u1 = new User("tonystark", "ironman",  Role.Admin, new ArrayList<Account>());
		
		UserDaoImpl uDao = new UserDaoImpl();
		
		uDao.insert(u1);

	}

}
