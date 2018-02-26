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
		request.setCharacterEncoding("euc-kr");
		String aa = request.getParameter("a");
		String bb = request.getParameter("b");
		bb = bb.replace("\n", "<br>"); // textarea에서 엔터 친거는 \n
		String cc = request.getParameter("c");
		String dd = request.getParameter("d");
		String ee = request.getParameter("e");
		String[] ff = request.getParameterValues("f");
	%>
	text :<%=aa%>
	<p>
		textarea :<%=bb%>
	<p>
		password :<%=cc%>
	<p>
		radio:<%=dd%>
	<p>
		select:<%=ee%>
	<p>
		checkbox :
		<%
			if (ff != null) {
				for (String s : ff) {
					out.print(s + " ");
				}
			}
		%>
	
	<p>
</body>
</html>