<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		// mvnrepository.com (jar 많은 곳)

		// JSTL
		// Jsp Standard Tag Library
		//		JSTL-core : for, if, ...
		//		JSTL-formatting : 출력 형식
		//		JSTL-function : 문자열 관련 메소드
		//		JSTL-...
	%>

	${param.x}*${param.x} = ${z }
	<c:if test="${z%2==0 }">
		<h1>짝수</h1>
	</c:if>
	<c:choose>
		<c:when test="${z>100 }">
			<h2>100보다 크다</h2>
		</c:when>
		<c:when test="${z>=80 }">
			<h2>80보다 크다</h2>
		</c:when>
		<c:otherwise>
			<h2>해당사항 없음</h2>
		</c:otherwise>
	</c:choose>

	<c:forEach var="i" begin="45" end="100" step="5">
	${i }<br>
	</c:forEach>

	<c:forEach var="d" items="${dogs }">
	${d.name } ${d.age } <br>
	</c:forEach>

	<hr>
	<fmt:formatNumber value="${z }" type="number"></fmt:formatNumber>
	<p>
		<fmt:formatNumber value="${z }" type="currency"></fmt:formatNumber>
	<p>
		<fmt:formatNumber value="${d }" pattern="#.000"></fmt:formatNumber>
	<p>
		<fmt:formatNumber value="${d }" type="percent"></fmt:formatNumber>
	<p>

		<fmt:formatDate value="${now }" dateStyle="long" />
	<p>
		<fmt:formatDate value="${now }" type="time" timeStyle="short" />
	<p>
		<fmt:formatDate value="${now }" type="both" dateStyle="long"
			timeStyle="short" />
	<p>
		<fmt:formatDate value="${now }" pattern="yyyy" />
	<p>
	<hr>

	${fn:indexOf(str, "하") }
	<br> ${fn:contains(str,"쇼") }
</body>
</html>