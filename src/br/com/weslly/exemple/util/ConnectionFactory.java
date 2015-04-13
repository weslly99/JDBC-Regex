package br.com.weslly.exemple.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private final static String USER = "root";
	private final static String PASSWORD = "root";
	private final static String URL = "jdbc:mysql://localhost/exempleJDBC1";
	
	public static Connection getConnection(){
		Connection connection = null;
		try{
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		}catch(SQLException e){
			
		}
		return connection;
	}
}
