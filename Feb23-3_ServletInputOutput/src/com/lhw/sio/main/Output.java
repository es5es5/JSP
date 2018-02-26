package com.lhw.sio.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Output
 */
@WebServlet("/Output")
public class Output extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Output() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	// ��û �Ķ���� ������ �ּҿ� ����
	// �ּҿ��� �ѱ�, Ư������, ... ���� �ȵ�
	// 		�� -> %2A ��Ĺ�� �ڵ����� ��ȯ����
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");

		String say = request.getParameter("say");
		int cnt = Integer.parseInt(request.getParameter("cnt"));

		StringBuffer sb = new StringBuffer();
		sb.append("<html><head></head><body>");
		sb.append("<h1>GET</h21>");

		for (int i = 0; i < cnt; i++) {
			sb.append("<h1>" + say + "</h>");

		}

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

		String say = request.getParameter("say");
		int cnt = Integer.parseInt(request.getParameter("cnt"));

		StringBuffer sb = new StringBuffer();
		sb.append("<html><head></head><body>");
		sb.append("<h1>POST</h21>");

		for (int i = 0; i < cnt; i++) {
			sb.append("<h1>" + say + "</h>");

		}

		sb.append("</body></html>");

		response.getWriter().println(sb.toString());
	}

}
