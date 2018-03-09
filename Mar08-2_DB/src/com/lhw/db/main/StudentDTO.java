package com.lhw.db.main;

public class StudentDTO {
	private String name;
	private int age;

	public StudentDTO() {
		// TODO Auto-generated constructor stub
	}

	public StudentDTO(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
