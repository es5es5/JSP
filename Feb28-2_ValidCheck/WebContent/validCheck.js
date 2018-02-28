// 유효성 검사 메소드

// <input> 글자 있는지 없는지 검사
function isEmpty(field) {
	return (!field.value) ? true : false;
}

// <input>, 글자 수를 넣었을 때
// 그 input에 쓴 내용이 그 글자 수 보다 낮으면 true
function isLessThan(field, charCount) {
	return (field.value.length < charCount);
}

// <input> 을 넣었을 때
// 그 input에 한글 있으면 true
function hangul(idField) {
	var t = "1234567890qwertyuiopasdfghjklzxcvbnm";
	for (var i = 0; i < idField.value.length; i++) {
		if (t.indexOf(idField.value.toLowerCase()[i]) == -1) {
			return true;
		}
	}
}

// <input>, 문자열 세트 넣으면
// 그 input에 문자열에 있는 글자가 없으면 true
// 그니깐 필수로 넣어야하는 걸 안 쓰면 true 반환
function notContains(field, charSet) {
	for (var i = 0; i < charSet.length; i++) {
		if (field.value.indexOf(charSet[i]) != -1) {
			return false;
		}
	}
	return true;
}