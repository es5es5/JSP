package com.lhw.db.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DAO {

	public static void selectTest(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 연결
			con = DBManager.connect();

			// 값 가져오기

			// sql(값이 들어갈 자리에 '?')
			String sql = "select * from mar09_student";

			// pstmt 만들고
			pstmt = con.prepareStatement(sql);

			// ? 채우기

			// SELECT 실행
			rs = pstmt.executeQuery();

			// ResultSet -> ArrayList<Student>
			ArrayList<StudentDTO> students = new ArrayList<>();
			StudentDTO s = null;

			while (rs.next()) {
				s = new StudentDTO();
				s.setName(rs.getString("s_name"));
				s.setAge(rs.getInt("s_age"));
				students.add(s);
			}
			
			request.setAttribute("students", students);

		} catch (Exception e) {
			request.setAttribute("r", "Failed DB Connect");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

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

			// INSERT 실행
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "Succeeded INSERT");
			} else {
				request.setAttribute("r", "Failed 실패");
			}
		} catch (Exception e) {
			request.setAttribute("r", "Failed DB Connect");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public static void connectTest(HttpServletRequest request, HttpServletResponse response) {
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
