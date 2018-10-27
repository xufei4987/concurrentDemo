package com.youxu.concurrent.future;

public class Client {
	public Data requset(final String queryStr) {
		final FutureData futureData = new FutureData();
		new Thread() {
			public void run() {
				RealData realData = new RealData(queryStr);
				futureData.setRealData(realData);
			}
		}.start();
		return futureData;
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		Data data = client.requset("name");
		System.out.println("请求完毕");
		try {
			//这里可以用一个sleep代替对其他业务逻辑的处理
			//在处理这些业务逻辑的过程中，RealData被创建，从而充分利用了等待时间
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("数据="+data.getData());
	}
}
