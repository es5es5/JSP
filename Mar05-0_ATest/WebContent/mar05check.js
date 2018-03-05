function check() {
	var idField = document.myForm.id;
	var pwField = document.myForm.pw;
	var pw2Field = document.myForm.pw2;
	var ageField = document.myForm.age;
	var imgField = document.myForm.img;

	if (isEmpty(idField) || isLessThan(idField, 4) || hangul(idField)) {
		alert("ID �ٽ� �����ϼ���.\n" + "4~10����, �ѱ� �ȵ�.");
		idField.value = "";
		idField.focus();
		return false;
	} else if (isEmpty(pwField) || isLessThan(pwField, 4)
			|| notContains(pwField, "1234567890")
			|| notContains(pwField, "qwertyuiopasdfghjklzxcvbnm")
			|| notContains(pwField, "QWERTYUIOPASDFGHJKLZXCVBNM")
			|| notEquals(pwField, pw2Field)) {
		alert("PW �ٽ� �����ϼ���.\n" + "4~15����, ����, ��ҹ��� ����");

		pwField.value = "";
		pw2Field.value = "";
		pwField.focus();
		return false;
	} else if (isEmpty(ageField) || noNumber(field)) {
		alert("���� �ٽ� �����ϼ���.")
		ageField.value = "";
		ageField.focus();
		return false;
	} else if (isEmpty(imgField) || isNotType(field, "png")
			|| isNotType(field, "gif")
			|| isNotType(field, "jpg")
			) {
		alert("���� �ٽ� �����ϼ���.")
		imgField.value = "";
		imgField.focus();
		return false;
	}
	
	
	return true;
}