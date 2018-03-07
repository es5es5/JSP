function check(){
	var bField = document.f.b;
	
	if(isEmpty(bField) || isNotNumber(bField) || lessThan(bField, 3)){
		alert("숫자 다시");
		bField.value = "";
		bField.focus();
		return false;
	}
	
	return true;
}