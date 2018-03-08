<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="index.css">
<title>Insert title here</title>
</head>
<body>
<body>
	<table>
		<tr>
			<td id="titleArea" align="center">Mar08_2_DB</td>
		</tr>
		<tr>
			<td id="menuArea"><a href="HomeController">홈</a> <a href="DBController">DB연결</a>
			</td>
		</tr>
		<tr>
			<td align="center" id="contentArea"><jsp:include
					page="${contentPage }"></jsp:include></td>
		</tr>
	</table>
</body>


</html>