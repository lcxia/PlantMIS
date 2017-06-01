package com.lhhy.util;

import java.io.IOException;
import java.util.Properties;

public class Config {
	private static Properties prop = new Properties();
	// ���������ļ�
	static {
		try {
			prop.load(Config.class.getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	// ����������
	/*
	 * driver=oracle.jdbc.OracleDriver url=jdbc:oracle:thin:@127.0.0.1:1521:
	 * dbname=xe user=isoft password=i222
	 */
	public static final String DRIVER = prop.getProperty("driver");
	public static final String URL = prop.getProperty("url");
	public static final String DBNAME = prop.getProperty("dbname");
	public static final String USER = prop.getProperty("user");
	public static final String PASSWORD = prop.getProperty("password");

}
