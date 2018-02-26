<!-- 톰캣이 서블릿으로 바꿀 때 필요한 정보들 -->

<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<%!// 멤버변수 or 메소드 만들 때 사용
	public int add(int i, int j) {
		return i + j;
	}%>
<body>
	<%
		// 일반적인 코드
		System.out.println("안녕");
		int i = 10;
		int j = 20;
		int k = add(i, j);
	%>
	<marquee>
		<h2>
			룰루 <%=i%> +<%=j%> = <%=k %> 
		</h2>
	</marquee>
</body>
</html>