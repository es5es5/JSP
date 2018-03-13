package com.kwon.shaobao.menu;

public class Menu {
	private int sm_no;
	private String sm_name;
	private String sm_desc;
	private String sm_price;
	private String sm_img;

	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public Menu(int sm_no, String sm_name, String sm_desc, String sm_price, String sm_img) {
		super();
		this.sm_no = sm_no;
		this.sm_name = sm_name;
		this.sm_desc = sm_desc;
		this.sm_price = sm_price;
		this.sm_img = sm_img;
	}

	public int getSm_no() {
		return sm_no;
	}

	public void setSm_no(int sm_no) {
		this.sm_no = sm_no;
	}

	public String getSm_name() {
		return sm_name;
	}

	public void setSm_name(String sm_name) {
		this.sm_name = sm_name;
	}

	public String getSm_desc() {
		return sm_desc;
	}

	public void setSm_desc(String sm_desc) {
		this.sm_desc = sm_desc;
	}

	public String getSm_price() {
		return sm_price;
	}

	public void setSm_price(String sm_price) {
		this.sm_price = sm_price;
	}

	public String getSm_img() {
		return sm_img;
	}

	public void setSm_img(String sm_img) {
		this.sm_img = sm_img;
	}

}
