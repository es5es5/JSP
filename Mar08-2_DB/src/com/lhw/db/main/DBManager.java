package com.lhw.db.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBManager {

	// ���ڴٸ� ���
	// DB������ ���� �ش޶�� �ϸ� �������� �����Ϸ��� ���� ��
	// Java���� �����..
	public static Connection oldConnect() throws ClassNotFoundException, SQLException {
		// OracleDriver Ŭ���� ����
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// DB���� �ּ�
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		return DriverManager.getConnection(url, "lhw", "lhw");
	}

	// �̸� ������ �� �� ����� ����
	// DB������ ���� �ش޶�� �ϸ� ����� ���� ������ �ִ� �ý���
	// ConnectionPool
	// TomCat�� JSP ���� ��츸 ��� ����
	public static Connection connect() throws NamingException, SQLException {

		// context.xml
		Context ctx = new InitialContext();

		// Ʃ�� �뿩��(Connection �뿩��)
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/lhwPool");

		return ds.getConnection();
	}

	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {rs.close();} catch (Exception e) {}
		try {pstmt.close();} catch (Exception e) {}
		try {con.close();} catch (Exception e) {}

	}
}
