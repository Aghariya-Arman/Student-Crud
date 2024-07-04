package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

		private  static Connection conn=null;
		
		public static Connection getconn() {
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/arman","root","ammu007");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return conn;
		}
}
