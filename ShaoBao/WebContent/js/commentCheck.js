function cmtCheck() {
	var titleField = document.cmtWriteForm.title;
	var txtField = document.cmtWriteForm.txt;

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