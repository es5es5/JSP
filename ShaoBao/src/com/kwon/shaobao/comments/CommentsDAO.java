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
	
	public void update(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();
			
			int no = Integer.parseInt(request.getParameter("sc_no"));
			String title = request.getParameter("sc_title");
			String txt = request.getParameter("sc_txt");
			txt = txt.replace("\n", "<br>");

			String sql = "update shaobao_comments set sc_title=?, sc_txt=? where sc_no=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, txt);
			pstmt.setInt(3, no);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "�ı� ���� ����");
			} else {
				request.setAttribute("r", "�ı� ���� ����");
			}
		} catch (Exception e) {
			request.setAttribute("r", "�ı� ���� ����");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();
			
			int no = Integer.parseInt(request.getParameter("sc_no"));

			String sql = "delete from shaobao_comments where sc_no=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "�ı� ���� ����");
			} else {
				request.setAttribute("r", "�ı� ���� ����");
			}
		} catch (Exception e) {
			request.setAttribute("r", "�ı� ���� ����");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	// ������ ��ȣ ������ �� ������ �ش��ϴ� �����͸� ���� �ִ� �޼ҵ�
	public void paging(int page, HttpServletRequest request, HttpServletResponse response) {
		// ��ü ������ �� ���
		double cnt = 12; // �� �������� ���� �ı� ��
		int commentsSize = comments.size(); // �� �ı� ��
		int pageCount = (int) Math.ceil(commentsSize / cnt);
		request.setAttribute("pageCount", pageCount);

		int start = commentsSize - ((int) cnt * (page - 1));
		int end = (page == pageCount) ? -1 : start - ((int) cnt + 1);

		ArrayList<Comment> comments2 = new ArrayList<>();

		// 22 21 20 19 18 17 16 15 14 13
		for (int i = start - 1; i > end; i--) {
			comments2.add(comments.get(i));
		}

		request.setAttribute("comments", comments2);
	}

	public void searchComments(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			String s = request.getParameter("s");

			// sql
			String sql = "select * from shaobao_comments where sc_title like '%'||?||'%' order by sc_date";

			pstmt = con.prepareStatement(sql);

			// ? ä���
			pstmt.setString(1, s);

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
				request.setAttribute("r", "�ƹ� ������ ����");

				comments.add(null);
				comments.add(null);
				comments.add(null);
			}

			// request.setAttribute("comments", comments);

		} catch (Exception e) {
			e.printStackTrace();

			request.setAttribute("r", "DB��������");

			comments = new ArrayList<>();
			comments.add(null);
			comments.add(null);
			comments.add(null);
			// request.setAttribute("comments", comments);

		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void getDetailComments(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			int sc_no = Integer.parseInt(request.getParameter("sc_no"));

			// sql
			String sql = "select * from shaobao_comments where sc_no=?";

			pstmt = con.prepareStatement(sql);

			// ? ä���
			pstmt.setInt(1, sc_no);

			rs = pstmt.executeQuery();

			// comments = new ArrayList<>();

			Comment c = null;
			if (rs.next()) {
				c = new Comment();
				c.setSc_no(rs.getInt("sc_no"));
				c.setSc_title(rs.getString("sc_title"));

				// textarea�� ����Ϸ��� <br> -> \n
				String sc_txt = rs.getString("sc_txt");
				sc_txt = sc_txt.replace("<br>", "\n");
				c.setSc_txt(sc_txt);
				
				c.setSc_date(rs.getDate("sc_date"));
				request.setAttribute("c", c);
			} else {
				request.setAttribute("r", "�ƹ� ������ ����");
			}

		} catch (Exception e) {
			e.printStackTrace();

			request.setAttribute("r", "DB��������");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void getAllComments(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			// ���ϴ°��� �ݴ� ������
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
				request.setAttribute("r", "�ƹ� ������ ����");

				comments.add(null);
				comments.add(null);
				comments.add(null);
			}

			// request.setAttribute("comments", comments);

		} catch (Exception e) {
			e.printStackTrace();

			request.setAttribute("r", "DB��������");

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
				request.setAttribute("r", "�ı� ��� ����");
			} else {
				request.setAttribute("r", "�ı� ��� ����");
			}
		} catch (Exception e) {
			request.setAttribute("r", "�ı� ��� ����");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}
}
