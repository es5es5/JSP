<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1" id="commentsArea">
		<tr>
			<td align="right">
				${r }
				<a href="CommentsWriteController" class="orangeA">[후기 남기기]</a>
			</td>
		</tr>
		<tr>
			<td id="commentsBBSArea">게시판 들어올 자리</td>
		</tr>
		<tr>
			<td>페이지 번호 들어올 자리</td>
		</tr>
		<tr>
			<td>검색 기능 들어올 자리</td>
		</tr>
	</table>
</body>
</html>