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
<link rel="stylesheet" href="css.css">
</head>
<body>
	<%
		String path = request.getServletContext().getRealPath("img");
		System.out.println(path);

		MultipartRequest mr = new MultipartRequest(request, path, 100 * 1024 * 1024, "euc-kr",
				new DefaultFileRenamePolicy());

		String fileName = mr.getFilesystemName("img");
		fileName = URLEncoder.encode(fileName, "euc-kr");
		fileName = fileName.replace("+", " ");
	%>
	<table>
		<tr>
			<td id="titleTd" colspan="2" align="center" valign="middle">시험
				신청</td>
		</tr>
		<tr>
			<td class="td1">사진</td>
			<td><img src="img/<%=fileName%>"></td>
		</tr>
		<tr>
			<td class="td1">이름</td>
			<td><%=mr.getParameter("name")%></td>
		</tr>
		<tr>
			<td class="td1">나이</td>
			<td><%=mr.getParameter("age")%></td>
		</tr>
		<tr>
			<td class="td1">성별</td>
			<td><%=mr.getParameter("sex")%></td>
		<tr>
			<td class="td1">시험명</td>
			<td><%=mr.getParameter("test")%></td>
		</tr>
	</table>
</body>
</html>