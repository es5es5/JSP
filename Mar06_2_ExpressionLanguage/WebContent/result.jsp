<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
body {
	font-size: 25pt;
}
</style>
</head>
<body>
	<%
		// .jsp에 java를 쓰는 경우
		//		값 읽으려고
		
		//		출력형식
		//		for, if, ...
		
		// EL(Expression Language)
		//	java코드 아님
		//	값 읽을때 사용
		//	연산자 사용 가능
		//	형변환 자동
		//	import없어도 됨
		//	값 없으면 넘어감
		//	- parameter 읽기 : ${param.이름}
		//	- attribute 읽기
		//		String, int, ... 같은 기본형 : ${이름 }
		//		객체 : ${이름.멤버변수}
		//		기본형[] or ArrayList<기본형> : ${이름[번호]}
		//		객체[] or ArrayList<객체> : ${이름[번호].멤버변수 }
	%>
	이름 : ${param.n }<p>중간고사 : ${param.m }<p>기말고사 : ${param.f }<p>
	평균 : ${(param.m + param.f) / 2 }<p>
	a : ${a }<p>
	b : ${b }<p>
	평균 : ${s.avg }<p>
	${s.what } <p>
	${c[0] } ${c[1] } ${c[2] } ${c[3] }<p>
	${d[0].avg } ${d[0].what }<p>
	${d[1].avg } ${d[1].what }<p>
	${e[0].avg } ${e[0].what }<p>
	${e[1].avg } ${e[1].what }<p>
	${e[2].avg } ${e[2].what }<p>
	
</body>
</html>








