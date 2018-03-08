package com.lhw.ct.jstlc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Jegob {

	public static void Calc(HttpServletRequest request, HttpServletResponse response) {
		int x = Integer.parseInt(request.getParameter("x"));
		int z = x * x;
		request.setAttribute("z", z);
		
		ArrayList<Dog> dogs = new ArrayList<>();
		dogs.add(new Dog("�ǻ�", 1));
		dogs.add(new Dog("�ǻ߻ǻ�", 2));
		dogs.add(new Dog("�ǻ߻ǻ߻ǻ�", 3));
		dogs.add(new Dog("�ǻ߻ǻ߻ǻ߻ǻ�", 4));
		
		request.setAttribute("dogs", dogs);
		
	}

}
