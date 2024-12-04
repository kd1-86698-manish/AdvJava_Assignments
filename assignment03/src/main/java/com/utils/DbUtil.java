package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {

	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/election";
	public static final String DB_USER = "KD1-86698-manish";
	public static final String DB_PASSWD = "manager";

	static {
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception {

		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
		return con;
	}

}
