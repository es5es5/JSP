// ��ȿ�� �˻� �޼ҵ�

// <input> ���� �ִ��� ������ �˻�
function isEmpty(field) {
	return (!field.value) ? true : false;
}

// <input>, ���� ���� �־��� ��
// �� input�� �� ������ �� ���� �� ���� ������ true
function isLessThan(field, charCount) {
	return (field.value.length < charCount);
}

// <input> �� �־��� ��
// �� input�� �ѱ� ������ true
function hangul(idField) {
	var t = "1234567890qwertyuiopasdfghjklzxcvbnm";
	for (var i = 0; i < idField.value.length; i++) {
		if (t.indexOf(idField.value.toLowerCase()[i]) == -1) {
			return true;
		}
	}
}

// <input>, ���ڿ� ��Ʈ ������
// �� input�� ���ڿ��� �ִ� ���ڰ� ������ true
// �״ϱ� �ʼ��� �־���ϴ� �� �� ���� true ��ȯ
function notContains(field, charSet) {
	for (var i = 0; i < charSet.length; i++) {
		if (field.value.indexOf(charSet[i]) != -1) {
			return false;
		}
	}
	return true;
}