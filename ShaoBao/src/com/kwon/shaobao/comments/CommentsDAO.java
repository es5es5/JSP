package com.kwon.shaobao.comments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kwon.shaobao.main.DBManager;

public class CommentsDAO {
	private ArrayList<Comment> comments;
	private static final CommentsDAO CDAO = new CommentsDAO();

	private CommentsDAO() {
		// TODO Auto-generated constructor stub
	}

	public static CommentsDAO getCdao() {
		return CDAO;
	}

	// 페이지 번호 넣으면 그 페이지 해당하는 데이터만 꺼내 주는 메소드
	public void paging(int page, HttpServletRequest request, HttpServletResponse response) {
		// 전체 페이지 수 계산
		double cnt = 12; // 한 페이지당 나올 후기 수
		int commentsSize = comments.size(); // 총 후기 수
		int pageCount = (int) Math.ceil(commentsSize / cnt);
		request.setAttribute("pageCount", pageCount);

		int start = commentsSize 
				- ((int) cnt * (page - 1));
		int end = (page == pageCount) 
				? -1 : start - ((int) cnt + 1);

		ArrayList<Comment> comments2 = new ArrayList<>();

		// 22 21 20 19 18 17 16 15 14 13
		for (int i = start - 1; i > end; i--) {
			comments2.add(comments.get(i));
		}

		request.setAttribute("comments", comments2);
	}

	public void getAllComments(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			// 원하는것의 반대 순서로
			String sql = "select * from shaobao_comments " + "order by sc_date";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			comments = new ArrayList<>();
			Comment c = null;
			while (rs.next()) {
				c = new Comment();
				c.setSc_no(rs.getInt("sc_no"));
				c.setSc_title(rs.getString("sc_title"));
				c.setSc_txt(rs.getString("sc_txt"));
				c.setSc_date(rs.getDate("sc_date"));
				comments.add(c);
			}

			if (comments.size() == 0) {
				request.setAttribute("r", "아무 데이터 없음");

				comments.add(null);
				comments.add(null);
				comments.add(null);
			}

			// request.setAttribute("comments", comments);

		} catch (Exception e) {
			e.printStackTrace();

			request.setAttribute("r", "DB서버오류");

			comments = new ArrayList<>();
			comments.add(null);
			comments.add(null);
			comments.add(null);
			// request.setAttribute("comments", comments);

		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void write(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			request.setCharacterEncoding("euc-kr"); // POST
			String title = request.getParameter("title");
			String txt = request.getParameter("txt");
			txt = txt.replace("\n", "<br>");

			String sql = "insert into shaobao_comments " + "values(shaobao_comments_seq.nextval, " + "?, ?, sysdate)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, txt);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "후기 등록 성공");
			} else {
				request.setAttribute("r", "후기 등록 실패");
			}
		} catch (Exception e) {
			request.setAttribute("r", "후기 등록 실패");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

}
