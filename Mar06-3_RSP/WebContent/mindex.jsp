<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="js/mrsp.js"></script>
<link rel="stylesheet" href="mcss.css">
<!-- ����� ����ȭ -->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scaLable=no">
<title>���������� ����</title>
</head>
<body>
	<form action="MobileHomeController" name="rsp" method="post">
		<table>
			<tr>
				<td id="titleTd" colspan="3" align="center">���������� ����</td>
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
				<td id="resultTd" colspan="3" align="center">�� ��</td>
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