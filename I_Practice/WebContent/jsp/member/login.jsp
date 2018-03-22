<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table id="loginTable">
		<form action="MemberLoginController" method="post" name="loginForm"
			onsubmit="">
			<tr>
				<td class="loginTd1" align="center">id</td>
				<td><input type="text" name="m_id" placeholder="ID 입력"
					class="loginInput"></td>
			</tr>
			<tr>
				<td class="loginTd1" align="center">pw</td>
				<td><input type="password" name="m_pw" class="loginInput">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="로그인">
					<button onclick="goJoin();" class="loginInput">회원가입</button></td>
			</tr>
		</form>
	</table>
</body>
</html>