package com.lhw.db.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

	// ���ڴٸ� ���
	// DB������ ���� �ش޶�� �ϸ� �������� �����Ϸ��� ���� ��
	public static Connection oldConnect() throws ClassNotFoundException, SQLException {
		// OracleDriver Ŭ���� ����
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// DB���� �ּ�
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		return DriverManager.getConnection(url, "lhw", "lhw");
	}

	public static void close() {

	}
}
