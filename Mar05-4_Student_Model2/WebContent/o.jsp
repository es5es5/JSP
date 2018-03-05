<%@page import="com.lhw.s.main.Student"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="c2.css">
</head>
<body>
	<%
		Student s = (Student) request.getAttribute("ss");
	%>
	<table>
		<tr>
			<td id="titleTd" align="center">학생증</td>
		</tr>
		<tr>
			<td align="center"><img src="img/<%=s.getImg()%>"></td>
		</tr>
		<tr>
			<td align="center" class="td1"><%=s.getName()%></td>
		</tr>
		<tr>
			<td class="td1">학번 : <%=s.getNo()%></td>
		</tr>
		<tr>
			<td class="td1">주민등록번호 : <%=s.getJ1()%> - <%=s.getJ2()%></td>
		</tr>
		<tr>
			<td class="td1"><%=s.getAddr()%></td>
		</tr>
	</table>
</body>
</html>