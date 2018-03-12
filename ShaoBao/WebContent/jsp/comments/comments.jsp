<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body> 
	<table id="commentsArea">
		<tr>
			<td align="right">${r }&nbsp; <a href="CommentsWriteController"
				class="orangeA">[후기 남기기]</a>
			</td>
		</tr>
		<tr>
			<td id="commentsBBSArea" align="center">
				<table id="commentsTable">
					<tr>
						<td>제목</td>
						<td style="width: 190px; height: 40px;">작성일</td>
					</tr>
					<c:forEach var="c" items="${comments }">
						<tr class="commentsTableData">
							<td>${c.sc_title }</td>
							<td>
								<fmt:formatDate value="${c.sc_date }" 
								type="both" 
								dateStyle="short" timeStyle="short"/>
							</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center">
				<c:forEach var="p" begin="1" end="${pageCount }">
					&nbsp;<a href="CommentsPageController?p=${p }" class="pageA">${p }</a>&nbsp;
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td align="center">
				<form action="CommentsSearchController" name="searchForm" onsubmit="return searchCmtCheck();">
					<input id="searchCmtInput" name="s">
					<input id="searchBtn" type="submit" value="검색">
				</form>
			</td>
		</tr>
	</table>
</body>
</html>











