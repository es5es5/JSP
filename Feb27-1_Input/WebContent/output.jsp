<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css.css">
</head>
<body>
	<table>
		<tr>
			<td id="titleTd" colspan="2" align="center" valign="middle">시험
				신청</td>
		</tr>
		<tr>
			<td class="td1">이름</td>
			<td><%=request.getParameter("name")%></td>
		</tr>
		<tr>
			<td class="td1">나이</td>
			<td><%=request.getParameter("age")%></td>
		</tr>
		<tr>
			<td class="td1">성별</td>
			<td><%=request.getParameter("sex")%></td>
		<tr>
			<td class="td1">시험명</td>
			<td><%=request.getParameter("test")%></td>
		</tr>
	</table>
</body>
</html>