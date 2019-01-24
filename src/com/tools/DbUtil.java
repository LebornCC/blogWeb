package com.tools;

import java.sql.*;

public class DbUtil {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/bigtest?serverTimezone=GMT&useSSL=true";
	private static String username = "root";
	private static String pwd = "rootroot";
	private static Connection conn;

	//JDBC连接
	public static void getConn(){
		try {
			Class.forName(driver); //加载驱动
			conn = DriverManager.getConnection(url,username, pwd); //获取链接
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//执行MySQL语句
	public ResultSet excuteQuery(String sql){
		ResultSet res = null;
		getConn();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			res = statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
}
