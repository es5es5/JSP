package com.lhw.s.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// 요청 주소
	// 서버 ip 주소(or dns):포트번호/폴더/파일명?변수명=값&변수명=값
	// 포트번호가 80이면 생략 가능
	// 폴더명이 ROOT면 생략 가능
	// 파일명이 index.html이면 생략 가능

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");
		// 요청 파라메터 값 읽기
		String d = request.getParameter("dan"); // 변수명
		// String -> int
		int dd = Integer.parseInt(d);

		StringBuffer sb = new StringBuffer();
		sb.append("<html><head></head><body><table border='1'>");

		String t = null;
		t = String.format("<tr><th>%d단</th></tr>", dd);
		sb.append(t);
		for (int i = 1; i <= 9; i++) {
			t = String.format("<tr>" + "<td align='center'>" + "%d x %d = %d" + "</td>" + "</tr>", dd, i, dd * i);
			sb.append(t);
		}
		sb.append("</table></body></html>");

		String b = request.getParameter("border"); // 변수명

		sb.append("</table></body></html>");

		// StringBuffer -> String
		String html = sb.toString();
		PrintWriter out = response.getWriter();
		out.print(html);
		System.out.println();
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
