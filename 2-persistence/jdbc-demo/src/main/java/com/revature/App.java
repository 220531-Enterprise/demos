package com.revature;

import org.apache.log4j.Logger;

import com.revature.util.ConnectionUtil;

public class App {
	
	private static Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {
		
		logger.info("Starting application......");
		
		ConnectionUtil.getConnection();

	}

}
