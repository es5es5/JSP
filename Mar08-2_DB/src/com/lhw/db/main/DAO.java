package com.lhw.db.main;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DAO {
	public static void test(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		try {
			DBManager.connect();
			request.setAttribute("r", "DB ���� ����");
		} catch (Exception e) {
			request.setAttribute("r", "DB ���� ����");
			e.printStackTrace();
		} finally {
			DBManager.close(con, null, null);
		}
	}
}
