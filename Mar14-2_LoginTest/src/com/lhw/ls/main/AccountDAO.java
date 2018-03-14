package com.lhw.ls.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AccountDAO {
	private static final AccountDAO ADAO = new AccountDAO();

	private AccountDAO() {

	}

	public static AccountDAO getAdao() {
		return ADAO;
	}
	
	// 로그인 여부 체크하는 메소드
	// 로그인 된 상태면 true
	// 로그인이 풀린 상태면 false
	public boolean loginCheck(HttpServletRequest request, HttpServletResponse response) {
		HttpSession hs = request.getSession();
		Account a = (Account) hs.getAttribute("accountInfo");
		
		if ( a== null) {
			request.setAttribute("loginPage", "login.jsp");
			return false;
		} else {
			request.setAttribute("loginPage", "loginOK.jsp");
			return true;
		}
	}

	public void login(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.connect();
			String l_id = request.getParameter("l_id");
			String l_pw = request.getParameter("l_pw");
			
			// id가 XX인 사람의 정보를 가져와서
			String sql = "select * from mar14_logintest where l_id=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, l_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String db_pw = rs.getString("l_pw");
				if (l_pw.equals(db_pw)) {
					Account a = new Account();
					a.setL_id(rs.getString("l_id"));
					a.setL_pw(rs.getString("l_pw"));
					a.setL_name(rs.getString("l_name"));
					
					HttpSession hs = request.getSession();
					hs.setAttribute("accountInfo", a);
					hs.setMaxInactiveInterval(10); // 10분동안 로그인 유지
				} else {
					request.setAttribute("loginPage", "비번 틀림");
				}
			} else {
				request.setAttribute("r", "그런 ID가 없음");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB 서버 문제");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}
}
