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

		if (what.equals("+")) {
	%>

	<h2>HTML 끼어들기~</h2>
	<h2><%=x%>
		+
		<%=y%>
		=
		<%=x + y%></h2>

	<%
		} else if (what.equals("-")) {
	%>

	<h2><%=x%>
		-
		<%=y%>
		=
		<%=x - y%></h2>
	<%
		} else if (what.equals("*")) {
	%>

	<h2><%=x%>
		*
		<%=y%>
		=
		<%=x * y%></h2>
	<%
		} else if (what.equals("/")) {
	%>

	<h2><%=x%>
		/
		<%=y%>
		=
		<%=x / y%></h2>

	<%
		}
	%>

</body>
</html>