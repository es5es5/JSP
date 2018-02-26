package com.kwon.g.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GugudanServlet
 */
@WebServlet("/GugudanServlet")
public class GugudanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GugudanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// String 대량으로 붙일 때
		StringBuffer sb = new StringBuffer();
		sb.append("<html><head></head><body><table border='1'>");
		
		String t = null;
		for (int dan = 2; dan <= 9; dan++) {
			t = String.format("<tr><th>%ddan</th></tr>", dan);
			sb.append(t);
			for (int i = 1; i <= 9; i++) {
				t = String.format("<tr>"
						+ "<td align='center'>"
						+ "%d x %d = %d"
						+ "</td>"
						+ "</tr>", dan, i, dan * i);
				sb.append(t);
			}
		}
		sb.append("</table></body></html>");
		
		// StringBuffer -> String
		String html = sb.toString();
		PrintWriter out = response.getWriter();
		out.print(html);
		System.out.println();
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
