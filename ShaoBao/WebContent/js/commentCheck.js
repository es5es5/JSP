function delCmtCheck(sc_no){
	var ok = confirm("��¥?");
	
	if(ok){
		location.href 
			= "CommentsDeleteController?sc_no=" + sc_no;
	}
}

function cmtCheck() {
	var titleField = document.cmtWriteForm.sc_title;
	var txtField = document.cmtWriteForm.sc_txt;

	if (isEmpty(titleField)) {
		alert("���� Ȯ��");
		titleField.focus();
		return false;
	} else if (isEmpty(txtField)) {
		alert("���� Ȯ��");
		txtField.focus();
		return false;
	}

	return true;
}
function searchCmtCheck() {
	var searchField = document.searchForm.s;

	if (isEmpty(searchField)) {
		alert("���� Ȯ��");
		searchField.focus();
		return false;
	}

	return true;
}