// JavaScript를 주로 사용하는 형태
// 	1. 함수 정의
//	2. 이벤트 걸고싶은 HTML DOM객체의 onXXX=""에서 호출

alert("안녕안녕");

// 함수
function test(a, b) {
	// alert("함수1");
	// alert(a);
	// alert(b);
}

function add(x, y) {
	var z = x + y;
	return z;
}
var a = add(23, 14);

// test("테스트1인자","테스트2인자");
// alert(a);

function bb() {
	for (var i = 0; i < 5; i++) {
		alert(i);
	}
}

function aaa() {
	// 배열
	var ar = [ 1, 2, 3 ];

	// 객체
	var d = {
		name : "뽀삐",
		age : 1
	};

	// 쓸만한 것들
}