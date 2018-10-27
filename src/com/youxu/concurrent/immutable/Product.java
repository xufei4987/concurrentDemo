package com.youxu.concurrent.immutable;
//不变模式
public final class Product {
	//final保证不被二次赋值
	private final String no;
	private final String name;
	private final double price;
	//初始化后就不能被修改
	public Product(String no, String name, double price) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
	}
	public String getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	
	
}
