package com.kwon.biman2.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Doctor {

	public static void calculate(HttpServletRequest request, HttpServletResponse response) {
		try {
			// POST��� ��û�϶� �Ķ���� �ѱ�ó��
			// �Ķ���͸� ���ʷ� �б� ���� ���;�
			request.setCharacterEncoding("euc-kr");
			
			double h = Double.parseDouble(request.getParameter("h"));
			double w = Double.parseDouble(request.getParameter("w"));
			
			double h2 = h / 100;
			double bmi = w / (h2 * h2);
			
			String result = "��ü��";
			if (bmi >= 35) {
				result = "�� ��";	
			} else if (bmi >= 30) {
				result = "�ߵ ��";
			} else if (bmi >= 25) {
				result = "�浵 ��";
			} else if (bmi >= 23) {
				result = "��ü��";
			} else if (bmi >= 18.5) {
				result = "����";
			}
			
			Result r = new Result(bmi, result);
			request.setAttribute("rrrrr", r);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}














