<%@page import="java.net.URLEncoder"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="css.css">
<title>Insert title here</title>
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

		double bmi = 0;

		String name = mr.getParameter("name");
		double height = Double.parseDouble(mr.getParameter("height"));
		double weight = Double.parseDouble(mr.getParameter("weight"));
		height = height / 100;
		bmi = weight / (height * height);
		String bmiFormat = String.format("%.3f", bmi);
		String result = null;

		if (bmi >= 35) {
			result = "고도비만";
		} else if (bmi < 35) {
			result = "중등도비만";
		} else if (bmi < 30) {
			result = "경도비만";
		} else if (bmi < 25) {
			result = "과체중";
		} else if (bmi < 23) {
			result = "정상";
		} else if (bmi < 18.5) {
			result = "저체중";
		}
	%>

	<table id="outerTable">
		<tr>
			<td id="titleTd">결과</td>
		</tr>
		<tr>
			<td><img src="img/<%=fileName%>"></td>
		</tr>
		<tr>
			<td class="td1">이름</td>
			<td><%=name%></td>
		</tr>
		<tr>
			<td class="td1">키</td>
			<td><%=height%></td>
		</tr>
		<tr>
			<td class="td1">몸무게</td>
			<td><%=weight%></td>
		</tr>
		<tr>
			<td class="td1">BMI</td>
			<td><%=bmiFormat%></td>
		</tr>
		<tr>
			<td class="td1">결과</td>
			<td><%=result%></td>
		</tr>


	</table>
</body>
</html>