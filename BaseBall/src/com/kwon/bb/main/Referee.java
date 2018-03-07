package com.kwon.bb.main;

import java.util.HashSet;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Referee {
	private char[] ans;

	private static final Referee R = new Referee();

	private Referee() {
		while (true) {
			int a = new Random().nextInt(1000);
			String a2 = String.format("%03d", a);
			ans = a2.toCharArray();

			// 중복 답 없애기
			HashSet<Character> ans2 = new HashSet<>();
			for (Character cc : ans) {
				ans2.add(cc);
			}
			if (ans2.size() == 3) {
				break;
			}
		}
	}

	public static Referee getR() {
		return R;
	}

	public void judge(HttpServletRequest request, HttpServletResponse response) {
		String b = request.getParameter("b");
		char[] clientAns = b.toCharArray();

		int strike = 0;
		int ball = 0;

		// 스트라이크
		for (int i = 0; i < clientAns.length; i++) {
			if (clientAns[i] == ans[i]) {
				strike++;
				clientAns[i] = 's'; // 스트라이크 된거는 s로 바꿔놔서 볼에서 판단 안 함
			}
		}

		for (int i = 0; i < clientAns.length; i++) {
			for (int j = 0; j < ans.length; j++) {
				if (clientAns[i] == ans[j]) {
					ball++;
					break;
				}
			}
		}

		System.out.println("s : " + strike);
		System.out.println("b : " + ball);

		System.out.println("=====");
		for (char c : ans) {
			System.out.println(c);
		}

		System.out.println("-----");

		for (char c : clientAns) {
			System.out.println(c);
		}

	}

}
