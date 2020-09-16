package me.skunky.mysql;

import java.sql.Connection;
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
		
	}
	
	public void disconnect() {
		
	}
	
	public boolean isConnected() {
		return (con == null ? false : true);
	}
	
	public boolean stillConnected() {
		return false;
	}
	
	public void update(String qry) {
		
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
	
}
