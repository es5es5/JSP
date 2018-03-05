<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>수동으로 페이지 이동</title>
</head>
<body>
	<%
		String a = request.getParameter("a");
		String b = request.getParameter("b");

		// page2 -> page3 자동이동 시리즈
		// 1. redirect 요청정보 없이 그냥 감(점검 중 같은거 할 때 쓰셈..)
		// response.sendRedirect("page3.jsp");

		// 2. forward (page1 -> page2로의 요청정보를 page3까지 가지고 이동)
		// RequestDispatcher rd = request.getRequestDispatcher("page3.jsp");
		// rd.forward(request, response);

		// 3. include (page2속에 page3포함) : 위치 조절 불가능, 별로 안 씀..
		// RequestDispatcher rd = request.getRequestDispatcher("page3.jsp");
		// rd.include(request, response);

		// 결론적으로 2번 forward를 제일 많이 씀
		RequestDispatcher rd = request.getRequestDispatcher("page3.jsp");

		// 페이지 전환 시 값이 저장되는 위치
		// 1. parameter
		//		(GET 방식 한정) 주소에 저장
		//		(POST 방식) 내부적으로 저장
		//		input에 쓴거
		//		String or String[]
		String c = a + b;
		
		// 2. attribute
		//		Java로 만들어낸 값
		//		Object
		request.setAttribute("cccc", c); // (Attribute명, 전달할 값)
		Random r = new Random();
		request.setAttribute("rrrr", r);
		
		// Forward로 넘김
		rd.forward(request, response);
	%>
	<h2>This is page2</h2>
	page1에서 가져온 결과
	<hr>
	<p>
		a=<%=a%>
		<p>b=<p>

</body>
	
</html>