<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>샤오바오우육면</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/comments.css">
<link rel="stylesheet" href="css/menu.css">
<script type="text/javascript" src="js/validCheck.js"></script>
<script type="text/javascript" src="js/commentCheck.js"></script>
<script type="text/javascript" src="js/mrCheck.js"></script>
</head>
<body>
	<table id="menuArea">
		<tr>
			<td align="center">
				<table id="menuArea2">
					<tr>
						<td align="center" style="width:25%;">
							<a class="siteMenu" href="">?</a>
						</td>
						<td align="center" style="width:25%;">
							<a class="siteMenu" href="MenuController">메뉴</a>
						</td>
						<td align="center" style="width:25%;">
							<a class="siteMenu" href="">?</a>
						</td>
						<td align="center" style="width:25%;">
							<a class="siteMenu" href="CommentsController">후기</a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table id="site">
		<tr>
			<td align="center" id="siteTitle">
				<a href="HomeController" style="color:black;">
					샤오바오우육면
				</a>
			</td>
		</tr>
		<tr>
			<td align="center" id="siteContent">
				<jsp:include page="${contentPage }"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>



