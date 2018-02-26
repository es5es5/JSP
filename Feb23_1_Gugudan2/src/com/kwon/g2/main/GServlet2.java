package com.kwon.g2.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GServlet2
 */
@WebServlet("/GServlet2")
public class GServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");
		StringBuffer sb = new StringBuffer();
		sb.append("<html><head>");
		sb.append("<style>table{float:left;}</style>");
		sb.append("</head><body>");
		sb.append("<h1>구구단</h1>");
		String t = null;
		for (int dan = 2; dan <= 9; dan++) {
			sb.append("<table border='1'>");
			t = String.format("<tr><th>%d단</th></tr>", dan);
			sb.append(t);
			for (int i = 1; i <= 9; i++) {
				t = String.format("<tr>"
						+ "<td align='center'>"
						+ "%d x %d = %d"
						+ "</td>"
						+ "</tr>", dan, i, dan * i);
				sb.append(t);
			}
			sb.append("</table>");
		}
		sb.append("</body></html>");
		
		String html = sb.toString();
		PrintWriter out = response.getWriter();
		out.print(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
