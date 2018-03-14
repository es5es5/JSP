<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table id="sbMenuArea">
		<tr>
			<td style="width: 10%;"></td>
			<td align="center">
				<form action="MenuRegController" method="post"
					enctype="multipart/form-data" name="mrForm"
					onsubmit="return mrCheck();">
					<table id="menuRegTbl">
						<tr>
							<td colspan="2" align="right">${r }</td>
						</tr>
						<tr>
							<td class="mrTd1">메뉴명</td>
							<td><input class="mrInput" name="sm_name"
								autofocus="autofocus" maxlength="20"></td>
						</tr>
						<tr>
							<td class="mrTd1">가격</td>
							<td><input class="mrInput" name="sm_price" maxlength="5"></td>
						</tr>
						<tr>
							<td class="mrTd1">사진</td>
							<td><input type="file" name="sm_img"></td>
						</tr>
						<tr>
							<td class="mrTd1">설명</td>
							<td><textarea class="mrTA" name="sm_desc" maxlength="150"></textarea></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input class="mrBtn"
								type="submit" value="등록"></td>
						</tr>
					</table>
				</form>
				<br>
			<hr>
				<br>
			</td>
			<td style="width: 10%;"></td>
		</tr>
		<tr>
			<td align="center"><c:if test="${curPageNo != 1 }">
					<a class="menuPageA" href="MenuPageController?p=${curPageNo - 1}">&lt;</a>
				</c:if></td>
			<td align="center"><c:forEach var="m" items="${menus }">
					<table class="menuItem">
						<tr>
							<td class="menuImgTd" rowspan="5" align="center"><img
								class="menuImg" src="img/${m.sm_img }"></td>
						</tr>
						<tr>
							<td class="menuNameTd" onclick="searchMenu('${m.sm_name}');">${m.sm_name }</td>
						</tr>
						<tr>
							<td align="right" style="font-weight: 800;"><fmt:formatNumber
									value="${m.sm_price }" type="currency"></fmt:formatNumber>&nbsp;
							</td>
						</tr>
						<tr>
							<td style="padding: 7px;">${m.sm_desc }</td>
						</tr>
						<tr>
							<td align="right">
								<button class="menuBtn"
									onclick="updateMenu('${m.sm_price}', ${m.sm_no });">수정</button>
								<button class="menuBtn" onclick="deleteMenu('${m.sm_no}')">삭제</button>
							</td>
						</tr>
					</table>
				</c:forEach></td>
			<td align="center"><c:if test="${curPageNo != pageCount }">
					<a class="menuPageA" href="MenuPageController?p=${curPageNo + 1}">&gt;</a>
				</c:if></td>
		</tr>
	</table>
</body>
</html>

