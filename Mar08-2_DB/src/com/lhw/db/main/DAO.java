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
			// ����
			con = DBManager.connect();

			// �� ��������

			// sql(���� �� �ڸ��� '?')
			String sql = "select * from mar09_student";

			// pstmt �����
			pstmt = con.prepareStatement(sql);

			// ? ä���

			// SELECT ����
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

			// INSERT ����
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "Succeeded INSERT");
			} else {
				request.setAttribute("r", "Failed ����");
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
