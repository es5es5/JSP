<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table id="loginOKTbl">
		<tr>
			<td rowspan="2" id="loginOKImgTd" align="center"><img id="loginOKImg"
				src="etc/${sessionScope.loginMember.im_img }"></td>
			<td id="loginOKID">${sessionScope.loginMember.im_id }</td>
		</tr>
		<tr>
			<td align="right" id="loginOKName">
			${sessionScope.loginMember.im_name }<span id="loginOKHello">�� �ȳ�</span>&nbsp;&nbsp;
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button class="loginOKBtn" onclick="logout();">�α׾ƿ�</button>&nbsp;
				<button class="loginOKBtn">��������</button>&nbsp;
				<button class="loginOKBtn">Ż��</button>
			</td>
		</tr>
	</table>
</body>
</html>