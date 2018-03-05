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
		String a = request.getParameter("a");
		String b = request.getParameter("b");
	%>
	<h2>page2</h2>
	page1에서 가져온 결과
	<hr>
	<p>
		a=<%=a%>
	<p>
		b=<%=b%>
	<p>
</body>
</html>