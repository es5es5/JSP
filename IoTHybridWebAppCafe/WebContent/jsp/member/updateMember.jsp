<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 정보 수정</title>
</head>
<body>
	<h2>회원 정보 수정</h2>
	<br>
	<br>
	<br>
	<form action="MemberUpdateController" name="updateForm"
		onsubmit="return updateCheck();" method="post"
		enctype="multipart/form-data">
		<table id="joinTbl">
			<tr>
				<td colspan="2" class="joinTblBlank"></td>
			</tr>
			<tr>
				<td class="joinTblTd1">id</td>
				<td><input name="im_id" readonly="readonly" maxlength="10"
					autofocus="autofocus" class="joinInput" autocomplete="off"
					value="${sessionScope.loginMember.im_id }"></td>
			</tr>
			<tr>
				<td class="joinTblTd1">pw</td>
				<td><input name="im_pw" maxlength="10" class="joinInput"
					type="password" value="${sessionScope.loginMember.im_pw }"></td>
			</tr>
			<tr>
				<td class="joinTblTd1">pw확인</td>
				<td><input name="im_pwChk" maxlength="10" class="joinInput"
					type="password" value="${sessionScope.loginMember.im_pw }"></td>
			</tr>
			<tr>
				<td class="joinTblTd1">이름</td>
				<td><input name="im_name" maxlength="10" class="joinInput"
					value="${sessionScope.loginMember.im_name }"></td>
			</tr>
			<tr>
				<td class="joinTblTd1">거주지</td>
				<td><input name="im_addr" maxlength="10" class="joinInput"
					value="${sessionScope.loginMember.im_addr }"></td>
			</tr>
			<tr>
				<td class="joinTblTd1">생일</td>
				<td><select name="im_y" class="joinSelect">
						<option>
							<fmt:formatDate pattern="yyyy"
								value="${sessionScope.loginMember.im_birthday }" />
						</option>
						<c:forEach var="y" begin="${curYear - 50 }" end="${curYear }">
							<option>${y }</option>
						</c:forEach>
				</select>년&nbsp;&nbsp; <select name="im_m" class="joinSelect">
						<option>
							<fmt:formatDate pattern="M"
								value="${sessionScope.loginMember.im_birthday }" />
						</option>
						<c:forEach var="m" begin="1" end="12">
							<option>${m }</option>
						</c:forEach>
				</select>월&nbsp;&nbsp; <select name="im_d" class="joinSelect">
						<option>
							<fmt:formatDate pattern="d"
								value="${sessionScope.loginMember.im_birthday }" />
						</option>
						<c:forEach var="d" begin="1" end="31">
							<option>${d }</option>
						</c:forEach>
				</select>일</td>
			</tr>
			<tr>
				<td class="joinTblTd1">사진</td>
				<td><img src="etc/${sessionScope.loginMember.im_img }"> <input
					name="im_img" type="file"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input id="joinBtn"
					type="submit" value="수정"></td>
			</tr>
			<tr>
				<td colspan="2" class="joinTblBlank"></td>
			</tr>
		</table>
	</form>
</body>
</html>