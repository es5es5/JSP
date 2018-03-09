package com.lhw.db.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DAO {

	public static void insertTest(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// ����
			con = DBManager.connect();

			// �Է�
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));

			// sql(���� �� �ڸ��� '?')
			String sql = "insert into MAR09_STUDENT values(?, ?)";

			// pstmt �����
			pstmt = con.prepareStatement(sql);

			// ? ä���
			pstmt.setString(1, name);
			pstmt.setInt(2, age);

			// ����
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "Succeeded INSERT");
			} else {
				request.setAttribute("r", "Failed ����");
			}
		} catch (Exception e) {
			request.setAttribute("r", "Failed DB Connect");
			e.printStackTrace();
		} finally {
			DBManager.close(con, null, null);
		}
	}

	public static void test(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		try {
			DBManager.connect();
			request.setAttribute("r", "Succeeded DB Connect");
		} catch (Exception e) {
			request.setAttribute("r", "Failed DB Connect");
			e.printStackTrace();
		} finally {
			DBManager.close(con, null, null);
		}
	}

}
