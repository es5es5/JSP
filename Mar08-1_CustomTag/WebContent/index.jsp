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
		// .jsp���� �ڹٸ� �� �質

		//		�� �б� : EL
		//		
		//		ȭ�� �̵�(redirect, forward, include)
		//		���(for, if)
		//		�������(�Ҽ���, ��¥, ...)

		// CustomTag : .jsp������ ��밡���� �±�(DOM��ü)
		//		���´� DOM��ü Tomcat�� �ڹ��ڵ�� �ٲ㼭 ����
		//		<���ξ�:�±׸�>

		//		JSPǥ�ؾ׼��±� : .jspȯ�濡�� �⺻������ ��� ����
		//				<jsp:???>

		//		�ܺ�CustomTag : .jar���� ������Ʈ�� �־�� ��� ����
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













