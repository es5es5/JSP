function deleteMenu(n){
	var ok = confirm("진짜 지워?");
	
	if(ok){
		location.href = "MenuDeleteController?sm_no="+n;
	}
}

function updateMenu(p, n) {
	var p2 = prompt("수정할 가격", p);
	if (p2 != null && p2 != "") {
		location.href = "MenuUpdateController?sm_price=" + p2 + "&sm_no=" + n;
	}
}

function searchMenu(n) {
	var s = prompt("검색어", n);

	location.href = "MenuSearchController?sm_name=" + s;
}

function mrCheck() {
	var nameField = document.mrForm.sm_name;
	var priceField = document.mrForm.sm_price;
	var imgField = document.mrForm.sm_img;
	var descField = document.mrForm.sm_desc;

	if (isEmpty(nameField)) {
		alert("메뉴명 확인");
		nameField.focus();
		return false;
	} else if (isEmpty(priceField) || isNotNumber(priceField)) {
		alert("가격 확인");
		priceField.focus();
		return false;
	} else if (isEmpty(imgField)
			|| (isNotType(imgField, ".png") && isNotType(imgField, ".gif") && isNotType(
					imgField, ".jpg"))) {
		alert("사진 확인");
		imgField.value = "";
		imgField.focus();
		return false;
	} else if (isEmpty(descField)) {
		alert("설명 확인");
		descField.focus();
		return false;
	}

	return true;
}
