function goJoin(){
	location.href = "MemberJoinController";
}

function logout(){
	var ok = confirm("ÁøÂ¥?");
	if(ok) {
		location.href = "MemberLogoutController";
	}
}