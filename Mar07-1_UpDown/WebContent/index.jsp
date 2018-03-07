<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="css/css.css">
<title>Insert title here</title>
</head>
<body>
	<form action="HomeController" method="GET" onsubmit="return check();">
		<table>
			<tr>
				<td id="titleTd" align="center">UpDown</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td align="center">뭐 : <input id="i" name="n"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td align="center"><input id="b" type="submit" value="확인"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td id="r">${r } ${notice}</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
		</table>
	</form>
</body>
</html>