<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("euc-kr"); // POST인 경우
		// response.setCharacterEncoding("euc-kr"); JSP 에서는 response는 안 써도 됨
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		String what = request.getParameter("what");
		String result = null;

		if (what.equals("+")) {
			result = String.format("%d + %d = %d", x, y, x + y);
		} else if (what.equals("-")) {
			result = String.format("%d - %d = %d", x, y, x - y);
		} else if (what.equals("*")) {
			result = String.format("%d * %d = %d", x, y, x * y);
		} else if (what.equals("/")) {
			result = String.format("%d / %d = %d", x, y, x / y);
		}
	%>

	<marquee>
		<h2>
			<%=result%>
		</h2>
	</marquee>

</body>
</html>