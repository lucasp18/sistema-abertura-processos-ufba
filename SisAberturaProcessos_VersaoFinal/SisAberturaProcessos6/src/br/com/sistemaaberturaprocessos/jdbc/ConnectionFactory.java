	package br.com.sistemaaberturaprocessos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	 public Connection getConnection() {
	     try {
	    	 DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	         return DriverManager.getConnection(
	 "jdbc:mysql://localhost/sap", "root", "root");
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
}
