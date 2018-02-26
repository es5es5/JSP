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
		int dan = Integer.parseInt(request.getParameter("dan"));
	%>
	<table>
		<tr>
			<td align="center" id="titleTd2"><%=dan%>단</td>
		</tr>
		<%
			String t = null;
			for (int i = 1; i <= 9; i++) {
				t = String.format("<tr><td class='xy3'>%d x %d = %d </td></tr>", dan, i, dan * i);
				out.print(t);
			}
		%>
	</table>
</body>
</html>