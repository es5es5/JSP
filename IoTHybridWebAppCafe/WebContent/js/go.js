function goJoin() {
	location.href = "MemberJoinController";
}

function logout() {
	var ok = confirm("��¥?");
	if (ok) {
		location.href = "MemberLogoutController";
	}
}

function goUpdateMember() {
	location.href = "MemberUpdateController";
}