package com.qf.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class C3P0Utils {

	private  static  ComboPooledDataSource  dataSource =new ComboPooledDataSource();

	public static  ComboPooledDataSource getDataSource() {
		return dataSource;
	}
	
	public static Connection getConnection() {
		try {
			return   dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接异常");
		}
		return null;
	}
}
