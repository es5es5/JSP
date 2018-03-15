function joinCheck() {
	var idField = document.joinForm.im_id;
	var pwField = document.joinForm.im_pw;
	var pwChkField = document.joinForm.im_pwChk;
	var nameField = document.joinForm.im_name;
	var addrField = document.joinForm.im_addr;
	var imgField = document.joinForm.im_img;

	if (isEmpty(idField) || containsHangul(idField)) {
		alert("id Ȯ��");
		idField.value = "";
		idField.focus();
		return false;
	} else if (isEmpty(pwField) || notEquals(pwField, pwChkField)
			|| lessThan(pwField, 4) || notContains(pwField, "1234567890")
			|| notContains(pwField, "qwertyuiopasdfghjklzxcvbnm")
			|| notContains(pwField, "QWERTYUIOPASDFGHJKLZXCVBNM")) {
		alert("pw Ȯ��");
		pwField.value = "";
		pwChkField.value = "";
		pwField.focus();
		return false;
	} else if (isEmpty(nameField)) {
		alert("�̸� Ȯ��");
		nameField.value = "";
		nameField.focus();
		return false;
	} else if (isEmpty(addrField)) {
		alert("������ Ȯ��");
		addrField.value = "";
		addrField.focus();
		return false;
	} else if (isEmpty(imgField)
			|| (isNotType(imgField, ".png") && isNotType(imgField, ".gif") && isNotType(
					imgField, ".jpg"))) {
		alert("���� �ȹٷ�");
		imgField.value = "";
		imgField.focus();
		return false;
	}
	return true;
}
function loginCheck() {
	var idField = document.loginForm.im_id;
	var pwField = document.loginForm.im_pw;

	if (isEmpty(idField)) {
		alert("id Ȯ��");
		idField.value = "";
		idField.focus();
		return false;
	} else if (isEmpty(pwField)) {
		alert("pw Ȯ��");
		pwField.value = "";
		pwField.focus();
		return false;
	}
	return true;
}