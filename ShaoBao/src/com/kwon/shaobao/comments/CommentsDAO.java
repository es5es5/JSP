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
			// 연결
			con = DBManager.connect();

			// 한글 처리(POST라서)
			request.setCharacterEncoding("euc-kr");

			// 입력
			String title = request.getParameter("title");
			String txt = request.getParameter("txt");

			// 줄 바꿈 처리
			txt = txt.replace("\n", "<br>");

			// sql(값이 들어갈 자리에 '?')
			String sql = "insert into shaobao_comments values(shaobao_comments_seq.nextval, ?, ?, sysdate)";

			// pstmt 만들고
			pstmt = con.prepareStatement(sql);

			// ? 채우기
			pstmt.setString(1, title);
			pstmt.setString(2, txt);

			// INSERT 실행
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
