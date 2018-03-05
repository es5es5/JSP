package com.lhw.jspmodel2.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculator {

	public static void calc(HttpServletRequest request, HttpServletResponse response) {
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		
		int z = x + y;
		
		request.setAttribute("hab", z);
	}
}
