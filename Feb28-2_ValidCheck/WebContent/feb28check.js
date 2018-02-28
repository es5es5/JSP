function check() {
	var idField = document.myForm.id;
	var pwField = document.myForm.pw;

	if (isEmpty(idField) || isLessThan(idField, 4) || hangul(idField)) {
		alert("ID 다시 설정하세요.");
		idField.value = "";
		idField.focus();
		return false;
	} else if (isEmpty(pwField) || isLessThan(pwField, 4) || notContains(pwField, "1234567890")) {
		alert("PW 다시 설정하세요.");
		pwField.value = "";
		pwField.focus();
		return false;
	}
	return true;
}