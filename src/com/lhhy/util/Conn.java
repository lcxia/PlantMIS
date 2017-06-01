package com.lhhy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {

	public static String driver = "com.mysql.jdbc.Driver";// 定义驱动
	public static String url = "jdbc:mysql://localhost:3306/db_plantres";// 定义URL
	public static String user = "root";// 定义用户名
	public static String password = "19871105";// 定义密码
	public static Connection conn;// 定义连接
	public static Statement stmt;// 定义STMT
	public static PreparedStatement ps;// 定义STMT
	public ResultSet rs;// 定义结果集
	public int i;// 定义增删改执行的记录数
	public static final int PAGE_SIZE = 20;// 每页记录数
	// 设置CONN

	public Conn() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url+ "?useUnicode=true&characterEncoding=utf-8", user, password);
			/*if (conn != null) {
				System.out.println("-------连接成功------");
			} else {
				System.out.println("-------连接失败------");
			}*/
		} catch (ClassNotFoundException classnotfoundexception) {
			classnotfoundexception.printStackTrace();
			System.err.println("db: " + classnotfoundexception.getMessage());
		} catch (SQLException sqlexception) {
			System.err.println("db.getconn(): " + sqlexception.getMessage());
		}
	}

	// 执行增删改
	public int update(String sql) {
		try {
			stmt = conn.createStatement();
			i = stmt.executeUpdate(sql);
			/*System.out.println("执行增、删或改");*/
		} catch (SQLException sqlexception) {
			System.err.println("db.executeUpdate:" + sqlexception.getMessage());
		}
		return i;
	}

	/*
	 * public int updateps(String sql) { try { ps = conn.prepareStatement(sql);
	 * i = ps.executeUpdate(sql); System.out.println("执行增、删或改"); }
	 * catch(SQLException sqlexception) { System.err.println("db.executeUpdate:"
	 * + sqlexception.getMessage()); } return i; }
	 */
	// 查询结果集
	public ResultSet select(String sql) {
		try {
			stmt = conn.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
					java.sql.ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
			/*System.out.println("执行查询");*/
		} catch (SQLException sqlexception) {
			System.err.println("db.executeQuery: " + sqlexception.getMessage());
		}
		return rs;
	}

	/*public ResultSet selectps(String sql, int page) {
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (page - 1) * PAGE_SIZE);
			ps.setInt(2, PAGE_SIZE);
			rs = ps.executeQuery();
			System.out.println("执行查询");
		} catch (SQLException sqlexception) {
			System.err.println("db.executeQuery: " + sqlexception.getMessage());
		}
		return rs;
	}*/

	/**
	 * 关闭数据库结果集，数据库操作对象，数据库链接
	 * 
	 * @Function: Close all the statement and conn int this instance and close
	 *            the parameter ResultSet
	 * @Param: ResultSet
	 * @Exception: SQLException,Exception
	 **/
	public void close() throws SQLException, Exception {

		if (rs != null) {
			rs.close();
			rs = null;
		}

		if (ps != null) {
			ps.close();
			ps = null;
		}

		if (stmt != null) {
			stmt.close();
			stmt = null;
		}

		if (conn != null) {
			conn.close();
			conn = null;
		}
	}

}
