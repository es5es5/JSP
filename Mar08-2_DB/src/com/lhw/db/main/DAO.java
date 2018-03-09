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
			// 연결
			con = DBManager.connect();

			// 입력
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));

			// sql(값이 들어갈 자리에 '?')
			String sql = "insert into MAR09_STUDENT values(?, ?)";

			// pstmt 만들고
			pstmt = con.prepareStatement(sql);

			// ? 채우기
			pstmt.setString(1, name);
			pstmt.setInt(2, age);

			// 실행
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "Succeeded INSERT");
			} else {
				request.setAttribute("r", "Failed 실패");
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
