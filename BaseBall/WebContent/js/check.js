function check(){
	var bField = document.f.b;
	
	if(isEmpty(bField) || isNotNumber(bField) || lessThan(bField, 3)){
		alert("���� �ٽ�");
		bField.value = "";
		bField.focus();
		return false;
	}
	
	return true;
}