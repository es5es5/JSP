function searchMenu(n){
	var s = prompt("�˻���", n);
	
	location.href = "MenuSearchController?sm_name="+s;
}

function mrCheck() {
	var nameField = document.mrForm.sm_name;
	var priceField = document.mrForm.sm_price;
	var imgField = document.mrForm.sm_img;
	var descField = document.mrForm.sm_desc;

	if (isEmpty(nameField)) {
		alert("�޴��� Ȯ��");
		nameField.focus();
		return false;
	} else if (isEmpty(priceField) || isNotNumber(priceField)) {
		alert("���� Ȯ��");
		priceField.focus();
		return false;
	} else if (isEmpty(imgField)
			|| (isNotType(imgField, ".png") && isNotType(imgField, ".gif") && isNotType(
					imgField, ".jpg"))) {
		alert("���� Ȯ��");
		imgField.value = "";
		imgField.focus();
		return false;
	} else if (isEmpty(descField)) {
		alert("���� Ȯ��");
		descField.focus();
		return false;
	} 

	return true;
}
