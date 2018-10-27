package com.youxu.concurrent.future;

public class FutureData implements Data {

	protected RealData realData = null;
	protected Boolean isReady = false;
	public synchronized void setRealData(RealData realData) {
		if(isReady) {
			return;
		}
		this.realData = realData;
		isReady = true;
		notifyAll();
	}
	@Override
	public synchronized String getData() {
		while(!isReady) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		return realData.result;
	}

}
