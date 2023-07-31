package com.fssa.spartansmt.model;

public class Product {
	
	private int product_id;
	private String product_title;
	private double product_price;
	private String product_image;
	private int store_id;
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_title() {
		return product_title;
	}
	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public Product(String product_title, double product_price, String product_image, int store_id) {
		this.product_title = product_title;
		this.product_price = product_price;
		this.product_image = product_image;
		this.store_id = store_id;
	}
	
	public Product() {
		
	}

}
