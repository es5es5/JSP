function check(){
	var nField = document.f.n;
	if(isEmpty(nField) || isNotNumber(nField)){
		alert("���� �ٽ�");
		nField.value = "";
		nField.focus();
		return false;
	}
	
	return true;
}