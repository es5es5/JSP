function check() {
	var nField = document.f.n;
	var noField = document.f.no;
	var j1Field = document.f.j1;
	var j2Field = document.f.j2;
	var aField = document.f.a;
	var imgField = document.f.img;

	if (isEmpty(nField)) {
		alert("�̸� �ȹٷ�");
		nField.value = "";
		nField.focus();
		return false;
	} else if (isEmpty(noField) || lessThan(noField, 9)) {
		alert("�й� �ȹٷ�");
		noField.value = "";
		noField.focus();
		return false;
	} else if (isEmpty(j1Field) 
			|| isNotNumber(j1Field) 
			|| lessThan(j1Field, 6)
			|| isEmpty(j2Field) || isNotNumber(j2Field) || lessThan(j2Field, 7)) {
		alert("�ֹι�ȣ �ȹٷ�");
		j1Field.value = "";
		j2Field.value = "";
		j1Field.focus();
		return false;
	} else if (isEmpty(aField)) {
		alert("�ּ� �ȹٷ�");
		aField.value = "";
		aField.focus();
		return false;
	} else if (isEmpty(imgField)
			|| (isNotType(imgField, ".png") && isNotType(imgField, ".gif")
					&& isNotType(imgField, ".jpg") && isNotType(imgField,
					".bmp"))) {
		alert("���� �ȹٷ�");
		imgField.value = "";
		imgField.focus();
		return false;
	}
	return true;
}