package com.lhw.pr.member;

import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lhw.pr.main.DBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MemberDAO {

	private static final MemberDAO MDAO = new MemberDAO();

	public static MemberDAO getMdao() {
		return MDAO;
	}

	private MemberDAO() {
		// TODO Auto-generated constructor stub
	}

	public void join(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.connect();

			String path = request.getServletContext().getRealPath("img");

			MultipartRequest mr = new MultipartRequest(request, path, 31457280, "euc-kr",
					new DefaultFileRenamePolicy());

			String m_id = mr.getParameter("m_id");
			String m_pw = mr.getParameter("m_pw");
			String m_name = mr.getParameter("m_name");
			String m_addr = mr.getParameter("m_addr");
			String m_y = mr.getParameter("m_y"); // "1982"
			String m_m = mr.getParameter("m_m"); // "1"
			int m_m2 = Integer.parseInt(m_m); // 1
			String m_d = mr.getParameter("m_d"); // "2"
			int m_d2 = Integer.parseInt(m_d); // 2

			String m_birthday = String.format("%s%02d%02d", m_y, m_m2, m_d2);
			// 19820102

			String m_img = mr.getFilesystemName("m_img");
			m_img = URLEncoder.encode(m_img, "euc-kr");
			m_img = m_img.replace("+", " ");

			String sql = "insert into prac_member values(" + "?, ?, ?, ?," + "to_date(?, 'YYYYMMDD'), " + "?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_id);
			pstmt.setString(2, m_pw);
			pstmt.setString(3, m_name);
			pstmt.setString(4, m_addr);
			pstmt.setString(5, m_birthday);
			pstmt.setString(6, m_img);

			if (pstmt.executeUpdate() == 1) {
				System.out.println("회원가입 성공");
				// request.setAttribute("r", "회원 가입 성공");
			} else {
				System.out.println("회원가입 실패");
				// request.setAttribute("r", "회원 가입 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원가입 실패");
			// request.setAttribute("r", "회원 가입 실패");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public void login(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.connect();

			String m_id = request.getParameter("m_id");
			String m_pw = request.getParameter("m_pw");

			String sql = "select * from prac_member " + "where m_id=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String db_pw = rs.getString("m_pw");

				if (m_pw.equals(db_pw)) {
					Cookie lastLoginID = new Cookie("lastLoginID", m_id);
					lastLoginID.setMaxAge(86400);
					response.addCookie(lastLoginID);

					Member m = new Member();
					m.setM_id(m_id);
					m.setM_pw(m_pw);
					m.setM_name(rs.getString("im_name"));
					m.setM_addr(rs.getString("im_addr"));
					m.setM_birthday(rs.getDate("im_birthday"));
					m.setM_img(rs.getString("im_img"));

					HttpSession hs = request.getSession();
					hs.setAttribute("loginMember", m);
					hs.setMaxInactiveInterval(15 * 60); //

					// 로그인 상태 유지 체크했으면
					if (request.getParameter("im_autologin") != null) {
						Cookie autoLoginID = new Cookie("ihwacAutoLoginID", m_id);
						autoLoginID.setMaxAge(86400);
						response.addCookie(autoLoginID);
					}

				} else {
					request.setAttribute("r", "비밀번호 오류");
				}

			} else {
				request.setAttribute("r", "그런 계정 없음");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB 서버 문제");
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public boolean loginCheck(HttpServletRequest request, HttpServletResponse response) {
//		HttpSession hs = request.getSession();
//		Member m = (Member) hs.getAttribute("loginMember");
//
//		if (m != null) {
//			request.setAttribute("loginPage", "member/loginOK.jsp");
//			return true;
//		}
		request.setAttribute("loginPage", "member/login.jsp");
		return false;
	}

}
