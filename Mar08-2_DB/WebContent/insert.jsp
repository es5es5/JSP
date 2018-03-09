<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="insert.css">
<title>Insert title here</title>
</head>
<body>
	<form action="IController">
		<p>
			이름 : <input type="text" name="name">
		<p>
			나이 : <input type="text" name="age">
		<p>
			<input type="submit" value="등록">
		<p>
	</form>
	${r }
</body>
</html>