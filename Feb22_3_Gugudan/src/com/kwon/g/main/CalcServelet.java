package com.kwon.g.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServelet
 */
@WebServlet("/CalcServelet")
public class CalcServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalcServelet() {
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
		String what = request.getParameter("what");
		int y = Integer.parseInt(request.getParameter("y"));

		StringBuffer sb = new StringBuffer();
		sb.append("<html><head></head><body>");

		sb.append(String.format("%d %s %d<br>", x, what));

		sb.append("</body></html>");

		String html = sb.toString();
		PrintWriter out = response.getWriter();
		out.println(html);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
