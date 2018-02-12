package com.uip.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtil {


	
	
	public static Connection getConn() throws SQLException{
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		Connection conn=cpds.getConnection();
		return conn;
		}
	
	public static void closeAll(Connection con,Statement sta,ResultSet rs) {
		if(rs != null)
			try {
				rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		if(sta != null)
			try {
				sta.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		if(con != null)
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
	}
}

