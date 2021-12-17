package com.java.phoneBook.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtility {
	private static Connection con;
	static {
		try {
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_tutorial?user=root&password=1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// This method is used for creating PreparedStatment object
	public PreparedStatement createPST(String sql) throws SQLException {
		
		return con.prepareStatement(sql);
	}

	// This method is used for update/delete/create phone book entry
	public int update(PreparedStatement pst) throws SQLException {
		return pst.executeUpdate();
	}
	// This method is used for retrive data from phone book db
	public ResultSet query(PreparedStatement pst) throws SQLException {
		return pst.executeQuery();
	}


	public boolean testCon() {
		if (con != null) {
			return true;
		} else
			return false;
	}

}


