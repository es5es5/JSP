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
			<td id="titleTd" colspan="2" align="center" valign="middle">����
				��û</td>
		</tr>
		<tr>
			<td class="td1">�̸�</td>
			<td><%=request.getParameter("name")%></td>
		</tr>
		<tr>
			<td class="td1">����</td>
			<td><%=request.getParameter("age")%></td>
		</tr>
		<tr>
			<td class="td1">����</td>
			<td><%=request.getParameter("sex")%></td>
		<tr>
			<td class="td1">�����</td>
			<td><%=request.getParameter("test")%></td>
		</tr>
	</table>
</body>
</html>