<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�ڵ����� ������ �̵�</title>
</head>
<body>

	<h1>This is page3</h1>

	<%
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		
		// Object�� �޾ƿ� �͵� ������ ���·� ����ȯ
		String c = (String) request.getAttribute("cccc");
		Random r = (Random) request.getAttribute("rrrr");
	%>
	<p>
		a :
		<%=a%>
	<p>
		b :
		<%=b%>
	<p>
		c :
		<%=c%>
	<p>
		r :
		<%=r.nextInt(123)%>
	<p>
</body>
</html>