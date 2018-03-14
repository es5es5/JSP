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
	
	// �α��� ���� üũ�ϴ� �޼ҵ�
	// �α��� �� ���¸� true
	// �α����� Ǯ�� ���¸� false
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
			
			// id�� XX�� ����� ������ �����ͼ�
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
					hs.setMaxInactiveInterval(10); // 10�е��� �α��� ����
				} else {
					request.setAttribute("loginPage", "��� Ʋ��");
				}
			} else {
				request.setAttribute("r", "�׷� ID�� ����");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB ���� ����");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}
}
