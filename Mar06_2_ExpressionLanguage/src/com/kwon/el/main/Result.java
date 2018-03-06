package com.kwon.el.main;

public class Result {
	private double avg;
	private String what;

	public Result() {
		// TODO Auto-generated constructor stub
	}

	public Result(double avg, String what) {
		super();
		this.avg = avg;
		this.what = what;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public String getWhat() {
		return what;
	}

	public void setWhat(String what) {
		this.what = what;
	}

}
