package com.lhw.s.main;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class PhotoUploader {
	public static void upload(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getServletContext().getRealPath("img");
		try {
			MultipartRequest mr = new MultipartRequest(request, path, 31457280, "euc-kr",
					new DefaultFileRenamePolicy());

			String fileName = mr.getFilesystemName("img");
			fileName = URLEncoder.encode(fileName, "euc-kr");
			fileName = fileName.replace("+", " ");

			String n = mr.getParameter("n");
			String no = mr.getParameter("no");
			String j1 = mr.getParameter("j1");
			String j2 = mr.getParameter("j2");
			String a = mr.getParameter("a");
			
			Student s = new Student(n, no, j1, j2, a, fileName);
			
			request.setAttribute("ss", s);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
