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

	// ��û �ּ�
	// ���� ip �ּ�(or dns):��Ʈ��ȣ/����/���ϸ�?������=��&������=��
	// ��Ʈ��ȣ�� 80�̸� ���� ����
	// �������� ROOT�� ���� ����
	// ���ϸ��� index.html�̸� ���� ����

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");
		// ��û �Ķ���� �� �б�
		String d = request.getParameter("dan"); // ������
		// String -> int
		int dd = Integer.parseInt(d);

		StringBuffer sb = new StringBuffer();
		sb.append("<html><head></head><body><table border='1'>");

		String t = null;
		t = String.format("<tr><th>%d��</th></tr>", dd);
		sb.append(t);
		for (int i = 1; i <= 9; i++) {
			t = String.format("<tr>" + "<td align='center'>" + "%d x %d = %d" + "</td>" + "</tr>", dd, i, dd * i);
			sb.append(t);
		}
		sb.append("</table></body></html>");

		String b = request.getParameter("border"); // ������

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
