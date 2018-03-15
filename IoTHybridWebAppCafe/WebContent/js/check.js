function joinCheck() {
	var idField = document.joinForm.im_id;
	var pwField = document.joinForm.im_pw;
	var pwChkField = document.joinForm.im_pwChk;
	var nameField = document.joinForm.im_name;
	var addrField = document.joinForm.im_addr;
	var imgField = document.joinForm.im_img;

	if (isEmpty(idField) || containsHangul(idField)) {
		alert("id 확인");
		idField.value = "";
		idField.focus();
		return false;
	} else if (isEmpty(pwField) || notEquals(pwField, pwChkField)
			|| lessThan(pwField, 4) || notContains(pwField, "1234567890")
			|| notContains(pwField, "qwertyuiopasdfghjklzxcvbnm")
			|| notContains(pwField, "QWERTYUIOPASDFGHJKLZXCVBNM")) {
		alert("pw 확인");
		pwField.value = "";
		pwChkField.value = "";
		pwField.focus();
		return false;
	} else if (isEmpty(nameField)) {
		alert("이름 확인");
		nameField.value = "";
		nameField.focus();
		return false;
	} else if (isEmpty(addrField)) {
		alert("거주지 확인");
		addrField.value = "";
		addrField.focus();
		return false;
	} else if (isEmpty(imgField)
			|| (isNotType(imgField, ".png") && isNotType(imgField, ".gif") && isNotType(
					imgField, ".jpg"))) {
		alert("사진 똑바로");
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
		alert("id 확인");
		idField.value = "";
		idField.focus();
		return false;
	} else if (isEmpty(pwField)) {
		alert("pw 확인");
		pwField.value = "";
		pwField.focus();
		return false;
	}
	return true;
}