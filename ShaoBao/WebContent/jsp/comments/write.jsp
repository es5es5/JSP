<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="CommentsWriteController" method="post"
		name="cmtWriteForm" onsubmit="return cmtCheck();">
		<table id="commentsWriteTable">
			<tr>
				<td id="cwtTitle" colspan="2" align="center">�ı���</td>
			</tr>
			<tr>
				<td class="cwtTd1">����</td>
				<td><input name="title" class="cwtInput" autofocus="autofocus"
					placeholder="�ʼ�, �ִ� 50����" maxlength="50"></td>
			</tr>
			<tr>
				<td class="cwtTd1">����</td>
				<td><textarea name="txt" class="cwtTA"
						placeholder="�ʼ�, �ִ� 200����" maxlength="200"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center" style="height: 50px;"><input
					type="submit" value="���" class="cwtBtn"></td>
			</tr>
		</table>
	</form>
</body>
</html>