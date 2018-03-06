<%@page import="com.kwon.biman2.main.Result"%>
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
		Result asd = (Result) request.getAttribute("rrrrr");
	%>
	이름 : <%=request.getParameter("n")%><p>
	키 : <%=request.getParameter("h")%>cm<p>
	몸무게 : <%=request.getParameter("w")%>kg<p>
	bmi : <%=String.format("%.2f", asd.getBmi()) %><p>
	<%
		if(asd.getResult().contains("비만")){
	%>
			<h1><%=asd.getResult() %></h1>
	<%
		}else{
	%>
			<%=asd.getResult() %>
	<%
		}
	%>
	
	
</body>
</html>









