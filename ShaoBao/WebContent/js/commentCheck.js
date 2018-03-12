function delCmtCheck(sc_no){
	var ok = confirm("진짜?");
	
	if(ok){
		location.href 
			= "CommentsDeleteController?sc_no=" + sc_no;
	}
}

function cmtCheck() {
	var titleField = document.cmtWriteForm.sc_title;
	var txtField = document.cmtWriteForm.sc_txt;

	if (isEmpty(titleField)) {
		alert("제목 확인");
		titleField.focus();
		return false;
	} else if (isEmpty(txtField)) {
		alert("내용 확인");
		txtField.focus();
		return false;
	}

	return true;
}
function searchCmtCheck() {
	var searchField = document.searchForm.s;

	if (isEmpty(searchField)) {
		alert("제목 확인");
		searchField.focus();
		return false;
	}

	return true;
}