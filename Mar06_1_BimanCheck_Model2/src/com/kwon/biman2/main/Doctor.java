package com.kwon.biman2.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Doctor {

	public static void calculate(HttpServletRequest request, HttpServletResponse response) {
		try {
			// POST방식 요청일때 파라메터 한글처리
			// 파라메터를 최초로 읽기 전에 나와야
			request.setCharacterEncoding("euc-kr");
			
			double h = Double.parseDouble(request.getParameter("h"));
			double w = Double.parseDouble(request.getParameter("w"));
			
			double h2 = h / 100;
			double bmi = w / (h2 * h2);
			
			String result = "저체중";
			if (bmi >= 35) {
				result = "고도 비만";	
			} else if (bmi >= 30) {
				result = "중등도 비만";
			} else if (bmi >= 25) {
				result = "경도 비만";
			} else if (bmi >= 23) {
				result = "과체중";
			} else if (bmi >= 18.5) {
				result = "정상";
			}
			
			Result r = new Result(bmi, result);
			request.setAttribute("rrrrr", r);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}














