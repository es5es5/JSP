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
		// .jsp�� java�� ���� ���
		//		�� ��������
		
		//		�������
		//		for, if, ...
		
		// EL(Expression Language)
		//	java�ڵ� �ƴ�
		//	�� ������ ���
		//	������ ��� ����
		//	����ȯ �ڵ�
		//	import��� ��
		//	�� ������ �Ѿ
		//	- parameter �б� : ${param.�̸�}
		//	- attribute �б�
		//		String, int, ... ���� �⺻�� : ${�̸� }
		//		��ü : ${�̸�.�������}
		//		�⺻��[] or ArrayList<�⺻��> : ${�̸�[��ȣ]}
		//		��ü[] or ArrayList<��ü> : ${�̸�[��ȣ].������� }
	%>
	�̸� : ${param.n }<p>�߰���� : ${param.m }<p>�⸻��� : ${param.f }<p>
	��� : ${(param.m + param.f) / 2 }<p>
	a : ${a }<p>
	b : ${b }<p>
	��� : ${s.avg }<p>
	${s.what } <p>
	${c[0] } ${c[1] } ${c[2] } ${c[3] }<p>
	${d[0].avg } ${d[0].what }<p>
	${d[1].avg } ${d[1].what }<p>
	${e[0].avg } ${e[0].what }<p>
	${e[1].avg } ${e[1].what }<p>
	${e[2].avg } ${e[2].what }<p>
	
</body>
</html>








