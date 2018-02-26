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
		int x = Integer.parseInt(request.getParameter("xx"));
		int y = Integer.parseInt(request.getParameter("yy"));

		int sum = x + y;
		int sub = x - y;
		int mul = x * y;
		int div = x / y;
	%>

</body>
</html>