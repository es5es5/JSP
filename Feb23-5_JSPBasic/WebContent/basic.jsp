<!-- ��Ĺ�� �������� �ٲ� �� �ʿ��� ������ -->

<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<%!// ������� or �޼ҵ� ���� �� ���
	public int add(int i, int j) {
		return i + j;
	}%>
<body>
	<%
		// �Ϲ����� �ڵ�
		System.out.println("�ȳ�");
		int i = 10;
		int j = 20;
		int k = add(i, j);
	%>
	<marquee>
		<h2>
			��� <%=i%> +<%=j%> = <%=k %> 
		</h2>
	</marquee>
</body>
</html>