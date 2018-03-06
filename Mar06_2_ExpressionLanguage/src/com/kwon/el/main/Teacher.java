package com.kwon.el.main;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Teacher {
	public static void calculate(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("euc-kr");
			
			double m = Double.parseDouble(request.getParameter("m"));
			double f = Double.parseDouble(request.getParameter("f"));

			double avg = (m + f) / 2;
			String what = "가";
			if (avg >= 90) {
				what = "수";
			} else if (avg >= 80) {
				what = "우";
			} else if (avg >= 70) {
				what = "미";
			} else if (avg >= 60) {
				what = "양";
			}
			
			request.setAttribute("a", "ㅋ");
			request.setAttribute("b", 1);
			
			Result s = new Result(avg, what);
			request.setAttribute("s", s);

			int[] ar = {1123, 123, 6};
			request.setAttribute("c", ar);
			
			Result[] ar2 = new Result[2];
			ar2[0] = new Result(123.121, "aaa");
			ar2[1] = new Result(1234.12, "bbb");
			request.setAttribute("d", ar2);
			
			ArrayList<Result> al = new ArrayList<>();
			al.add(new Result(1.2, "a"));
			al.add(new Result(134.2, "ba"));
			al.add(new Result(31.2, "ca"));
			request.setAttribute("e", al);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}















