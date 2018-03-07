package com.kwon.bb.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HC")
public class HC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameterNames().hasMoreElements()) {
			Referee.getR().judge(request, response);
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
