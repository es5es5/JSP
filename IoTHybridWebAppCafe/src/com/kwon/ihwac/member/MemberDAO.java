package com.kwon.ihwac.member;

import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kwon.ihwac.main.DBManager;
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

			String path = request.getServletContext().getRealPath("etc");

			MultipartRequest mr = new MultipartRequest(request, path, 31457280, "euc-kr",
					new DefaultFileRenamePolicy());

			String im_y = mr.getParameter("im_y");
			String im_m = mr.getParameter("im_m");
			int im_m2 = Integer.parseInt(im_m);
			String im_d = mr.getParameter("im_d");
			int im_d2 = Integer.parseInt(im_d);

			String im_birthday = String.format("%s%02d%02d", im_y, im_m2, im_d2);

			String im_img = mr.getFilesystemName("im_img"); // ㅋ ㅋ.png
			im_img = URLEncoder.encode(im_img, "euc-kr"); // %2A+%2A.png
			im_img = im_img.replace("+", " "); // %2A %2A.png

			String sql = "insert into IHWAC_MEMBER values(" + "?, ?, ?, ?, " + "to_date(?, 'YYYYMMDD'), " + "?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mr.getParameter("im_id"));
			pstmt.setString(2, mr.getParameter("im_pw"));
			pstmt.setString(3, mr.getParameter("im_name"));
			pstmt.setString(4, mr.getParameter("im_addr"));
			pstmt.setString(5, im_birthday);
			pstmt.setString(6, im_img);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "회원 가입 성공");
			} else {
				request.setAttribute("r", "회원 가입 실패");
			}
		} catch (Exception e) {
			request.setAttribute("r", "회원 가입 실패");
			e.printStackTrace();
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

			String im_id = request.getParameter("im_id");
			String im_pw = request.getParameter("im_pw");

			String sql = "select * from ihwac_member " + "where im_id=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, im_id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String db_pw = rs.getString("im_pw");

				if (im_pw.equals(db_pw)) {
					Cookie lastLoginID = new Cookie("lastLoginID", im_id);
					lastLoginID.setMaxAge(86400);
					response.addCookie(lastLoginID);

					Member m = new Member();
					m.setIm_id(im_id);
					m.setIm_pw(im_pw);
					m.setIm_name(rs.getString("im_name"));
					m.setIm_addr(rs.getString("im_addr"));
					m.setIm_birthday(rs.getDate("im_birthday"));
					m.setIm_img(rs.getString("im_img"));

					HttpSession hs = request.getSession();
					hs.setAttribute("loginMember", m);
					hs.setMaxInactiveInterval(10); //

					// 자동 로그인 사용 여부 검사
					if (request.getParameter("im_autologin") != null) {
						Cookie autoLoginID = new Cookie("ihwacAutoLoginID", im_id);
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
		HttpSession hs = request.getSession();
		Member m = (Member) hs.getAttribute("loginMember");

		if (m != null) {
			request.setAttribute("loginPage", "member/loginOK.jsp");
			return true;
		}
		request.setAttribute("loginPage", "member/login.jsp");
		return false;

	}

	public void logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession hs = request.getSession();
		hs.setAttribute("loginMember", null);
	}

	public void autologin(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] allCookies = request.getCookies();

		if (allCookies != null) {
			for (Cookie cookie : allCookies) {
				// ihwacAutoLoginID이라는 이름의 쿠키가 있으면
				if (cookie.getName().equals("ihwacAutoLoginID")) {
					// 쿠키에 들어있는 값이 있으면
					if (cookie.getValue() != null) {
						Connection con = null;
						PreparedStatement pstmt = null;
						ResultSet rs = null;
						try {
							con = DBManager.connect();

							String im_id = cookie.getValue();

							String sql = "select * from ihwac_member " + "where im_id=?";

							pstmt = con.prepareStatement(sql);
							pstmt.setString(1, im_id);

							rs = pstmt.executeQuery();

							if (rs.next()) {
								String db_pw = rs.getString("im_pw");

								Cookie lastLoginID = new Cookie("lastLoginID", im_id);
								lastLoginID.setMaxAge(86400);
								response.addCookie(lastLoginID);

								Member m = new Member();
								m.setIm_id(im_id);
								m.setIm_pw(db_pw);
								m.setIm_name(rs.getString("im_name"));
								m.setIm_addr(rs.getString("im_addr"));
								m.setIm_birthday(rs.getDate("im_birthday"));
								m.setIm_img(rs.getString("im_img"));

								HttpSession hs = request.getSession();
								hs.setAttribute("loginMember", m);
								hs.setMaxInactiveInterval(10); //

								Cookie autoLoginID = new Cookie("ihwacAutoLoginID", im_id);
								autoLoginID.setMaxAge(86400);
								response.addCookie(autoLoginID);

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
				}
			}
		}
	}
}
