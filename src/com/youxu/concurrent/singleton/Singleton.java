package com.youxu.concurrent.singleton;

//当我们只想访问静态成员变量时，也会创建instence实例
public class Singleton {
	public static int STATUS = 1;
	private Singleton() {
		System.out.println("Singleton is created");
	}
	//在类初始化时就会创建类的实例，保证唯一性
	private static Singleton instence = new Singleton();
	public static Singleton getInstence() {
		return instence;
	}
}
