function check() {
	var idField = document.myForm.id;
	var pwField = document.myForm.pw;

	if (isEmpty(idField) || isLessThan(idField, 4) || hangul(idField)) {
		alert("ID �ٽ� �����ϼ���.");
		idField.value = "";
		idField.focus();
		return false;
	} else if (isEmpty(pwField) || isLessThan(pwField, 4) || notContains(pwField, "1234567890")) {
		alert("PW �ٽ� �����ϼ���.");
		pwField.value = "";
		pwField.focus();
		return false;
	}
	return true;
}