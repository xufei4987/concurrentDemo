package com.youxu.concurrent.singleton;
//延迟加载，解决了Singleton的问题
public class LazySingleton {
	public static int STATUS = 1;
	private LazySingleton() {
		System.out.println("LazySingleton is created");
	}
	private static LazySingleton instence = null;
	//使用同步关键字保证线程安全，但在高并发的情况下性能不能得到保证
	public static synchronized LazySingleton getInstence() {
		if(instence == null) {
			instence = new LazySingleton();
		}
		return instence;
	}
	
}
