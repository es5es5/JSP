<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Mar08_1_CustomTag</title>
<link rel="stylesheet" href="NewFile.css">
</head>
<body>
	<%
		// .jsp에서 자바를 왜 썼나

		//		값 읽기 : EL
		//		
		//		화면 이동(redirect, forward, include)
		//		제어문(for, if)
		//		출력형식(소수점, 날짜, ...)

		// CustomTag : .jsp에서만 사용가능한 태그(DOM객체)
		//		형태는 DOM객체 Tomcat이 자바코드로 바꿔서 실행
		//		<접두어:태그명>

		//		JSP표준액션태그 : .jsp환경에서 기본적으로 사용 가능
		//				<jsp:???>

		//		외부CustomTag : .jar파일 프로젝트에 넣어야 사용 가능
		//				<???:???>

		//request.getRequestDispatcher("NewFile.jsp").forward(request, response);
	%>
	<table>
		<tr>
			<td id="siteTitle">Mar08-1_CustomTag</td>
		</tr>
		<tr>
			<td id="siteMenu">
			<a href="HomeController">Home</a>
			<a href="AController">AA</a>
			<a href="BController">B</a>
			<a href="JSTLController">JSTL-core</a>
			</td>
		</tr>
		<tr>
			<td id="contentArea" align="center">
			<jsp:include page="${contentPage }"></jsp:include></td>
		</tr>
	</table>
</body>
</html>













