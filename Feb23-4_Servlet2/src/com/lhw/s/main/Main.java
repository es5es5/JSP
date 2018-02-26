package com.lhw.s.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Main() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");

		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		String what = request.getParameter("what");

		StringBuffer sb = new StringBuffer();


		sb.append("<html><head></head><body>");

		if(what.equals("+")) {
			
		}
		
		sb.append(String.format("%d %s %d", x, what, y));

		sb.append("</body></html>");

		response.getWriter().println(sb.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// ��û �Ķ���� ������ ���������� ���� ��
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// POST ������� Ŭ���̾�Ʈ�� ������ ������ ���� �� �ѱ� ó��
		request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");

		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));

		StringBuffer sb = new StringBuffer();


		sb.append("<html><head></head><body>");
		sb.append("<h1>GET</h21>");
		
		sb.append(String.format("%d * %d = %d<br>", x, y, x*y));

		sb.append("</body></html>");

		response.getWriter().println(sb.toString());
	}

}
