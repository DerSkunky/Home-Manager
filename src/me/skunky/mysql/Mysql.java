package me.skunky.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mysql {

	String host = "localhost";
	String port = "3306";
	String database = "test_db";
	String username = "username";
	String password = "password";
	Connection con;
	
	PreparedStatement ps;
	
	public void connect() {
		if(!isConnected()){
			try {
				con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
				System.out.println("MySQL Connected!");
			} catch(SQLException e) {
				System.out.println("MySQL Connection failed!");
				System.out.println("SQLException: " + e.getNextException());
				System.out.println("Error Code: " + e.getErrorCode());
			}
		}
	}
	
	public void disconnect() {
		if(isConnected()) {
			try {
				con.close();
				System.out.println("MySQL Connection successfully closed!");
			} catch(SQLException e) {
				System.out.println("Error while closing MySQL Connection!");
				System.out.println("Exception: " + e.getNextException());
				System.out.println("Error Code: " + e.getErrorCode());
			}
		}
	}

	public void update(String qry) {
		try {
			ps = con.prepareStatement(qry);
			ps.executeUpdate();
			System.out.println("MySQL Update successfully performed");
		} catch(SQLException e) {
			System.out.println("Error while executing MySQL Update!");
			System.out.println("Exception: " + e.getNextException());
			System.out.println("Error Code: " + e.getErrorCode());
		}
	}
	
	public ResultSet getResult(String qry) {
		try {
			ps = con.prepareStatement(qry);
			return ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean isConnected() {
		return (con == null ? false : true);
	}
	
	public boolean stillConnected() {
		return false;
	}
}