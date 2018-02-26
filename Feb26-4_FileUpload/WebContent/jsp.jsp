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
		// 1. cos.jar 프로젝트에 넣고
		// 2. 파일이 업로드될 폴더 확보
		// 3. html에 가서 form수정

		// 파일이 업로드 될 폴더 전체 경로
		String path = request.getServletContext().getRealPath("file");
		System.out.println(path);
		MultipartRequest mr = new MultipartRequest(request, path, 10485760, // 단위는 byte (현재 10485760 = 10*1024*1024 = 100MB)
				"euc-kr", // POST 방식의 한글 처리
				new DefaultFileRenamePolicy() // 파일명 중복 처리 (이름1, 이름2, 이름3 ...)
		);

		String input = mr.getParameter("input");

		// 업로드 한 파일명
		 String fileName = mr.getFilesystemName("img");

		// Tomcat은 한글 파일명 인식 못 함
		// ㅋ => %2d(URLEncoding) 이런식으로 바꾸면 인식 가능
		fileName = (URLEncoder.encode(fileName, "euc-kr"));

		// 띄어쓰기는 인코딩하면 '+'인데.. 그건 좀 그럼
		fileName = fileName.replace("+", " ");

		// 파일 업로드마다 위에 3줄 한 덩어리씩 추가
		String fileName2 = mr.getFilesystemName("etc");
		fileName2 = (URLEncoder.encode(fileName2, "euc-kr"));
		fileName2 = fileName2.replace("+", " ");
	%>

	<%=input%>
	<img src="file/<%=fileName%>">
	<p>
		<a href="file/<%=fileName2%>">열기</a>

		<%=fileName%>
</body>
</html>