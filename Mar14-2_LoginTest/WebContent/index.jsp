<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Mar14-2_LoginSystem</td>
		</tr>
		<tr>
			<td><jsp:include page="${loginPage }"></jsp:include></td>
		</tr>
		<tr>
			<td><a href="HomeController">홈</a>&nbsp;&nbsp; <a
				href="M1Controller">메뉴1</a>&nbsp;&nbsp; <a href="M2Controller">메뉴2</a>
			</td>
		</tr>
		<tr>
			<td><jsp:include page="${contentPage }"></jsp:include></td>
		</tr>
	</table>

</body>
</html>