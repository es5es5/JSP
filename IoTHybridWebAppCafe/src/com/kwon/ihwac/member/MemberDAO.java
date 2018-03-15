package com.kwon.ihwac.member;

import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kwon.ihwac.main.DBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MemberDAO {
	private static final MemberDAO MDAO = new MemberDAO();

	private MemberDAO() {
		// TODO Auto-generated constructor stub
	}

	public static MemberDAO getMdao() {
		return MDAO;
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
			
			String sql = "insert into IHWAC_MEMBER values("
					+ "?, ?, ?, ?, "
					+ "to_date(?, 'YYYYMMDD'), "
					+ "?)";
			
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
}
