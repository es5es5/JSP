<%@page import="java.net.URLEncoder"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		// 1. cos.jar ������Ʈ�� �ְ�
		// 2. ������ ���ε�� ���� Ȯ��
		// 3. html�� ���� form����

		// ������ ���ε� �� ���� ��ü ���
		String path = request.getServletContext().getRealPath("file");
		System.out.println(path);
		MultipartRequest mr = new MultipartRequest(request, path, 10485760, // ������ byte (���� 10485760 = 10*1024*1024 = 100MB)
				"euc-kr", // POST ����� �ѱ� ó��
				new DefaultFileRenamePolicy() // ���ϸ� �ߺ� ó�� (�̸�1, �̸�2, �̸�3 ...)
		);

		String input = mr.getParameter("input");

		// ���ε� �� ���ϸ�
		 String fileName = mr.getFilesystemName("img");

		// Tomcat�� �ѱ� ���ϸ� �ν� �� ��
		// �� => %2d(URLEncoding) �̷������� �ٲٸ� �ν� ����
		fileName = (URLEncoder.encode(fileName, "euc-kr"));

		// ����� ���ڵ��ϸ� '+'�ε�.. �װ� �� �׷�
		fileName = fileName.replace("+", " ");

		// ���� ���ε帶�� ���� 3�� �� ����� �߰�
		String fileName2 = mr.getFilesystemName("etc");
		fileName2 = (URLEncoder.encode(fileName2, "euc-kr"));
		fileName2 = fileName2.replace("+", " ");
	%>

	<%=input%>
	<img src="file/<%=fileName%>">
	<p>
		<a href="file/<%=fileName2%>">����</a>

		<%=fileName%>
</body>
</html>