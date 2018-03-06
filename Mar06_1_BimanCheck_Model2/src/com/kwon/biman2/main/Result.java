package com.kwon.biman2.main;

public class Result {
	private double bmi;
	private String result;
	
	public Result() {
		// TODO Auto-generated constructor stub
	}

	public Result(double bmi, String result) {
		super();
		this.bmi = bmi;
		this.result = result;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
	
}
