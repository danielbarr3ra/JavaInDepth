package com.semanticsquare.concurrency;

import java.util.concurrent.TimeUnit;

public class StopThread {
	private static volatile boolean stop;
	public static void main(String[] args) throws InterruptedException{
		new Thread(new Runnable() {
			public void run() {
				while(!stop) {System.out.println("In while");}
			}
		}).start();
	TimeUnit.MILLISECONDS.sleep(5);
	System.out.println("------------------heay======================");
	TimeUnit.MILLISECONDS.sleep(5);
	stop = true;
	}
}
