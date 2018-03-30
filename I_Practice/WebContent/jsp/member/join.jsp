<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="MemberJoinController" method="post" name="joinForm">
		<table id="joinTbl">
			<tr>
				<td>id</td>
				<td><input name="m_id"></td>
			</tr>
			<tr>
				<td>pw</td>
				<td><input name="m_pw" type="password"></td>
			</tr>
			<tr>
				<td>pw확인</td>
				<td><input name="m_pw2" type="password"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input name="m_name"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input name="m_adress"></td>
			</tr>
			<tr>
				<td>생일</td>
				<td>
				<select name="m_y">
				<c:forEach var="y" begin="1900" end="2018">
					<option>${y }</option>
				</c:forEach>
				</select>년&nbsp;&nbsp;
				
				<select name="m_m">
				<c:forEach var="m" begin="1" end="12">
					<option>${m }</option>
				</c:forEach>
				</select>월&nbsp;&nbsp;
				
				<select name="m_d">
				<c:forEach var="d" begin="1" end="31">
					<option>${d }</option>
				</c:forEach>
				</select>일
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="가입"></td>
			</tr>
		</table>
	</form>
	<h2>회원가입</h2>
</body>
</html>