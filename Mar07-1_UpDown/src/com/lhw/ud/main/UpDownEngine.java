package com.lhw.ud.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 실제 계산하는 Model
//		멤버 변수가 없으면 : static method 기반으로

//		멤버 변수가 있으면
//			Model이 하나만 필요한지(대부분) : Singleton 패턴
//			Model이 여러개 필요한지(잘 없음) : 평범한 자바 클래스

// 원래 Java
//		static멤버는 프로그램 실행하자마자 만들어짐

// 현재 상황
// 		static멤버이지만
//		클라이언트들 중에 한 명이 최초로 사용할 때 만들어짐

// 유일한 객체가 필요할 때 : Singleton 패턴
public class UpDownEngine {
	private int ans;
	private String m;

	// 2. 내부에서 객체 하나 만들어 놓고
	private static final UpDownEngine Engine = new UpDownEngine();

	// 1. 외부에서 객체 생성 못 하게 (private)
	private UpDownEngine() {
		ans = new Random().nextInt(10001);
		Date now = new Date();

		// Date에서 mm만 빼서 String으로
		SimpleDateFormat sdf = new SimpleDateFormat("mm");
		m = sdf.format(now);

	}

	public void pickNewAns(HttpServletRequest request, HttpServletResponse response) {
		// 누군가가 답을 말 하면 그 때의 mm
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("mm");
		String m2 = sdf.format(now);
		if (!m.equals(m2)) {
			m = m2;
			ans = new Random().nextInt(10001);
			request.setAttribute("notice", "(새 답이 뽑힘)");
		}

	}

	// 3. 그 객체 외부에서 가져다 쓸 수 있게 getter만들기
	public static UpDownEngine getEngine() {
		return Engine;
	}

	public void play(HttpServletRequest request, HttpServletResponse response) {
		pickNewAns(request, response);
		System.out.println(ans);
		int n = Integer.parseInt(request.getParameter("n"));

		if (ans == n) {
			request.setAttribute("r", "정답");
		} else if (ans > n) {
			request.setAttribute("r", "Up");
		} else {
			request.setAttribute("r", "Down");
		}
	}
}
