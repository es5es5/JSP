<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�������� ������ �̵�</title>
</head>
<body>
	<%
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		
		
		
		// page2 -> page3 �ڵ��̵� �ø���
		// 1. redirect ��û���� ���� �׳� ��(���� �� ������ �� �� ����..)
		// response.sendRedirect("page3.jsp");
		
		// 2. forward (page1 -> page2���� ��û������ page3���� ������ �̵�)
		// RequestDispatcher rd = request.getRequestDispatcher("page3.jsp");
		// rd.forward(request, response);
		
		// 3. include (page2�ӿ� page3����) : ��ġ ���� �Ұ���, ���� �� ��..
		// RequestDispatcher rd = request.getRequestDispatcher("page3.jsp");
		// rd.include(request, response);
		
		
		// ��������� 2�� forward�� ���� ���� ��
		RequestDispatcher rd = request.getRequestDispatcher("page3.jsp");
		rd.forward(request, response);
	%>
	<h2>This is page2</h2>
	page1���� ������ ���
	<hr>
	<p>
		a=<%=a%>
	<p>
		b=<%=b%>
	<p>
</body>
</html>