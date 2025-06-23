package com.kh.inheritance.model.parent;


/*
 * 모든 클래스 Object 크래스의 후손
 * * 즉, 최상위 클ㄹ래스 항상 Object
 * 
 * */
public class Product {
	
	public String brand;
	String pCode;
	protected String name;
	private int price;
	
	public Product() {
	}

	public Product(String brand, String pCode, String name, int price) {
		this.brand = brand;
		this.pCode = pCode;
		this.name = name;
		this.price = price;
	}

	

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPcode() {
		return pCode;
	}

	public void setPcode(String pcode) {
		this.pCode = pcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [brand=" + brand + ", pcode=" + pCode + ", name=" + name + ", price=" + price + "]";
	}
}
