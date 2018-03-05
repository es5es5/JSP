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

// <input> 두 개 넣었을 때
// 그 두개 다르면 true
// 비번 확인용

function notEquals(field1, field2) {
	return (field1.value != field2.value);
}

// <input> 넣었을 때
// 거기에 숫자 아닌게 있으면 true

function noNumber(field){
	return isNan(field.value);
}

// <input type="file"> , 확장자 넣었을 때
// 그 파일이 아니면 true
// 그 파일이 맞으면 false

function isNotType(field, type){
	field.value // 업로드 하려는 파일명
	return (field.value.toLowerCase().indexOf(type) == -1);
}