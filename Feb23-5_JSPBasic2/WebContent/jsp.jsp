<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	// 파라미터 읽기 전에
	request.setCharacterEncoding("euc-kr");

	String say = request.getParameter("say");
	int loop = Integer.parseInt(request.getParameter("loop"));
	String color = request.getParameter("color");
	String size = request.getParameter("size");
%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<style type="text/css">
body {
	font-size: <%=size%>pt;
	color: <%=color%>;
}
</style>
</head>
<body>
	<%
		for (int i = 0; i < loop; i++) {
	%>
	<%=say%><br>
	<%
		}
	%>
</body>
</html>