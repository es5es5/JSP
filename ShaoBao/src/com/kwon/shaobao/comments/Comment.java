package com.kwon.shaobao.comments;

import java.util.Date;

public class Comment {
	private int sc_no;
	private String sc_title;
	private String sc_txt;
	private Date sc_date;

	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(int sc_no, String sc_title, String sc_txt, Date sc_date) {
		super();
		this.sc_no = sc_no;
		this.sc_title = sc_title;
		this.sc_txt = sc_txt;
		this.sc_date = sc_date;
	}

	public int getSc_no() {
		return sc_no;
	}

	public void setSc_no(int sc_no) {
		this.sc_no = sc_no;
	}

	public String getSc_title() {
		return sc_title;
	}

	public void setSc_title(String sc_title) {
		this.sc_title = sc_title;
	}

	public String getSc_txt() {
		return sc_txt;
	}

	public void setSc_txt(String sc_txt) {
		this.sc_txt = sc_txt;
	}

	public Date getSc_date() {
		return sc_date;
	}

	public void setSc_date(Date sc_date) {
		this.sc_date = sc_date;
	}

}
