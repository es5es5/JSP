package com.kwon.pt.main;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EModel {

	public static void test(HttpServletRequest request, HttpServletResponse response) {
		// 督虞五斗誤(input name="" 左壱)
		String zcx = request.getParameter("aa");
		int vasd = Integer.parseInt(request.getParameter("bb"));
		
		System.out.println(zcx);
		System.out.println(vasd);
		
		String zxcvnxcv = "ぞぞぞぞぞぞ";
		request.setAttribute("cc", zxcvnxcv);
		
		// request.督虞耕斗
		//		HTML戚蟹 JSP拭辞 幻級嬢浬 葵
		//		String or String[]
		//		request拭 社紗, 歯稽錘 推短戚 析嬢蟹檎 葵 蒸嬢像..
		// request.嬢闘軒坂闘
		// 	JAVA拭辞 幻級嬢浬 葵
		//	Object
		//		request拭 社紗, 歯稽錘 推短戚 析嬢蟹檎 葵 蒸嬢像..

		// 歯稽錘 推短戚 析嬢蟹亀 蒸嬢走走 省澗 葵聖 潤醤敗
		// session
		// cookie

		
		// session.attribute
		//		JAVA拭辞 幻窮 葵
		//		Object
		//		session(辞獄-適虞戚情闘 尻衣)拭 社紗
		String asd = "亜蟹陥虞";
		HttpSession hs = request.getSession();
		hs.setAttribute("asd", asd);
		hs.setMaxInactiveInterval(50); // 5段
//		hs.invalidate(); // 室芝 快奄

		// cookie
		//		JAVA拭辞 幻窮 葵
		//		String
		//		適虞戚情闘 陳濃斗拭 督析稽 煽舌
		
		Cookie c = new Cookie("zec", "hello");
		c.setMaxAge(50); // 5段 
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








