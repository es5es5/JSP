function check() {
	var idField = document.myForm.id;
	var pwField = document.myForm.pw;
	var pw2Field = document.myForm.pw2;
	var ageField = document.myForm.age;
	var imgField = document.myForm.img;

	if (isEmpty(idField) || isLessThan(idField, 4) || hangul(idField)) {
		alert("ID 다시 설정하세요.\n" + "4~10글자, 한글 안됨.");
		idField.value = "";
		idField.focus();
		return false;
	} else if (isEmpty(pwField) || isLessThan(pwField, 4)
			|| notContains(pwField, "1234567890")
			|| notContains(pwField, "qwertyuiopasdfghjklzxcvbnm")
			|| notContains(pwField, "QWERTYUIOPASDFGHJKLZXCVBNM")
			|| notEquals(pwField, pw2Field)) {
		alert("PW 다시 설정하세요.\n" + "4~15글자, 숫자, 대소문자 포함");

		pwField.value = "";
		pw2Field.value = "";
		pwField.focus();
		return false;
	} else if (isEmpty(ageField) || noNumber(field)) {
		alert("나이 다시 설정하세요.")
		ageField.value = "";
		ageField.focus();
		return false;
	} else if (isEmpty(imgField) || isNotType(field, "png")
			|| isNotType(field, "gif")
			|| isNotType(field, "jpg")
			) {
		alert("사진 다시 설정하세요.")
		imgField.value = "";
		imgField.focus();
		return false;
	}
	
	
	return true;
}