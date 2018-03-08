package com.lhw.db.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBManager {

	// 구닥다리 방식
	// DB서버와 연결 해달라고 하면 그제서야 연결하려고 뻘짓 중
	// Java에서 사용함..
	public static Connection oldConnect() throws ClassNotFoundException, SQLException {
		// OracleDriver 클래스 지정
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// DB서버 주소
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		return DriverManager.getConnection(url, "lhw", "lhw");
	}

	public static Connection connect() throws NamingException, SQLException {

		// context.xml
		Context ctx = new InitialContext();

		// 튜브 대여소(Connection 대여소)
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/lhwPool");
		
		return ds.getConnection();
	}

	public static void close() {

	}
}
