<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="css/index.css">
<title>멍멍이랑 냥냥이</title>
</head>
<body>
	<table id="indexTitleArea">
		<tr>
			<td align="center">
				<table id="indexTitleArea2">
					<tr>
						<td id="indexTitleTd"><a id="indexTitle"
							href="HomeController">여기에 HOME 버튼</a></td>
					</tr>
					<tr>
						<td id="indexMenuArea"><a href="" class="">메뉴1</a> <a href=""
							class="">메뉴2</a> <a href="" class="">메뉴3</a></td>
					</tr>
					<tr>
						<td align="right"><jsp:include page="${loginPage}"></jsp:include>
							</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table id="indexContentArea">
		<tr>
			<td align="center">
				<table id="indexContentArea2">
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