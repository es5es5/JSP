<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="css.css">
<script type="text/javascript" src="js/rsp.js"></script>
<title>가위바위보 게임</title>
</head>
<body>
	<form action="HomeController" name="rsp" method="post">
		<table>
			<tr>
				<td id="titleTd" colspan="3" align="center">가위바위보 게임</td>
			</tr>
			<tr>
				<td align="center"><img id="rspImg" onclick="go(1);"
					src="img/r.png"></td>
				<td align="center"><img id="rspImg" onclick="go(2);"
					src="img/s.png"></td>
				<td align="center"><img id="rspImg" onclick="go(3);"
					src="img/p.png"></td>
			</tr>
			<tr>
				<td id="resultTd" colspan="3" align="center">결 과</td>
			<tr>
			<tr>
				<td align="center"><img src="${myHand}"></td>
				<td align="center"><img src="img/vs.png"></td>
				<td align="center"><img src="${comHand}"></td>
			</tr>
			<tr>
				<td align="center" colspan="3">${result }</td>
			</tr>
		</table>
	</form>

</body>
</html>