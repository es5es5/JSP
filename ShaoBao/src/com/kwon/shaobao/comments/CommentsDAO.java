package com.kwon.shaobao.comments;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kwon.shaobao.main.DBManager;

public class CommentsDAO {

	public static void write(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// ����
			con = DBManager.connect();

			// �ѱ� ó��(POST��)
			request.setCharacterEncoding("euc-kr");

			// �Է�
			String title = request.getParameter("title");
			String txt = request.getParameter("txt");

			// �� �ٲ� ó��
			txt = txt.replace("\n", "<br>");

			// sql(���� �� �ڸ��� '?')
			String sql = "insert into shaobao_comments values(shaobao_comments_seq.nextval, ?, ?, sysdate)";

			// pstmt �����
			pstmt = con.prepareStatement(sql);

			// ? ä���
			pstmt.setString(1, title);
			pstmt.setString(2, txt);

			// INSERT ����
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "Succeeded INSERT");
			} else {
				request.setAttribute("r", "Failed INSERT");
			}
		} catch (Exception e) {
			request.setAttribute("r", "Failed DB Connect");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

}
