package com.lhw.rsp.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RSPEngine {
	
	public static void play(HttpServletRequest request, HttpServletResponse response) {
		int myHand = Integer.parseInt(request.getParameter("hand"));
		
		Random r = new Random();
		int comHand = r.nextInt(3) + 1;
		
		int result = myHand - comHand;
		
		if(result == 0) {
			request.setAttribute("result", "¹«");
		} else if (result == -1) {
			request.setAttribute("result", "½Â");
		} else if (result == 1){
			request.setAttribute("result", "ÆÐ");
		}
		
		String[] hand = {
				"",
				"img/r.png",
				"img/s.png",
				"img/p.png",
				};
		
		request.setAttribute("myHand", hand[myHand]);
		request.setAttribute("comHand", hand[comHand]);
	}
}
