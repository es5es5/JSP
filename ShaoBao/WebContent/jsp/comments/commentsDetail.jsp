<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<table id="cdTable">
	<form action="CommentsUpdateController" 
	name="cmtWriteForm" onsubmit="return cmtCheck();">
			<tr>
				<td class="cdTd1">번호</td>
				<td class="cdTd2">
					<input name="sc_no" readonly="readonly"
					value="${c.sc_no }" class="cdI">
				</td>
			</tr>
			<tr>
				<td class="cdTd1">제목</td>
				<td class="cdTd2">
					<input name="title" value="${c.sc_title }"
					class="cdI">
				</td>
			</tr>
			<tr>
				<td class="cdTd1">내용</td>
				<td class="cdTd2"><textarea class="cdTA" name="txt">${c.sc_txt }</textarea>
				</td>
			</tr>
			<tr>
				<td class="cdTd1">작성일</td>
				<td class="cdTd2"><fmt:formatDate value="${c.sc_date }"
						type="both" dateStyle="long" timeStyle="long" /></td>
			</tr>
			<tr>
				<td class="cdTd3" colspan="2" align="right">${r }
					<input type="submit" value="수정" class="cdBtn">&nbsp;
	</form>
					<button onclick="delCmtCheck(${c.sc_no});" class="cdBtn">삭제</button>
				</td>
			</tr>
		</table>
</body>
</html>









