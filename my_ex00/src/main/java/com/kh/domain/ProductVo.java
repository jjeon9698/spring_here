package com.kh.domain;

public class ProductVo {
	private String product_Name;
	private int product_price;
	
	public ProductVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductVo(String product_Name, int product_price) {
		super();
		this.product_Name = product_Name;
		this.product_price = product_price;
	}

	public String getProduct_Name() {
		return product_Name;
	}

	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	@Override
	public String toString() {
		return "ProductVo [product_Name=" + product_Name + ", product_price=" + product_price + "]";
	}	
	
}
