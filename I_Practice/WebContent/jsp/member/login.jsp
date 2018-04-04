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
		<form action="MemberLoginController" method="post" name="loginForm">
			<tr>
				<td>
					<table>
						<tr>
							<td class="loginTd1" align="center">id</td>
							<td><input type="text" name="m_id" placeholder="ID 입력"
								class="loginInput"></td>
							<td>
							<td colspan="2" align="center"><input type="submit"
								value="로그인"></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table>
						<tr>
							<td class="loginTd1" align="center">pw</td>
							<td><input type="password" name="m_pw" class="loginInput"></td>
							</form>
							<td><button onclick="goJoin();" class="loginInput">회원가입</button></td>
						</tr>
					</table>
				</td>
			<tr>
				<td colspan="2"><input type="checkbox" name="m_autologin">로그인
					상태 유지</td>
			</tr>
			</tr>
	</table>

</body>
</html>