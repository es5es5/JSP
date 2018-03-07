package com.lhw.ud.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ���� ����ϴ� Model
//		��� ������ ������ : static method �������

//		��� ������ ������
//			Model�� �ϳ��� �ʿ�����(��κ�) : Singleton ����
//			Model�� ������ �ʿ�����(�� ����) : ����� �ڹ� Ŭ����

// ���� Java
//		static����� ���α׷� �������ڸ��� �������

// ���� ��Ȳ
// 		static���������
//		Ŭ���̾�Ʈ�� �߿� �� ���� ���ʷ� ����� �� �������

// ������ ��ü�� �ʿ��� �� : Singleton ����
public class UpDownEngine {
	private int ans;
	private String m;

	// 2. ���ο��� ��ü �ϳ� ����� ����
	private static final UpDownEngine Engine = new UpDownEngine();

	// 1. �ܺο��� ��ü ���� �� �ϰ� (private)
	private UpDownEngine() {
		ans = new Random().nextInt(10001);
		Date now = new Date();

		// Date���� mm�� ���� String����
		SimpleDateFormat sdf = new SimpleDateFormat("mm");
		m = sdf.format(now);

	}

	public void pickNewAns(HttpServletRequest request, HttpServletResponse response) {
		// �������� ���� �� �ϸ� �� ���� mm
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("mm");
		String m2 = sdf.format(now);
		if (!m.equals(m2)) {
			m = m2;
			ans = new Random().nextInt(10001);
			request.setAttribute("notice", "(�� ���� ����)");
		}

	}

	// 3. �� ��ü �ܺο��� ������ �� �� �ְ� getter�����
	public static UpDownEngine getEngine() {
		return Engine;
	}

	public void play(HttpServletRequest request, HttpServletResponse response) {
		pickNewAns(request, response);
		System.out.println(ans);
		int n = Integer.parseInt(request.getParameter("n"));

		if (ans == n) {
			request.setAttribute("r", "����");
		} else if (ans > n) {
			request.setAttribute("r", "Up");
		} else {
			request.setAttribute("r", "Down");
		}
	}
}
