function check(){
	var nField = document.f.n;
	if(isEmpty(nField) || isNotNumber(nField)){
		alert("숫자 다시");
		nField.value = "";
		nField.focus();
		return false;
	}
	
	return true;
}