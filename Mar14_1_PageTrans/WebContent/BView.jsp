<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function go(bh, yu){
		location.href = "CController?aa="+bh+"&bb="+yu;
	}	
</script>
</head>
<body>
	<h1>BView</h1>
	<a href="CController?aa=test&bb=33">GET规侥 夸没</a> <p>
	
	<hr>
	
	<button onclick="go('せせ', 11);">GET规侥 夸没</button> <p>
	
	<hr>
	
	<form action="CController">
		<input name="aa"> <br>
		<input name="bb"> <br>
		<input type="submit" value="GET规侥 夸没">
	</form>
	
</body>
</html>







