package com.tcs.ilp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtility {
	
	private static Connection connection = null;
	private static String url="jdbc:oracle:thin:@intvmoradb04:1521:ORAJAVADB";
	private static String username="TVM1718_TVM32_TJA171_DEV";
	private static String password="tcstvm32";
		
	public static Connection createConnection() throws ClassNotFoundException, SQLException {		
		Class.forName("oracle.jdbc.OracleDriver");
		connection=DriverManager.getConnection(url, username, password);
		return connection;
	}
	
	public static void closeConnection()
	{
		try
		{
			if(connection!=null && connection.isClosed()==false)
			{
				connection.close();
				connection=null;
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public static void closePreparedStatement(Statement ps){
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}

}
