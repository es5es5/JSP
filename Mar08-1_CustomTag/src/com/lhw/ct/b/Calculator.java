package com.lhw.ct.b;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculator {
	
	public static void calc(HttpServletRequest request, HttpServletResponse response) {
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		
		int z = x + y;
		request.setAttribute("hab", z);
		
		request.setAttribute("d", 12421.2142142142141);
		
		Date d = new Date();
		request.setAttribute("now", d);
		
		request.setAttribute("str", "æ»≥Á«œºÓ");
	}

}
