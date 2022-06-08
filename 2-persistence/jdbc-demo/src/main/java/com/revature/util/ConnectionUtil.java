package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection; // JDBC API
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * What is JDBC?
 * 
 * JDBC (Java Database Connectivity) is the Java API that manages 
 * connecting to a database, issuing queries and commands, 
 * and handling result sets obtained from the database
 */

import org.apache.log4j.Logger;

/**
 * 
 * A Singleton Class ensure that there will only be ONE instance of this class
 * during the runtime of an app
 * 
 * -- private constructors 
 * -- static field of an instance of the class to be
 * returned 
 * -- leverage a public static getInstance() (our getInstance method is
 * the getConnection() method
 * 
 * The connection to our DB will be established by a singleton class which will
 * contain all the necessary driver information (jdbc url, username, password).
 *
 */
public class ConnectionUtil {

	private static Logger logger = Logger.getLogger(ConnectionUtil.class);

	// The Connection INterface coemes from the java.sql package which is the JDBC
	// API
	private static Connection conn = null;

	// SIngleton design pattern has a private constructor
	private ConnectionUtil() {

	}

	// The Connection Interface comes from the JDBC API
	// the purpose of this method is to return the single instance of this class
	public static Connection getConnection() {

		// first we check if an instance of this class is already instantiated in the
		// application
		try {
			if (conn != null && !conn.isClosed()) {

				logger.info("returning the re-used connection object");
				return conn;

			}
		} catch (SQLException e) {
			logger.error("we failed to re-use the connection");
			e.printStackTrace();
			return null;
		}

		// To establish connection we need to read from a file with all the credentials
		// to connect
		// to the database
		Properties prop = new Properties(); // import from java.util

		String url = "";
		String username = "";
		String password = "";

		// import FileReader from java.io
		try {
			// The properties object uses a FileReader object to read all of values inside of
			// the file
			prop.load(new FileReader(
					"C:\\Users\\SophieGavrila\\Desktop\\demos\\2-persistence\\jdbc-demo\\src\\main\\resources\\application.properties"));

			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");

			// Once we have the jdbc url, username, and password, we can establish a
			// connection
			conn = DriverManager.getConnection(url, username, password);

			// IF the above line is successful, then the following line of code will execute
			logger.info("established connection to DB!!!!");
			// and we'll return a connection!

		} catch (FileNotFoundException e) {
			// if line 92 ISN'T successful, we will throw one of these errors 
			logger.warn("Can't read from the application.props file at specified path");
			e.printStackTrace();
		} catch (IOException e) {
			logger.warn("couldn't read from application.properties file");
			e.printStackTrace();
		} catch (SQLException e) {
			logger.warn("Can't establish connection to DB");
			e.printStackTrace();
		}

		// if no exceptions are thrown, return the connection
		return conn;

	}

}
