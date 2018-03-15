<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>사물인터넷기반 하이브리드 웹앱 개발자 양성 과정 카페</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/member.css">
<script type="text/javascript" src="js/validCheck.js"></script>
<script type="text/javascript" src="js/check.js"></script>
<script type="text/javascript" src="js/go.js"></script>
</head>
<body>
	<table id="siteTitleArea">
		<tr>
			<td align="center">
				<table id="siteTitleArea2">
					<tr>
						<td id="siteTitleTd"><a id="siteTitle" href="HomeController">사물인터넷기반 하이브리드
								웹앱 개발자 양성 과정 카페</a></td>
					</tr>
					<tr>
						<td id="siteMenuArea"><a href="" class="siteMenu">메뉴1</a> <a
							href="" class="siteMenu">메뉴2</a> <a href="" class="siteMenu">메뉴3</a>
						</td>
					</tr>
					<tr>
						<td align="right"><jsp:include page="${loginPage }"></jsp:include>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table id="siteContentArea">
		<tr>
			<td align="center">
				<table id="siteContentArea2">
					<tr>
						<td align="center"><jsp:include page="${contentPage }"></jsp:include>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>





