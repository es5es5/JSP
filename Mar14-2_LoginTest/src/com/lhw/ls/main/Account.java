package com.lhw.ls.main;

public class Account {
	private String l_id;
	private String l_pw;
	private String l_name;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String l_id, String l_pw, String l_name) {
		super();
		this.l_id = l_id;
		this.l_pw = l_pw;
		this.l_name = l_name;
	}

	public String getL_id() {
		return l_id;
	}

	public void setL_id(String l_id) {
		this.l_id = l_id;
	}

	public String getL_pw() {
		return l_pw;
	}

	public void setL_pw(String l_pw) {
		this.l_pw = l_pw;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

}
