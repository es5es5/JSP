package com.kwon.pt.main;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EModel {

	public static void test(HttpServletRequest request, HttpServletResponse response) {
		// �Ķ���͸�(input name="" ����)
		String zcx = request.getParameter("aa");
		int vasd = Integer.parseInt(request.getParameter("bb"));
		
		System.out.println(zcx);
		System.out.println(vasd);
		
		String zxcvnxcv = "������������";
		request.setAttribute("cc", zxcvnxcv);
		
		// request.�Ķ����
		//		HTML�̳� JSP���� ���� ��
		//		String or String[]
		//		request�� �Ҽ�, ���ο� ��û�� �Ͼ�� �� ������..
		// request.��Ʈ����Ʈ
		// 	JAVA���� ���� ��
		//	Object
		//		request�� �Ҽ�, ���ο� ��û�� �Ͼ�� �� ������..

		// ���ο� ��û�� �Ͼ�� �������� �ʴ� ���� �����
		// session
		// cookie

		
		// session.attribute
		//		JAVA���� ���� ��
		//		Object
		//		session(����-Ŭ���̾�Ʈ ����)�� �Ҽ�
		String asd = "�����ٶ�";
		HttpSession hs = request.getSession();
		hs.setAttribute("asd", asd);
		hs.setMaxInactiveInterval(50); // 5��
//		hs.invalidate(); // ���� ����

		// cookie
		//		JAVA���� ���� ��
		//		String
		//		Ŭ���̾�Ʈ ��ǻ�Ϳ� ���Ϸ� ����
		
		Cookie c = new Cookie("zec", "hello");
		c.setMaxAge(50); // 5�� 
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








