package com.kwon.g.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("euc-kr");

		String color = request.getParameter("color");
		int size = Integer.parseInt(request.getParameter("size"));

		StringBuffer sb = new StringBuffer();
		sb.append("<html><head>");

		// css
		sb.append(String.format("<style type=\"text/css\">body{color:%s;font-size:%dpt;}</style>", color, size));
		sb.append("</head><body>");
		sb.append("안녕</body></html>");

		response.getWriter().println(sb.toString());
		
//		String html = sb.toString();
//		PrintWriter out = response.getWriter();
//		out.println(html);
		
		// 위에 주석 3줄 아래와 같은 이치
		
//		PrintStream sss = System.out;
//		sss.println("aaa");
//		----> System.out.println("aaa");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
