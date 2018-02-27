<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css.css">

<%
	double input = Double.parseDouble(request.getParameter("input"));
	String convert = request.getParameter("convert");
	String inUnit = null;
	String outUnit = null;
	String theme =null;
	double result = 0;
	
	
	if (convert.equals("mmToCm")) {
		result = input / 10;
		inUnit = "mm";
		outUnit = "cm";
		theme = "red";
	} else if (convert.equals("cmToM")) {
		result = input * 100;
		inUnit = "cm";
		outUnit = "m";
		theme = "blue";
	} else if (convert.equals("mToKm")) {
		result = input * 100;
		inUnit = "m";
		outUnit = "km";
		theme = "green";
	} else if (convert.equals("mToInch")) {
		result = input * 39.370079;
		inUnit = "m";
		outUnit = "inch";
		theme = "yellow";
	}
%>
</head>
<body>
	<table id="table<%=theme %>">
		<tr>
			<td id="titleTd" align="center" valign="middle">결 과</td>
		</tr>
		<tr>
			<td class="resultTd" align="center" valign="middle"><%=input%><%=inUnit %></td>
		</tr>
		<tr>
			<td class="resultTd" align="center" valign="middle">↓</td>
		</tr>
		<tr>
			<td class="resultTd" align="center" valign="middle"><%=result%><%=outUnit %></td>
		</tr>
	</table>
</body>
</html>