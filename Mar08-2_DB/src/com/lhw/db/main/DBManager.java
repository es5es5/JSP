package com.lhw.db.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

	// 구닥다리 방식
	// DB서버와 연결 해달라고 하면 그제서야 연결하려고 뻘짓 중
	public static Connection oldConnect() throws ClassNotFoundException, SQLException {
		// OracleDriver 클래스 지정
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// DB서버 주소
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		return DriverManager.getConnection(url, "lhw", "lhw");
	}

	public static void close() {

	}
}
