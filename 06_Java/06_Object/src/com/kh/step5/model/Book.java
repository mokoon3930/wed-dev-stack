package com.kh.step5.model;

public class Book {
	
	/*
	 *  캡슐화(Encapsulation)
	 *  - 정보은닉 : 외부에서 객체 접근 하는데 있어서 정보를 숨기고 객체의 연산을 통해서만 접근이 가능하겍 하는 것
	 *  - 객체 내 정보손상, 오용을 방지하고, 데이터가 변경 되어도 다른 객체에 영향 X
	 *  - 독립서이 좋고, 하나의 모듈처럼 사용 가능
	 *  
	 *   SRP (단일 책임 원칙)
	 *   - 한 클래스는 하나의 책임만 갖는다
	 *   - 캡슐화를 통해 각 캑체가 자신의 책임만 갖도록 유고
	 * */
	private String title;
	private int price;
	private double discount;
	private String author;
	
	public Book() {}

	public Book(String title, int price, double discount, String author) {
		this.title = title;
		this.price = price;
		this.discount = discount;
		this.author = author;
	}

	// getter, setter 
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount = (discount);
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", discount=" + discount + ", author=" + author + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
