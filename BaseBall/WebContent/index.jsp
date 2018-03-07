<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/validCheck.js"></script>
<script type="text/javascript" src="js/check.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form name="f" action="HC" onsubmit="return check();">
		<table>
			<tr>
				<td align="center" class="titleTd">BaseBall</td>
			</tr>
			<tr>
				<td class="judge">S : ${s }${notice }</td>
			</tr>
			<tr>
				<td class="judge">B : ${b }</td>
			</tr>
			<tr>
				<td align="center" class="td2"><input name="b" id="i"
					placeholder="${param.b }" maxlength="3" autofocus="autofocus"></td>
			</tr>
			<tr>
				<td align="center" class="td2"><input type="submit" value="던져"
					id="btn"></td>
			</tr>
		</table>
	</form>
</body>
</html>