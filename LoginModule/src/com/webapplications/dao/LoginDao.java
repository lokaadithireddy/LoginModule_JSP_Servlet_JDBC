package com.webapplications.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	
	String sql = "select * from login where uname=? and pass=?";
	String url = "jdbc:mysql://localhost:3306/users?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//	jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
	String username = "root";
	String password = "root";
	
	public boolean check(String uname,String pass) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("conn"+conn.toString());
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, pass);
			System.out.println(st);
			ResultSet rs = st.executeQuery();
//			System.out.println(rs.getFetchSize());
//			System.out.println(rs.next());
			if(rs.next()) {
				return true;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return false;
	}

}
