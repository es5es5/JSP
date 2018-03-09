function cmtCheck(){
	var titleField = document.cmtWriteForm.title;
	var txtField = document.cmtWriteForm.txt;

	if(isEmpty(titleField)){
		alert("등록 다시");
		
		titleField.focus();
		return false;
	}else if(isEmpty(txtField)){
		alert("등록 다시");
		txtField.focus();
		return false;
	}
	
	return true;
}