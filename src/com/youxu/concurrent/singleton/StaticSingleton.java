package com.youxu.concurrent.singleton;

public class StaticSingleton {
	public static int STATUS = 1;
	private StaticSingleton() {
		System.out.println("StaticSingleton is created");
	}
	//在类初始化时就会创建类的实例，保证唯一性
	private static class SingletonHolder{
		private static StaticSingleton instence = new StaticSingleton();
	}
	//没有synchronized关键字，高并发下保证性能
	public static StaticSingleton getInstence() {
		return SingletonHolder.instence;
	}
}
