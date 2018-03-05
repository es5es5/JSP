package com.lhw.s.main;

public class Student {
	private String name;
	private String no;
	private String j1;
	private String j2;
	private String addr;
	private String img;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String name, String no, String j1, String j2, String addr, String img) {
		super();
		this.name = name;
		this.no = no;
		this.j1 = j1;
		this.j2 = j2;
		this.addr = addr;
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getJ1() {
		return j1;
	}
	public void setJ1(String j1) {
		this.j1 = j1;
	}
	public String getJ2() {
		return j2;
	}
	public void setJ2(String j2) {
		this.j2 = j2;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
	

}
