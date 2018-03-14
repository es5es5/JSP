package com.kwon.pt.main;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EModel {

	public static void test(HttpServletRequest request, HttpServletResponse response) {
		// 파라메터명(input name="" 보고)
		String zcx = request.getParameter("aa");
		int vasd = Integer.parseInt(request.getParameter("bb"));
		
		System.out.println(zcx);
		System.out.println(vasd);
		
		String zxcvnxcv = "ㅎㅎㅎㅎㅎㅎ";
		request.setAttribute("cc", zxcvnxcv);
		
		// request.파라미터
		//		HTML이나 JSP에서 만들어낸 값
		//		String or String[]
		//		request에 소속, 새로운 요청이 일어나면 값 없어짐..
		// request.어트리뷰트
		// 	JAVA에서 만들어낸 값
		//	Object
		//		request에 소속, 새로운 요청이 일어나면 값 없어짐..

		// 새로운 요청이 일어나도 없어지지 않는 값을 써야함
		// session
		// cookie

		
		// session.attribute
		//		JAVA에서 만든 값
		//		Object
		//		session(서버-클라이언트 연결)에 소속
		String asd = "가나다라";
		HttpSession hs = request.getSession();
		hs.setAttribute("asd", asd);
		hs.setMaxInactiveInterval(50); // 5초
//		hs.invalidate(); // 세션 끊기

		// cookie
		//		JAVA에서 만든 값
		//		String
		//		클라이언트 컴퓨터에 파일로 저장
		
		Cookie c = new Cookie("zec", "hello");
		c.setMaxAge(50); // 5초 
		response.addCookie(c);
	}

	public static void test2(HttpServletRequest request, HttpServletResponse response) {
		String aa = request.getParameter("aa");
		String bb = request.getParameter("bb");
		
		String cc = (String) request.getAttribute("cc");
		
		System.out.println(aa);
		System.out.println(bb);
		System.out.println(cc);
		
		HttpSession hs = request.getSession();
		String asd = (String) hs.getAttribute("asd");
		System.out.println(asd);
		
		Cookie[] cookies = request.getCookies();
		
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("zec")) {
				System.out.println(cookie.getValue());
			}
				
		}
		
	}
	
}








